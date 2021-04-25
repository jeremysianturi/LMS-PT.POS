package com.pos.lms.mobile.ui.trainer.detail

import android.os.Bundle
import android.viewbinding.library.activity.viewBinding
import androidx.appcompat.app.AppCompatActivity
import com.pos.lms.mobile.databinding.ActivityDetailTrainerBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailTrainerActivity : AppCompatActivity() {

    private val binding: ActivityDetailTrainerBinding by viewBinding()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }
}