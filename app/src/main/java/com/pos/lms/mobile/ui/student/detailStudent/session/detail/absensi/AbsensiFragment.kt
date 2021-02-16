package com.pos.lms.mobile.ui.student.detailStudent.session.detail.absensi

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.pos.lms.mobile.databinding.AbsensiFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AbsensiFragment : Fragment() {

    companion object {
        const val EXTRA_DATA = "extra_data"
    }

    private lateinit var viewModel: AbsensiViewModel

    private var _binding: AbsensiFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = AbsensiFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }


}