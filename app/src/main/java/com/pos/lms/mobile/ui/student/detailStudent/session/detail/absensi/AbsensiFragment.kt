package com.pos.lms.mobile.ui.student.detailStudent.session.detail.absensi

import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Base64
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONObjectRequestListener
import com.pos.lms.core.domain.model.SessionList
import com.pos.lms.core.utils.PreferenceEntity
import com.pos.lms.core.utils.UserPreference
import com.pos.lms.mobile.databinding.AbsensiFragmentBinding
import com.pos.lms.mobile.ui.student.detailStudent.session.detail.schedule.ScheduleFragment
import dagger.hilt.android.AndroidEntryPoint
import org.json.JSONObject
import timber.log.Timber

@AndroidEntryPoint
class AbsensiFragment : Fragment() {

    companion object {
        const val EXTRA_DATA = "extra_data"
    }

    private lateinit var viewModel: AbsensiViewModel
    private lateinit var mPreference: UserPreference
    private lateinit var mPreferenceEntity: PreferenceEntity

    private var _binding: AbsensiFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = AbsensiFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mPreference = UserPreference(requireContext())
        mPreferenceEntity = mPreference.getPref()

        val bundle = arguments
        var dataBundle: SessionList? = null

        if (bundle != null) {
            dataBundle = bundle.getParcelable(ScheduleFragment.EXTRA_DATA) as SessionList?
        }

        postAbsensiTemp(dataBundle)

    }

    private fun postAbsensiTemp(dataBundle: SessionList?) {

        AndroidNetworking.post("${com.pos.lms.core.BuildConfig.API_URL}lms/api/forum")
            .addHeaders("Accept", "application/json")
            .addHeaders("Content-type", "multipart/form-data")
            .addHeaders("Authorization", "Bearer ${mPreferenceEntity.token}")
            .addBodyParameter("parid", mPreferenceEntity.parId.toString())
            .addBodyParameter("sesid", dataBundle?.sessionId)
            .setPriority(Priority.HIGH)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener {
                override fun onResponse(response: JSONObject?) {
                    val data = response?.getString("data")
                    showImage(data)
                }

                override fun onError(anError: ANError?) {
                    Toast.makeText(requireContext(), "Error", Toast.LENGTH_SHORT).show()
                    Timber.tag("ABSENSI").e("error absensi")

                }

            })

    }

    private fun showImage(data: String?) {
        val imageBytes = Base64.decode(data, Base64.DEFAULT)
        val decodedImage = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.size)
//        binding..setImageBitmap(decodedImage)
        binding.ivQrCode.setImageBitmap(decodedImage)
    }


}