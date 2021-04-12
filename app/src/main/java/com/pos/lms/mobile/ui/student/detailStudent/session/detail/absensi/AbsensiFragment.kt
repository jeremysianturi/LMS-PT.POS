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
import com.pos.lms.core.data.Resource
import com.pos.lms.core.domain.model.SessionList
import com.pos.lms.core.utils.PreferenceEntity
import com.pos.lms.core.utils.UserPreference
import com.pos.lms.mobile.R
import com.pos.lms.mobile.databinding.AbsensiFragmentBinding
import com.pos.lms.mobile.ui.student.detailStudent.session.detail.schedule.ScheduleFragment
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class AbsensiFragment : Fragment() {

    companion object {
        const val EXTRA_DATA = "extra_data"
    }

    private val viewModel: AbsensiViewModel by viewModels()
    private val binding: AbsensiFragmentBinding by viewBinding()
    private lateinit var mPreference: UserPreference
    private lateinit var mPreferenceEntity: PreferenceEntity

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
        var dataBundle: SessionList? = null

        if (bundle != null) {
            dataBundle = bundle.getParcelable(ScheduleFragment.EXTRA_DATA) as SessionList?
        }
        val sessionId = dataBundle?.sessionId
        val parId = mPreferenceEntity.parId

//        observerAbsensi(sessionId, parId)


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


    private fun showImage(data: String?) {
        val imageBytes = Base64.decode(data, Base64.DEFAULT)
        val decodedImage = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.size)
//        binding..setImageBitmap(decodedImage)
        binding.ivQrCode.setImageBitmap(decodedImage)
    }


}