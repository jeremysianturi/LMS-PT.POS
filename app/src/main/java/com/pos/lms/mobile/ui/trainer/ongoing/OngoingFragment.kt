package com.pos.lms.mobile.ui.trainer.ongoing

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.viewbinding.library.fragment.viewBinding
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.pos.lms.core.data.Resource
import com.pos.lms.mobile.R
import com.pos.lms.mobile.databinding.FragmentOngoingBinding
import com.pos.lms.mobile.ui.trainer.TrainerUserAdapter
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

/**
 * Created by Muhammad Zaim Milzam on 23/04/21.
 * linkedin : Muhammad Zaim Milzam
 */
@AndroidEntryPoint
class OngoingFragment : Fragment() {

    companion object {
        const val EXTRA_DATA = "extra_data"
    }

    private val binding: FragmentOngoingBinding by viewBinding()
    private val viewModel: OngoingViewModel by viewModels()
    private lateinit var adapter: TrainerUserAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ongoing, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buildRc()
        setupObserver()
    }

    private fun setupObserver() {
        viewModel.getList.observe(viewLifecycleOwner, { data ->
            if (data != null) {
                when (data) {
                    is Resource.Loading -> binding.progressBar2.visibility = View.VISIBLE
                    is Resource.Success -> {
                        binding.progressBar2.visibility = View.GONE
                        adapter.setData(data.data)
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

    }

    private fun buildRc() {
        adapter = TrainerUserAdapter()
        binding.rvOngoing.setHasFixedSize(true)
        binding.rvOngoing.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.rvOngoing.adapter = adapter

        binding.rvOngoing.addItemDecoration(
            DividerItemDecoration(
                requireContext(),
                LinearLayoutManager.VERTICAL
            )
        )

//        adapter.onItemClick = { selectData ->
//            val mIntent = Intent(this, DetailActivityStudent::class.java)
//            mIntent.putExtra(DetailActivityStudent.EXTRA_DATA, selectData)
//            startActivity(mIntent)
//        }
    }


}