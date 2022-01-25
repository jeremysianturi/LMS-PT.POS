package com.pos.lms.mobile.ui.student.detailStudent.session

import android.content.Intent
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
import com.pos.lms.core.domain.model.DetailSession
import com.pos.lms.core.domain.model.Student
import com.pos.lms.mobile.R
import com.pos.lms.mobile.databinding.SessionFragmentBinding
import com.pos.lms.mobile.helper.CurrentDate
import com.pos.lms.mobile.ui.student.detailStudent.session.detail.DetailSessionActivity
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class SessionFragment : Fragment() {

    companion object {
        const val EXTRA_DATA = "extra_data"
    }

    private val viewModel: SessionViewModel by viewModels()
    private lateinit var adapter: SessionAdapter

    private var _binding: SessionFragmentBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = SessionFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bundle = arguments
        var dataBundle: Student? = null

        if (bundle != null) {
            dataBundle = bundle.getParcelable(EXTRA_DATA) as Student?
        }

        setupObserver(dataBundle)
        buildRecycleView()
    }

    private fun setupObserver(bundle: Student?) {
        val eventId = bundle?.eventId.toString()
        val batchId = bundle?.batch.toString()

        val begindate = CurrentDate.getToday()
        val enddate = CurrentDate.getToday()

        viewModel.getDetailSession(eventId).observe(viewLifecycleOwner, { data ->
            if (data != null) {
                when (data) {
                    is Resource.Loading -> binding.progressBar2.visibility = View.VISIBLE
                    is Resource.Success -> {
                        binding.progressBar2.visibility = View.GONE
//                        adapter.setData(data.data)
                        setupBatch(data.data)
                        setupSession(data.data)
                        Timber.tag(tag).d("observer_student_adapter ${data.data}")
                    }
                    is Resource.Error -> {
                        val loginMessage = getString(R.string.something_wrong)
                        binding.progressBar2.visibility = View.GONE
                        Toast.makeText(requireContext(), loginMessage, Toast.LENGTH_SHORT).show()
                    }
                }

            }
        })

        viewModel.getSessionList(batchId, begindate, enddate).observe(viewLifecycleOwner, { data ->
            if (data != null) {
                when (data) {
                    is Resource.Loading -> binding.progressBar2.visibility = View.VISIBLE
                    is Resource.Success -> {
                        binding.progressBar2.visibility = View.GONE
                        adapter.setData(data.data)
                        Timber.tag(tag).d("observer_session_adapter ${data.data}")
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
            adapter = SessionAdapter()
            rvActivityStudent.setHasFixedSize(true)
            rvActivityStudent.layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            rvActivityStudent.adapter = adapter

            rvActivityStudent.addItemDecoration(
                DividerItemDecoration(
                    requireContext(),
                    LinearLayoutManager.VERTICAL
                )
            )

            adapter.onItemClick = {selectData ->
                val mIntent = Intent(requireContext(), DetailSessionActivity::class.java)
                mIntent.putExtra(DetailSessionActivity.EXTRA_DATA, selectData)
                startActivity(mIntent)
            }


        }

    }

    private fun setupSession(sessionData: List<DetailSession>?) {
        binding.apply {
            tableDetail.apply {

                val data = sessionData?.get(0)

                val desc = data?.eventDescription
                val type = data?.eventType
                val agency = data?.businessName
                val org = "Organization : - "
                val vendor = data?.vendorName
                val begda = "${data?.beginDate} - ${data?.endDate}"
//                val enda = data.changedDate


                tvContentEvent.text = data?.eventName ?: ""
                tvContentDesc.text = desc
                tvContentType.text = type
                tvContentAgency.text = agency
                tvContentOrganization.text = org
                tvContentVendor.text = vendor
                tvContentBeginDate.text = begda
//                tvContentEndDate.text = enda
            }
        }
    }

    private fun setupBatch(datas: List<DetailSession>?) {
        binding.apply {
            tableBatch.apply {

                val data = datas?.get(0)
                val location = data?.locationName
                val beginDate = "${data?.beginDate} - ${data?.endDate}"
//                val endDate = "End Date : "
                val batchType = data?.batchTypeName
                val curiculum = data?.curriculumName
                val vendorName = data?.vendorName

                tvTittleBatch.text = data?.batchName ?: ""
                tvContentLocation.text = location
                tvContentBeginDate.text = beginDate
//                tvContentEndDate.text = endDate
                tvContentBatchType.text = batchType
                tvContentCuriculum.text = curiculum
                tvContentVendor.text = vendorName
            }


        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null

    }


}