package com.pos.lms.mobile.ui.roadmap.ecp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.pos.lms.core.data.Resource
import com.pos.lms.core.domain.model.EventRoadmap
import com.pos.lms.core.utils.PreferenceEntity
import com.pos.lms.core.utils.UserPreference
import com.pos.lms.mobile.R
import com.pos.lms.mobile.databinding.ECPFragmentBinding
import com.pos.lms.mobile.helper.CurrentDate
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber
/**
 * Created by Muhammad Zaim Milzam on 15/02/21.
 * linkedin : Muhammad Zaim Milzam
 */
@AndroidEntryPoint
class ECPFragment : Fragment() {

    companion object {
        const val EXTRA_DATA = "extra_data"
    }

    private val viewModel: ECPViewModel by viewModels()
    private lateinit var adapterPromosi: ECPPromosiAdapter
    private lateinit var adapterRotasi: ECPRotasiAdapter

    private var dataBundle: EventRoadmap? = null
    private lateinit var mPreference: UserPreference
    private lateinit var mPreferenceEntity: PreferenceEntity

    private var _binding: ECPFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ECPFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bundle = arguments
        if (bundle != null) {
            dataBundle = bundle.getParcelable(EXTRA_DATA) as EventRoadmap?
        }

        mPreference = UserPreference(requireActivity())
        mPreferenceEntity = mPreference.getPref()

        // method
        setupObserver(dataBundle)
        setupRecycleview()

    }

    private fun setupRecycleview() {
        binding.apply {
            content.apply {
                adapterRotasi = ECPRotasiAdapter()
                rvRotation.setHasFixedSize(true)
                rvRotation.layoutManager =
                    LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
                rvRotation.adapter = adapterRotasi

                adapterPromosi = ECPPromosiAdapter()
                rvPromotion.setHasFixedSize(true)
                rvPromotion.layoutManager =
                    LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
                rvPromotion.adapter = adapterPromosi
            }

        }

    }

    private fun setupObserver(dataBundle: EventRoadmap?) {

        val eventCode = dataBundle?.eventCode
        val personalNumber = mPreferenceEntity.username
        val begda = CurrentDate.getToday()
        val enda = CurrentDate.getToday()


        viewModel.ecpRotasi(eventCode.toString(), personalNumber.toString(), begda, enda)
            .observe(requireActivity(), { data ->
                if (data != null) {
                    when (data) {
                        is Resource.Loading -> binding.progressBarProposal.visibility = View.VISIBLE
                        is Resource.Success -> {
                            binding.progressBarProposal.visibility = View.GONE
                            adapterRotasi.setData(data.data)
                            Timber.tag(tag).d("observer_curiculum_adapter ${data.data}")
                        }
                        is Resource.Error -> {
                            val loginMessage = getString(R.string.something_wrong)
                            binding.progressBarProposal.visibility = View.GONE
                            Toast.makeText(requireContext(), loginMessage, Toast.LENGTH_SHORT)
                                .show()
                        }
                    }

                }

            })

        viewModel.ecpPromosi(eventCode.toString(), personalNumber.toString(), begda, enda)
            .observe(requireActivity(), { data ->
                if (data != null) {
                    when (data) {
                        is Resource.Loading -> binding.progressBarProposal.visibility = View.VISIBLE
                        is Resource.Success -> {
                            binding.progressBarProposal.visibility = View.GONE
                            adapterPromosi.setData(data.data)
                            Timber.tag(tag).d("observer_curiculum_adapter ${data.data}")
                        }
                        is Resource.Error -> {
                            val loginMessage = getString(R.string.something_wrong)
                            binding.progressBarProposal.visibility = View.GONE
                            Toast.makeText(requireContext(), loginMessage, Toast.LENGTH_SHORT)
                                .show()
                        }
                    }

                }

            })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null

    }

}