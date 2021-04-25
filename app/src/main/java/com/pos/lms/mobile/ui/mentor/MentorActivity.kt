package com.pos.lms.mobile.ui.mentor

import android.os.Bundle
import android.viewbinding.library.activity.viewBinding
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.pos.lms.core.utils.PreferenceEntity
import com.pos.lms.core.utils.UserPreference
import com.pos.lms.mobile.databinding.ActivityMentorBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MentorActivity : AppCompatActivity() {

    private val binding: ActivityMentorBinding by viewBinding()
    private val viewModel: MentorViewModel by viewModels()
    private lateinit var adapter: MentorAdapter

    private lateinit var mPreference: UserPreference
    private lateinit var mPreferenceEntity: PreferenceEntity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mPreference = UserPreference(this)
        mPreferenceEntity = mPreference.getPref()


    }
}