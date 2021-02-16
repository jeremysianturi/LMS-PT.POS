package com.pos.lms.mobile.ui.student.detailStudent.insight

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.pos.lms.core.data.Resource
import com.pos.lms.core.domain.model.Student
import com.pos.lms.mobile.R
import com.pos.lms.mobile.databinding.InsightFragmentBinding
import com.pos.lms.mobile.helper.CurrentDate
import com.pos.lms.mobile.ui.student.detailStudent.session.SessionFragment
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class InsightFragment : Fragment() {

    companion object {
        const val EXTRA_DATA = "extra_data"
    }

    private val viewModel: InsightViewModel by viewModels()
    private lateinit var adapter: InsightAdapter

    private var _binding: InsightFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = InsightFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bundle = arguments
        var dataBundle: Student? = null

        if (bundle != null) {
            dataBundle = bundle.getParcelable(SessionFragment.EXTRA_DATA) as Student?
        }

        setupObserver(dataBundle)
        buildRecycleView()
    }

    private fun setupObserver(bundle: Student?) {

        val eventId = bundle?.eventId.toString()
        val batchId = bundle?.batch.toString()

        val begindate = CurrentDate.getToday()
        val enddate = CurrentDate.getToday()

        viewModel.getInsightList(batchId, begindate, enddate).observe(viewLifecycleOwner, { data ->
            if (data != null) {
                when (data) {
                    is Resource.Loading -> binding.progressBar2.visibility = View.VISIBLE
                    is Resource.Success -> {
                        binding.progressBar2.visibility = View.GONE
                        adapter.setData(data.data)
//                        setupBatch(data.data)
//                        setupSession(data.data)
                        Timber.tag(tag).d("observer_insight_adapter ${data.data}")
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
            adapter = InsightAdapter()
            rvInsight.setHasFixedSize(true)
            rvInsight.layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            rvInsight.adapter = adapter

            adapter.onLikeClick = { selectedData ->
                Toast.makeText(requireContext(), "fitur not Ready", Toast.LENGTH_SHORT).show()
            }

            adapter.onDeleteClick = { selectedData ->
                Toast.makeText(requireContext(), "fitur not Ready", Toast.LENGTH_SHORT).show()
            }

            adapter.onUpdateClick = { selectedData ->
                Toast.makeText(requireContext(), "fitur not Ready", Toast.LENGTH_SHORT).show()
            }

        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null

    }



}