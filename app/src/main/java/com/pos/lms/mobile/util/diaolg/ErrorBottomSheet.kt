package com.pos.lms.mobile.util.diaolg

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.viewbinding.library.bottomsheetdialogfragment.viewBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.pos.lms.core.utils.PreferenceEntity
import com.pos.lms.core.utils.UserPreference
import com.pos.lms.mobile.databinding.ErrorBottomsheetDialogBinding
import com.pos.lms.mobile.ui.login.LoginActivity
import kotlinx.coroutines.ExperimentalCoroutinesApi

/**
 * Created by Muhammad Zaim Milzam on 30/03/21.
 * linkedin : Muhammad Zaim Milzam
 */
@ExperimentalCoroutinesApi
class ErrorBottomSheet : BottomSheetDialogFragment() {

    // ViewBinding Delegate
    private val binding: ErrorBottomsheetDialogBinding by viewBinding()

    private lateinit var mPreference: UserPreference
    private lateinit var mPreferenceEntity: PreferenceEntity

    private var codes: String? = ""

    companion object {

        const val TAG = "ERROR_BOTTOMSHEET"
        const val EXTRA_CODE = "extra_code"
        const val EXTRA_MESSAGE = "extra_message"

        fun instance(code: String, message: String): ErrorBottomSheet {
            // setup data code and message from activity
            val mBundle = Bundle()
            mBundle.putString(EXTRA_CODE, code)
            mBundle.putString(EXTRA_MESSAGE, message)

            //bind data to this bottomsheetFragment
            val fragment = ErrorBottomSheet()
            fragment.arguments = mBundle
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root //return root from binding delegation
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // init
        mPreference = UserPreference(requireContext())
        mPreferenceEntity = mPreference.getPref()
        codes = arguments?.getString(EXTRA_CODE)

        // check error code
        if (codes == "401") {
            binding.btnPositive.text = "Go to Login"
            mPreferenceEntity.isLogin = false
            mPreference.setPref(mPreferenceEntity)
        }

        setupView()
        setupClick()
    }

    private fun setupClick() {
        binding.btnPositive.setOnClickListener {
            if (codes == "401") {
                val gotoLogin = Intent(context, LoginActivity::class.java)
                startActivity(gotoLogin)
            }
            dismiss()

        }
    }

    private fun setupView() {
        binding.tvTitle.text = arguments?.getString(EXTRA_CODE) ?: ""
        binding.tvSubTitle.text = arguments?.getString(EXTRA_MESSAGE) ?: ""
    }
}
