package com.pos.lms.mobile.ui.student.detailStudent.session.detail.absensi

import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Base64
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.viewbinding.library.fragment.viewBinding
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONObjectRequestListener
import com.pos.lms.core.data.Resource
import com.pos.lms.core.domain.model.SessionList
import com.pos.lms.core.domain.model.TrainerUser
import com.pos.lms.core.utils.PreferenceEntity
import com.pos.lms.core.utils.UserPreference
import com.pos.lms.mobile.R
import com.pos.lms.mobile.databinding.AbsensiFragmentBinding
import com.pos.lms.mobile.ui.student.detailStudent.forum.ForumFragment
import com.pos.lms.mobile.util.ErrorLog
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.json.JSONObject
import timber.log.Timber

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class AbsensiFragment : Fragment() {

    companion object {
        const val EXTRA_DATA = "extra_data"
        const val USER_ROLE = "user_role"
    }

    private val viewModel: AbsensiViewModel by viewModels()
    private val binding: AbsensiFragmentBinding by viewBinding()

    private lateinit var mPreference: UserPreference
    private lateinit var mPreferenceEntity: PreferenceEntity

    private var sessionId: String? = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.absensi_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mPreference = UserPreference(requireContext())
        mPreferenceEntity = mPreference.getPref()

        val bundle = arguments
        if (bundle != null) {
            val userRole = bundle.getString(ForumFragment.USER_ROLE)
            if (userRole == "STUDENT") {
                val dataBundle = bundle.getParcelable(EXTRA_DATA) as SessionList?
                sessionId = dataBundle?.sessionId

            } else {
                val dataBundle = bundle.getParcelable(EXTRA_DATA) as TrainerUser?
                observasiTrainer(dataBundle)

            }


        }

        val parId = mPreferenceEntity.parId

//        observerAbsensi(sessionId, parId)

        obserTemporarySTudent()

    }

    private fun observasiTrainer(dataBundle: TrainerUser?) {

    }

    private fun observerAbsensi(sessionId: String?, parId: Int?) {
        viewModel.getAbsensi(
            parId.toString(),
            sessionId.toString()
        ).observe(viewLifecycleOwner, { data ->
            if (data != null) {
                when (data) {
                    is Resource.Loading -> binding.progressBar2.visibility = View.VISIBLE
                    is Resource.Success -> {
                        binding.progressBar2.visibility = View.GONE
                        Timber.tag(tag).d("Bsae64Response ${data.data}")
                    }
                    is Resource.Error -> {
                        val loginMessage = getString(R.string.something_wrong)
                        binding.progressBar2.visibility = View.GONE
                        Toast.makeText(requireContext(), loginMessage, Toast.LENGTH_SHORT).show()
                    }
                }

            }

        })
    }

    private fun obserTemporarySTudent() {
        val token = mPreferenceEntity.token
        val parId = mPreferenceEntity.parId.toString()
        val sesid = sessionId

        Timber.d("Sess_id : $sesid")

        AndroidNetworking.post("https://pos-lms.digitalevent.id/lms/api/attendance/qr")
            .addHeaders("Accept", "application/json")
            .addHeaders("Content-type", "multipart/form-data")
            .addHeaders("Authorization", "Bearer $token")
            .addBodyParameter("parid", parId)
            .addBodyParameter("sesid", sesid)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener {
                override fun onResponse(response: JSONObject?) {
                    if (response?.length() ?: 0 > 0) {
                        val data = response?.getString("data")
                        Timber.d("image : $data")
                        showImage(data)
                    }
                }

                override fun onError(anError: ANError?) {
                    ErrorLog.errorLog("ABSENFRAGMENT", anError, "qr_absensi")
                }

            })
    }


    private fun showImage(data: String?) {
        val imageBytes = Base64.decode(data, Base64.DEFAULT)
        val decodedImage = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.size)
        binding.ivQrCode.setImageBitmap(decodedImage)
    }


}