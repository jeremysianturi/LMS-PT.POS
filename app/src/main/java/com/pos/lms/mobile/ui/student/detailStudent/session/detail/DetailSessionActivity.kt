package com.pos.lms.mobile.ui.student.detailStudent.session.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pos.lms.core.domain.model.SessionList
import com.pos.lms.core.ui.SectionsPagerAdapter
import com.pos.lms.mobile.R
import com.pos.lms.mobile.databinding.ActivityDetailSessionBinding
import com.pos.lms.mobile.ui.student.detailStudent.session.detail.absensi.AbsensiFragment
import com.pos.lms.mobile.ui.student.detailStudent.session.detail.mentoring.MentoringFragment
import com.pos.lms.mobile.ui.student.detailStudent.session.detail.schedule.ScheduleFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailSessionActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_DATA = "extra_data"
    }
    private lateinit var binding : ActivityDetailSessionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailSessionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dataIntent = intent.getParcelableExtra<SessionList>(EXTRA_DATA)

        setupViewPager(dataIntent)

        //setup Actionbar and navigasi up
        val actionbar = supportActionBar
        actionbar?.title = "Detail Session"
        actionbar?.setDisplayHomeAsUpEnabled(true)

    }

    private fun setupViewPager(dataIntent: SessionList?) {
        // send data intent to fragment
        val schedule = ScheduleFragment()
        val bundleSession = Bundle()
        bundleSession.putParcelable(ScheduleFragment.EXTRA_DATA, dataIntent)
        schedule.arguments = bundleSession

        val mentoring = MentoringFragment()
        val bundleForum = Bundle()
        bundleForum.putParcelable(MentoringFragment.EXTRA_DATA, dataIntent)
        mentoring.arguments = bundleForum

        val absensi = AbsensiFragment()
        val bundleInsight = Bundle()
        bundleInsight.putParcelable(AbsensiFragment.EXTRA_DATA, dataIntent)
        absensi.arguments = bundleInsight

        // bind Fragment and adapter
        val sectionsPagerAdapter = SectionsPagerAdapter(supportFragmentManager)
        sectionsPagerAdapter.addFragments(
            schedule,
            getString(R.string.txt_session)
        )
        sectionsPagerAdapter.addFragments(
            mentoring,
            getString(R.string.txt_forum)
        )
        sectionsPagerAdapter.addFragments(
            absensi,
            getString(R.string.txt_insight)
        )

        // adapter and viewPager
        binding.apply {
            viewPager.adapter = sectionsPagerAdapter
            tabLayout.setupWithViewPager(viewPager, true)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}