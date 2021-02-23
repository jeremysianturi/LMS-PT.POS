package com.pos.lms.mobile.ui.student.detailStudent.session.detail.mentoring

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
import com.pos.lms.core.domain.model.SessionList
import com.pos.lms.core.utils.PreferenceEntity
import com.pos.lms.core.utils.UserPreference
import com.pos.lms.mobile.R
import com.pos.lms.mobile.databinding.MentoringFragmentBinding
import com.pos.lms.mobile.helper.CurrentDate
import com.pos.lms.mobile.ui.student.detailStudent.session.detail.mentoring.detail.DetailMentoringActivity
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class MentoringFragment : Fragment() {

    companion object {
        const val EXTRA_DATA = "extra_data"
    }


    private val viewModel: MentoringViewModel by viewModels()
    private lateinit var adapter : MentoringAdapter

    private var _binding: MentoringFragmentBinding? = null
    private val binding get() = _binding!!

    private lateinit var mPreference: UserPreference
    private lateinit var mPreferenceEntity: PreferenceEntity

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MentoringFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bundle = arguments
        var dataBundle: SessionList? = null

        mPreference = UserPreference(requireContext())
        mPreferenceEntity = mPreference.getPref()

        if (bundle != null) {
            dataBundle = bundle.getParcelable(EXTRA_DATA) as SessionList?
        }


        // menthod
        setupObserver(dataBundle)
        buildRecycleView()

    }

    private fun setupObserver(bundle: SessionList?) {
        val parId = mPreferenceEntity.parId.toString()
        val dateStart = CurrentDate.getToday()
        val dateEnd = CurrentDate.getToday()
        val sessionId = bundle?.sessionId

        viewModel.getMentoringList(sessionId.toString(),parId,dateStart, dateEnd).observe(viewLifecycleOwner, { data ->
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

        adapter = MentoringAdapter()
        binding.rvMentoring.setHasFixedSize(true)
        binding.rvMentoring.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.rvMentoring.adapter = adapter

        // item Decoration
        binding.rvMentoring.addItemDecoration(
            DividerItemDecoration(
                requireContext(),
                LinearLayoutManager.VERTICAL
            )
        )

        adapter.onItemClick = { selectData ->
            val mIntent = Intent(requireContext(), DetailMentoringActivity::class.java)
            mIntent.putExtra(DetailMentoringActivity.EXTRA_DATA, selectData)
            startActivity(mIntent)


        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}