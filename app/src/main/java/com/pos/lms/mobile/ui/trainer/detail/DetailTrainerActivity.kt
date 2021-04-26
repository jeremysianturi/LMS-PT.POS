package com.pos.lms.mobile.ui.trainer.detail

import android.os.Bundle
import android.viewbinding.library.activity.viewBinding
import androidx.appcompat.app.AppCompatActivity
import com.pos.lms.core.domain.model.TrainerUser
import com.pos.lms.core.ui.SectionsPagerAdapter
import com.pos.lms.mobile.R
import com.pos.lms.mobile.databinding.ActivityDetailTrainerBinding
import com.pos.lms.mobile.ui.student.detailStudent.forum.ForumFragment
import com.pos.lms.mobile.ui.student.detailStudent.insight.InsightFragment
import com.pos.lms.mobile.ui.student.detailStudent.session.detail.absensi.AbsensiFragment
import com.pos.lms.mobile.ui.trainer.detail.details.DetailTrainerFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class DetailTrainerActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_DATA = "extra_data"
    }

    private val binding: ActivityDetailTrainerBinding by viewBinding()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val dataIntent = intent.getParcelableExtra<TrainerUser>(EXTRA_DATA)

        setupViewPager(dataIntent)

        //setup Actionbar and navigasi up
        val actionbar = supportActionBar
        actionbar?.title = "Trainer"
        actionbar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun setupViewPager(dataIntent: TrainerUser?) {

        // send data intent to fragment
        val detail = DetailTrainerFragment()
        val bundleDetail = Bundle()
        bundleDetail.putParcelable(DetailTrainerFragment.EXTRA_DATA, dataIntent)
        detail.arguments = bundleDetail

        // send data intent to fragment
        val forum = ForumFragment()
        val bundleForum = Bundle()
        bundleForum.putParcelable(ForumFragment.EXTRA_DATA, dataIntent)
        bundleForum.putString(ForumFragment.USER_ROLE, "TRAINER")
        forum.arguments = bundleForum

        val insight = InsightFragment()
        val bundleInsight = Bundle()
        bundleInsight.putParcelable(InsightFragment.EXTRA_DATA, dataIntent)
        bundleInsight.putString(InsightFragment.USER_ROLE, "TRAINER")
        insight.arguments = bundleInsight

        val absensi = AbsensiFragment()
        val bundleAbsen = Bundle()
        bundleAbsen.putParcelable(AbsensiFragment.EXTRA_DATA, dataIntent)
        bundleAbsen.putString(AbsensiFragment.USER_ROLE, "TRAINER")
        absensi.arguments = bundleAbsen

        // bind Fragment and adapter
        val sectionsPagerAdapter = SectionsPagerAdapter(supportFragmentManager)
        sectionsPagerAdapter.addFragments(
            detail,
            getString(R.string.txt_detail)
        )

        sectionsPagerAdapter.addFragments(
            forum,
            getString(R.string.txt_forum)
        )

        sectionsPagerAdapter.addFragments(
            insight,
            getString(R.string.txt_insight)
        )
        sectionsPagerAdapter.addFragments(
            absensi,
            getString(R.string.txt_absensi)
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