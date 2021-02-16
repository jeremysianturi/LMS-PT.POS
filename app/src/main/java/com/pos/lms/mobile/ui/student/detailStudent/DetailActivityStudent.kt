package com.pos.lms.mobile.ui.student.detailStudent

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pos.lms.core.domain.model.Student
import com.pos.lms.core.ui.SectionsPagerAdapter
import com.pos.lms.mobile.R
import com.pos.lms.mobile.databinding.ActivityDetailStudentBinding
import com.pos.lms.mobile.ui.student.detailStudent.forum.ForumFragment
import com.pos.lms.mobile.ui.student.detailStudent.insight.InsightFragment
import com.pos.lms.mobile.ui.student.detailStudent.session.SessionFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailActivityStudent : AppCompatActivity() {

    companion object {
        const val EXTRA_DATA = "extra_data"
    }

    private lateinit var binding : ActivityDetailStudentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailStudentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dataIntent = intent.getParcelableExtra<Student>(EXTRA_DATA)



        //setup Actionbar and navigasi up
        val actionbar = supportActionBar
        actionbar?.title = getString(R.string.txt_detail_student)
        actionbar?.setDisplayHomeAsUpEnabled(true)


        setupViewPager(dataIntent)

    }

    private fun setupViewPager(student: Student?) {
        // send data intent to fragment
        val session = SessionFragment()
        val bundleSession = Bundle()
        bundleSession.putParcelable(SessionFragment.EXTRA_DATA, student)
        session.arguments = bundleSession

        val forum = ForumFragment()
        val bundleForum = Bundle()
        bundleForum.putParcelable(ForumFragment.EXTRA_DATA, student)
        forum.arguments = bundleForum

        val insight = InsightFragment()
        val bundleInsight = Bundle()
        bundleInsight.putParcelable(InsightFragment.EXTRA_DATA, student)
        insight.arguments = bundleInsight

        // bind Fragment and adapter
        val sectionsPagerAdapter = SectionsPagerAdapter(supportFragmentManager)
        sectionsPagerAdapter.addFragments(
            session,
            getString(R.string.txt_session)
        )
        sectionsPagerAdapter.addFragments(
            forum,
            getString(R.string.txt_forum)
        )
        sectionsPagerAdapter.addFragments(
            insight,
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