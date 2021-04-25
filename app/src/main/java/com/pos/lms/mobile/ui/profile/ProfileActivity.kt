package com.pos.lms.mobile.ui.profile

import android.content.Intent
import android.os.Bundle
import android.viewbinding.library.activity.viewBinding
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.pos.lms.core.data.Resource
import com.pos.lms.core.utils.ErrorMessageSplit
import com.pos.lms.core.utils.PreferenceEntity
import com.pos.lms.core.utils.UserPreference
import com.pos.lms.mobile.databinding.ActivityProfileBinding
import com.pos.lms.mobile.helper.Debounce.onThrottledClick
import com.pos.lms.mobile.helper.loadImage
import com.pos.lms.mobile.ui.login.LoginActivity
import com.pos.lms.mobile.util.diaolg.SimpleDialog
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class ProfileActivity : AppCompatActivity() {

    private val binding: ActivityProfileBinding by viewBinding()
    private val viewModel: ProfileViewModel by viewModels()

    private lateinit var mPreference: UserPreference
    private lateinit var mPreferenceEntity: PreferenceEntity


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mPreference = UserPreference(this)
        mPreferenceEntity = mPreference.getPref()

        binding.tvContentUsername.text = mPreferenceEntity.username

        //setup Actionbar and navigasi up
        val actionbar = supportActionBar
        actionbar?.title = "Profile"
        actionbar?.setDisplayHomeAsUpEnabled(true)

        onclick()
        observerAvatar()
    }

    private fun observerAvatar() {
        val username = mPreferenceEntity.username
        viewModel.getAvatar(username.toString()).observe(this, { data ->
            if (data != null) {
                when (data) {
                    is Resource.Loading -> {
                    }
                    is Resource.Success -> {
                        var avatar = ""
                        if (data.data?.isNotEmpty() == true) {
                            avatar = data.data?.get(0)?.avatar ?: ""
                            binding.ivProfile.loadImage(this, avatar)
                        }
                        binding.ivProfile.loadImage(this, avatar)


                    }
                    is Resource.Error -> {
                        val message = ErrorMessageSplit.message(data.message.toString())
                        val code = ErrorMessageSplit.code(data.message.toString())
                        SimpleDialog.newInstance(code, message)
                            .show(supportFragmentManager, SimpleDialog.TAG)
                    }
                }

            }

        })

    }

    private fun onclick() {
        binding.apply {
            btnLogout.onThrottledClick {
                val mIntent = Intent(this@ProfileActivity, LoginActivity::class.java)
                startActivity(mIntent)
                finish()
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}