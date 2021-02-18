package com.pos.lms.mobile.ui.student.detailStudent.session.detail.schedule

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.pos.lms.core.data.Resource
import com.pos.lms.core.domain.model.SessionList
import com.pos.lms.mobile.R
import com.pos.lms.mobile.databinding.ScheduleFragmentBinding
import com.pos.lms.mobile.helper.DateTimeConverter
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class ScheduleFragment : Fragment() {

    companion object {
        const val EXTRA_DATA = "extra_data"
    }

    private val viewModel: ScheduleViewModel by viewModels()

    private lateinit var adapter: ScheduleAdapter

    private var _binding: ScheduleFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ScheduleFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bundle = arguments
        var dataBundle: SessionList? = null

        if (bundle != null) {
            dataBundle = bundle.getParcelable(EXTRA_DATA) as SessionList?
        }

        // function
        setupObserver(dataBundle)
        dataBundle?.let { setupData(it) }
        buildRecycleView()

    }

    private fun setupData(data: SessionList) {
        binding.apply {
            val learningName = "Learning Activity : ${data.activityName}"
            val cycle = "Cycle : ${data.cycleName}"
            val type = "Type : ${data.activityTypeName}"

            val beginDateConvert = data.beginDate.let { DateTimeConverter.dateConverter(it) }
            val endDateConvert = data.endDate.let { DateTimeConverter.dateConverter(it) }

            val date = "Date : $beginDateConvert - $endDateConvert"

            tvLearningSchedule.text = learningName
            tvCycle.text = cycle
            tvType.text = type
//            tvFlag.text = if (data.flagOnline == true) {
//                "Flag : Online"
//            } else {
//                "Flag : Offline"
//            }
            tvDate.text = date
//            tvContentEndDate.text = data.endDate

        }

    }

    private fun setupObserver(bundle: SessionList?) {
        val sessionId = bundle?.sessionId

        viewModel.getScheduleList(sessionId.toString()).observe(viewLifecycleOwner, { data ->
            if (data != null) {
                when (data) {
                    is Resource.Loading -> binding.progressBar2.visibility = View.VISIBLE
                    is Resource.Success -> {
                        binding.progressBar2.visibility = View.GONE
                        adapter.setData(data.data)
                        Timber.tag(tag).d("observer_schedule_adapter ${data.data}")
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

    private fun buildRecycleView() {
        binding.apply {
            adapter = ScheduleAdapter()
            rvScheduleStudent.setHasFixedSize(true)
            rvScheduleStudent.layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            rvScheduleStudent.adapter = adapter

            // item Decoration
            rvScheduleStudent.addItemDecoration(
                DividerItemDecoration(
                    requireContext(),
                    LinearLayoutManager.VERTICAL
                )
            )

        }

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null

    }

}