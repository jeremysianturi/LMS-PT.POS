package com.pos.lms.mobile.ui.changePassword

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.pos.lms.core.data.Resource
import com.pos.lms.core.utils.PreferenceEntity
import com.pos.lms.core.utils.UserPreference
import com.pos.lms.mobile.R
import com.pos.lms.mobile.databinding.ActivityChangePasswordBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class ChangePasswordActivity : AppCompatActivity() {

    private lateinit var mPreference: UserPreference
    private lateinit var mPreferenceEntity: PreferenceEntity

    //bottomSheet
    private var bottomSheetDialog: BottomSheetDialog? = null

    private var binding: ActivityChangePasswordBinding? = null
    private val viewModel: ChangePasswordViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChangePasswordBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

        mPreference = UserPreference(this)
        mPreferenceEntity = mPreference.getPref()

        bottomSheetDialog = BottomSheetDialog(this, R.style.BottomSheetDialog)

        val afterTextChangedListener = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                // ignore
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                // ignore\
            }

            override fun afterTextChanged(s: Editable) {
                viewModel.loginDataChanged(
                    binding?.editTextTextPassword?.text.toString(),
                    binding?.editTextTextPasswordConfirmation?.text.toString()
                )
            }
        }


        viewModel.loginFormState.observe(this,
            Observer { loginFormState ->
                if (loginFormState == null) {
                    return@Observer
                }
                binding?.button?.isEnabled = loginFormState.isDataValid
                loginFormState.passwordError?.let {
                    binding?.editTextTextPassword?.error = getString(it)
                }
                loginFormState.confirmPasswordError?.let {
                    binding?.editTextTextPasswordConfirmation?.error = getString(it)
                }
            })

        binding!!.button.setOnClickListener {
            val username = mPreferenceEntity.username
            val password = binding?.editTextTextPasswordConfirmation?.text.toString()
            setupObserver(username, password)
        }

        binding!!.editTextTextPassword.addTextChangedListener(afterTextChangedListener)
        binding!!.editTextTextPasswordConfirmation.addTextChangedListener(afterTextChangedListener)


        //setup Actionbar and navigasi up
        val actionbar = supportActionBar
        actionbar?.title = getString(R.string.txt_change_password)
        actionbar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun setupObserver(username: String?, password: String) {
        viewModel.changePassword(username.toString(), password).observe(this, { data ->
            when (data) {
                is Resource.Loading -> binding?.progressBar4?.visibility = View.VISIBLE
                is Resource.Success -> {
                    mPreferenceEntity.password = password
                    mPreference.setPref(mPreferenceEntity)
                    binding?.progressBar4?.visibility = View.GONE
                    popupInformation()

                }
                is Resource.Error -> {
                    val loginMessage = getString(R.string.something_wrong)
                    binding?.progressBar4?.visibility = View.GONE
                    Toast.makeText(this, loginMessage, Toast.LENGTH_SHORT).show()
                }

            }

        })
    }

    private fun popupInformation() {

        val views = layoutInflater.inflate(R.layout.bottom_sheet_information, null)
        bottomSheetDialog?.setContentView(views)

        val tittle = views.findViewById<TextView>(R.id.tvTittleInfo)
        val content = views.findViewById<TextView>(R.id.tvContentInfo)
        val btnYes = views.findViewById<Button>(R.id.btnInfo)
        val img = views.findViewById<ImageView>(R.id.imgInfo)
        tittle.text = getString(R.string.text_berhasil)
        content.text = getString(R.string.txt_confirm_password)
        Glide.with(this)
            .load(R.drawable.img_confirm)
            .into(img)

        btnYes.text = getString(R.string.text_oke)
        bottomSheetDialog?.show()

        //setOnclick bottomsheet
        btnYes.setOnClickListener {
            bottomSheetDialog?.dismiss()
            finish()
        }

    }


    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}