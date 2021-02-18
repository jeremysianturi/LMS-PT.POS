package com.pos.lms.mobile.ui.student.detailStudent.session.detail.schedule.detailSchedule

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pos.lms.mobile.databinding.ActivityDetailScheduleBinding

class DetailScheduleActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_DATA = "extra_data"
    }


    private lateinit var binding : ActivityDetailScheduleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailScheduleBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}