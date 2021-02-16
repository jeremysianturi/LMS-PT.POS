package com.pos.lms.mobile.ui.student.detailStudent.session.detail.mentoring

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.pos.lms.mobile.databinding.MentoringFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MentoringFragment : Fragment() {

    companion object {
        const val EXTRA_DATA = "extra_data"
    }

    private lateinit var viewModel: MentoringViewModel

    private var _binding: MentoringFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = MentoringFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MentoringViewModel::class.java)
        // TODO: Use the ViewModel
    }

}