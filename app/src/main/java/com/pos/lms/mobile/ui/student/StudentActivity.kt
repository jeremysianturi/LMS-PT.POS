package com.pos.lms.mobile.ui.student

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.pos.lms.core.data.Resource
import com.pos.lms.core.utils.PreferenceEntity
import com.pos.lms.core.utils.UserPreference
import com.pos.lms.mobile.R
import com.pos.lms.mobile.databinding.ActivityStudentBinding
import com.pos.lms.mobile.ui.student.detailStudent.DetailActivityStudent
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber


@AndroidEntryPoint
class StudentActivity : AppCompatActivity() {

    private val tag = StudentActivity::class.java.simpleName.toString()

    private lateinit var binding: ActivityStudentBinding
    private lateinit var adapter: StudentAdapter

    private lateinit var mPreference: UserPreference
    private lateinit var mPreferenceEntity: PreferenceEntity

    private val viewModel: StudentViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStudentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mPreference = UserPreference(this)
        mPreferenceEntity = mPreference.getPref()

        val parid = mPreferenceEntity.parId.toString()

        //setup Actionbar and navigasi up
        val actionbar = supportActionBar
        actionbar?.title = "Student"
        actionbar?.setDisplayHomeAsUpEnabled(true)

        setupObserver(parid)
        buildRc()
    }

    private fun buildRc() {
        adapter = StudentAdapter()
        binding.rvStudent.setHasFixedSize(true)
        binding.rvStudent.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rvStudent.adapter = adapter

        binding.rvStudent.addItemDecoration(
            DividerItemDecoration(
                this,
                LinearLayoutManager.VERTICAL
            )
        )

        adapter.onItemClick = { selectData ->
            val mIntent = Intent(this, DetailActivityStudent::class.java)
            mIntent.putExtra(DetailActivityStudent.EXTRA_DATA, selectData)
            startActivity(mIntent)
        }
    }

    private fun setupObserver(parid: String) {
        viewModel.getStudent(parid).observe(this, { data ->
            Timber.tag(tag).d("observer_Student $data")
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
                        Toast.makeText(this, loginMessage, Toast.LENGTH_SHORT).show()
                    }
                }

            }
        })

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}