package com.pos.lms.mobile.ui.roadmap

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.pos.lms.core.data.Resource
import com.pos.lms.core.domain.model.EventRoadmap
import com.pos.lms.core.ui.SectionsPagerAdapter
import com.pos.lms.mobile.R
import com.pos.lms.mobile.databinding.ActivityRoadmapBinding
import com.pos.lms.mobile.helper.CurrentDate
import com.pos.lms.mobile.ui.roadmap.ecp.ECPFragment
import com.pos.lms.mobile.ui.roadmap.mcp.MCPFragment
import com.pos.lms.mobile.ui.roadmap.scp.SCPFragment
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by Muhammad Zaim Milzam on 15/02/21.
 * linkedin : Muhammad Zaim Milzam
 */
@AndroidEntryPoint
class RoadmapActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRoadmapBinding
    private val viewModel: RoadmapViewModel by viewModels()

    private var datarRoadmap: List<EventRoadmap>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRoadmapBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val begda = CurrentDate.getToday()
        val enda = CurrentDate.getToday()

        setupObserver(begda, enda)

        //setup Actionbar and navigasi up
        val actionbar = supportActionBar
        actionbar?.title = "RoadMap"
        actionbar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun setupObserver(begda: String, enda: String) {

        viewModel.getEventRoadmap(begda, enda).observe(this, { data ->
            if (data != null) {
                when (data) {
                    is Resource.Loading -> binding.progressBarProposal.visibility = View.VISIBLE
                    is Resource.Success -> {
                        if (data.data?.isEmpty() == true) {
                            binding.emptyData.root.visibility = View.VISIBLE
                        } else {
                            setupViewPager(data.data)
                        }
                        binding.progressBarProposal.visibility = View.GONE
//                        setupViewPager(data.data)
                    }
                    is Resource.Error -> {
                        val loginMessage = getString(R.string.something_wrong)
                        binding.progressBarProposal.visibility = View.GONE
                        Toast.makeText(this, loginMessage, Toast.LENGTH_SHORT).show()
                    }
                }

            }

        })
    }

    private fun setupViewPager(data: List<EventRoadmap>?) {
        // send data intent to fragment
        val eventRoadmap = data?.get(0)

        val ecp = ECPFragment()
        val bundleSession = Bundle()
        bundleSession.putParcelable(ECPFragment.EXTRA_DATA, eventRoadmap)
        ecp.arguments = bundleSession

        val mcp = MCPFragment()
        val bundleForum = Bundle()
        bundleForum.putParcelable(MCPFragment.EXTRA_DATA, eventRoadmap)
        mcp.arguments = bundleForum

        val scp = SCPFragment()
        val bundleInsight = Bundle()
        bundleInsight.putParcelable(SCPFragment.EXTRA_DATA, eventRoadmap)
        scp.arguments = bundleInsight

        // bind Fragment and adapter
        val sectionsPagerAdapter = SectionsPagerAdapter(supportFragmentManager)
        sectionsPagerAdapter.addFragments(
            ecp,
            "EMPLOYEE (ECP)"
        )
        sectionsPagerAdapter.addFragments(
            mcp,
            "MANAGEMENT (MCP)"
        )
        sectionsPagerAdapter.addFragments(
            scp,
            "SUCCESSOR (SCP)"
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