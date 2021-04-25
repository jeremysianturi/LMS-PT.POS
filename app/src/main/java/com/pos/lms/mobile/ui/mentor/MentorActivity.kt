package com.pos.lms.mobile.ui.mentor

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.viewbinding.library.activity.viewBinding
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.pos.lms.core.data.Resource
import com.pos.lms.core.utils.PreferenceEntity
import com.pos.lms.core.utils.UserPreference
import com.pos.lms.mobile.R
import com.pos.lms.mobile.databinding.ActivityMentorBinding
import com.pos.lms.mobile.helper.CurrentDate
import com.pos.lms.mobile.ui.mentor.detail.DetailMentorActivity
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

        buildRc()
        observerMentor()

        //setup Actionbar and navigasi up
        val actionbar = supportActionBar
        actionbar?.title = "Mentor"
        actionbar?.setDisplayHomeAsUpEnabled(true)

    }

    private fun observerMentor() {

        val id = mPreferenceEntity.parId.toString()
        val begda = CurrentDate.getToday()
        val enda = CurrentDate.getToday()

        viewModel.getMentorList(id, begda, enda).observe(this, { data ->
            if (data != null) {
                when (data) {
                    is Resource.Loading -> binding.progressBar2.visibility = View.VISIBLE
                    is Resource.Success -> {
                        binding.progressBar2.visibility = View.GONE
                        adapter.setData(data.data)
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

    private fun buildRc() {
        adapter = MentorAdapter()
        binding.rvMentor.setHasFixedSize(true)
        binding.rvMentor.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rvMentor.adapter = adapter

        binding.rvMentor.addItemDecoration(
            DividerItemDecoration(
                this,
                LinearLayoutManager.VERTICAL
            )
        )

        adapter.onItemClick = { selectData ->
            val mIntent = Intent(this, DetailMentorActivity::class.java)
            mIntent.putExtra(DetailMentorActivity.EXTRA_DATA, selectData)
            startActivity(mIntent)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }


}