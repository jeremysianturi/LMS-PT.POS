package com.pos.lms.mobile.ui.trainer

import android.os.Bundle
import android.viewbinding.library.activity.viewBinding
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.pos.lms.core.ui.SectionsPagerAdapter
import com.pos.lms.mobile.databinding.ActivityTrainerBinding
import com.pos.lms.mobile.ui.trainer.complete.CompleteFragment
import com.pos.lms.mobile.ui.trainer.ongoing.OngoingFragment
import com.pos.lms.mobile.ui.trainer.upcoming.UpcomingFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi

/**
 * Created by Muhammad Zaim Milzam on 23/04/21.
 * linkedin : Muhammad Zaim Milzam
 */

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class TrainerUserActivity : AppCompatActivity() {

    private val binding: ActivityTrainerBinding by viewBinding()
    private val viewModel: TrainerUserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

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
        complete.arguments = bundleSession

        val ongoing = OngoingFragment()
        val bundleForum = Bundle()
        ongoing.arguments = bundleForum

        val upcoming = UpcomingFragment()
        val bundleInsight = Bundle()
        upcoming.arguments = bundleInsight

        // bind Fragment and adapter
        val sectionsPagerAdapter = SectionsPagerAdapter(supportFragmentManager)
        sectionsPagerAdapter.addFragments(
            ongoing,
            "On Going"
        )

        sectionsPagerAdapter.addFragments(
            upcoming,
            "Up Coming"
        )

        sectionsPagerAdapter.addFragments(
            complete,
            "Completed"
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