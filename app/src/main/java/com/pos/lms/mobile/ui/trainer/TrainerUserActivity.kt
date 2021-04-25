package com.pos.lms.mobile.ui.trainer

import android.os.Bundle
import android.viewbinding.library.activity.viewBinding
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.pos.lms.core.ui.SectionsPagerAdapter
import com.pos.lms.core.utils.PreferenceEntity
import com.pos.lms.core.utils.UserPreference
import com.pos.lms.mobile.R
import com.pos.lms.mobile.databinding.ActivityTrainerBinding
import com.pos.lms.mobile.ui.trainer.complete.CompleteFragment
import com.pos.lms.mobile.ui.trainer.ongoing.OngoingFragment
import com.pos.lms.mobile.ui.trainer.upcoming.UpcomingFragment
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by Muhammad Zaim Milzam on 23/04/21.
 * linkedin : Muhammad Zaim Milzam
 */

@AndroidEntryPoint
class TrainerUserActivity : AppCompatActivity() {

    private val binding: ActivityTrainerBinding by viewBinding()
    private val viewModel: TrainerUserViewModel by viewModels()

    private lateinit var mPreference: UserPreference
    private lateinit var mPreferenceEntity: PreferenceEntity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mPreference = UserPreference(this)
        mPreferenceEntity = mPreference.getPref()

        setupViewPager()

        //setup Actionbar and navigasi up
        val actionbar = supportActionBar
        actionbar?.title = "Trainer"
        actionbar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun setupViewPager() {
        // send data intent to fragment
        val complete = CompleteFragment()
        val bundleSession = Bundle()
//        bundleSession.putParcelable(CompleteFragment.EXTRA_DATA, complete)
        complete.arguments = bundleSession

        val ongoing = OngoingFragment()
        val bundleForum = Bundle()
//        bundleForum.putParcelable(OngoingFragment.EXTRA_DATA, ongoing)
        ongoing.arguments = bundleForum

        val upcoming = UpcomingFragment()
        val bundleInsight = Bundle()
//        bundleInsight.putParcelable(InsightFragment.EXTRA_DATA, upcoming)
        upcoming.arguments = bundleInsight

        // bind Fragment and adapter
        val sectionsPagerAdapter = SectionsPagerAdapter(supportFragmentManager)
        sectionsPagerAdapter.addFragments(
            ongoing,
            getString(R.string.txt_session)
        )

        sectionsPagerAdapter.addFragments(
            upcoming,
            getString(R.string.txt_forum)
        )

        sectionsPagerAdapter.addFragments(
            complete,
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