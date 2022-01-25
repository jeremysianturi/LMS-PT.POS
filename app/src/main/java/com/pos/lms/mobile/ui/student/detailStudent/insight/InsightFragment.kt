package com.pos.lms.mobile.ui.student.detailStudent.insight

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.pos.lms.core.data.Resource
import com.pos.lms.core.data.source.remote.post.ForumLikePost
import com.pos.lms.core.domain.model.InsightList
import com.pos.lms.core.domain.model.Student
import com.pos.lms.core.domain.model.TrainerUser
import com.pos.lms.core.utils.PreferenceEntity
import com.pos.lms.core.utils.UserPreference
import com.pos.lms.mobile.R
import com.pos.lms.mobile.databinding.InsightFragmentBinding
import com.pos.lms.mobile.helper.CurrentDate
import com.pos.lms.mobile.helper.CurrentTime
import com.pos.lms.mobile.ui.student.detailStudent.forum.ForumFragment
import com.pos.lms.mobile.ui.student.detailStudent.insight.create.CreateInsightActivity
import com.pos.lms.mobile.ui.student.detailStudent.insight.update.UpdateInsightActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi
import timber.log.Timber

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class InsightFragment : Fragment() {

    companion object {
        const val EXTRA_DATA = "extra_data"
        const val USER_ROLE = "user_role"
    }

    private val viewModel: InsightViewModel by viewModels()
    private lateinit var adapter: InsightAdapter

    private var _binding: InsightFragmentBinding? = null
    private val binding get() = _binding!!

    private lateinit var mPreference: UserPreference
    private lateinit var mPreferenceEntity: PreferenceEntity

    private var batchId = ""
    private var eventId = ""
//    private var dataBundle: Student? = null

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
//        var dataBundle: Student? = null

        mPreference = UserPreference(requireActivity())
        mPreferenceEntity = mPreference.getPref()

        if (bundle != null) {
            val userRole = bundle.getString(ForumFragment.USER_ROLE)
            if (userRole == "STUDENT") {
                val dataBundle = bundle.getParcelable(EXTRA_DATA) as Student?
                batchId = dataBundle?.batch.toString()
                eventId = dataBundle?.eventId.toString()

                binding.ivCreateInsight.setOnClickListener {
                    val mIntent = Intent(requireContext(), CreateInsightActivity::class.java)
                    mIntent.putExtra(CreateInsightActivity.EXTRA_DATA, dataBundle)
                    startActivity(mIntent)
                }

            } else {

                val dataBundle = bundle.getParcelable(EXTRA_DATA) as TrainerUser?
                batchId = dataBundle?.batch.toString()
                eventId = dataBundle?.eventId.toString()

                binding.ivCreateInsight.setOnClickListener {
                    val mIntent = Intent(requireContext(), CreateInsightActivity::class.java)
                    mIntent.putExtra(CreateInsightActivity.EXTRA_DATA, dataBundle)
                    startActivity(mIntent)
                }

            }
        }

        // search
        binding.edtSearch.doOnTextChanged { text, start, before, count ->
            viewModel.searchQuery.value = text.toString()
        }

        binding.cbMyForum.setOnClickListener {
            val checked = binding.cbMyForum.isChecked
            if (checked) {
                viewModel.myInsightQuery.value = mPreferenceEntity.username.toString()
            } else {
                viewModel.myInsightQuery.value = ""
            }
        }

        setupObserver()
        buildRecycleView()
    }

    private fun setupObserver() {

//        val bundle = dataBundle
//        val eventId = bundle?.eventId.toString()
//        val batchId = bundle?.batch.toString()

        val begindate = CurrentDate.getToday()
        val enddate = CurrentDate.getToday()

        viewModel.getInsightList(batchId, begindate, enddate).observe(viewLifecycleOwner, { data ->
            if (data != null) {
                when (data) {
                    is Resource.Loading -> binding.progressBar2.visibility = View.VISIBLE
                    is Resource.Success -> {
                        binding.progressBar2.visibility = View.GONE
                        adapter.setData(data.data, mPreferenceEntity.username)
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

        viewModel.search.observe(viewLifecycleOwner, { data ->
            adapter.setData(data, mPreferenceEntity.username)

        })

        viewModel.myInisght.observe(viewLifecycleOwner, { data ->
            adapter.setData(data, mPreferenceEntity.username)
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
                setupLikeObserver(selectedData)
            }

            adapter.onDeleteClick = { selectedData ->
                setupObserverDeleteForum(selectedData)
            }

            adapter.onUpdateClick = { selectedData ->
                val mIntent = Intent(requireContext(), UpdateInsightActivity::class.java)
                mIntent.putExtra(UpdateInsightActivity.EXTRA_DATA, selectedData)
                startActivity(mIntent)
            }

        }

    }

    private fun setupLikeObserver(data: InsightList) {
        val forumId = data.forumId.toInt()
        val begindate = CurrentDate.getToday()
        val time = CurrentTime().getCurrentTime()

        val dataLike = ForumLikePost(
            otypeParent = "SCHDL",
            forum = forumId,
            like = true,
            owner = mPreferenceEntity.username.toString(),
            beginDate = begindate,
            beginTime = time,
            businessCode = "POS"
        )

        Toast.makeText(requireContext(), "Fitur not ready", Toast.LENGTH_SHORT).show()

    }


    private fun setupObserverDeleteForum(selectedData: InsightList) {
        viewModel.getDelete(selectedData.objectIdentifier)
            .observe(viewLifecycleOwner, { data ->
                if (data != null) {
                    when (data) {
                        is Resource.Loading -> binding.progressBar2.visibility = View.VISIBLE
                        is Resource.Success -> {
                            binding.progressBar2.visibility = View.GONE
                            setupObserver()
                            Timber.tag(tag).d("Delete Forum ${data.data}")
                        }
                        is Resource.Error -> {
                            val loginMessage = getString(R.string.something_wrong)
                            binding.progressBar2.visibility = View.GONE
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