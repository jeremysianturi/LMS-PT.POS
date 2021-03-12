package com.pos.lms.mobile.ui.home

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.pos.lms.core.data.Resource
import com.pos.lms.core.utils.PreferenceEntity
import com.pos.lms.core.utils.UserPreference
import com.pos.lms.mobile.R
import com.pos.lms.mobile.databinding.ActivityHomeBinding
import com.pos.lms.mobile.ui.materi.MateriActivity
import com.pos.lms.mobile.ui.profile.ProfileActivity
import com.pos.lms.mobile.ui.proposal.CuriculumActivity
import com.pos.lms.mobile.ui.roadmap.RoadmapActivity
import com.pos.lms.mobile.ui.student.StudentActivity
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber
import kotlin.system.exitProcess

/**
 * Created by Muhammad Zaim Milzam on 15/02/21.
 * linkedin : Muhammad Zaim Milzam
 */

@AndroidEntryPoint
class HomeActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityHomeBinding

    private lateinit var mPreference: UserPreference
    private lateinit var mPreferenceEntity: PreferenceEntity

    private val viewModel: HomeViewModel by viewModels()

    private var doubleBackToExitPressedOnce = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mPreference = UserPreference(this)
        mPreferenceEntity = mPreference.getPref()

        binding.content.student.setOnClickListener(this)
        binding.content.roadMap.setOnClickListener(this)
        binding.content.learningProposal.setOnClickListener(this)
        binding.content.searchMateri.setOnClickListener(this)


        setupObserver()

        val actionbar = supportActionBar
        actionbar?.title = "Home"

    }

    private fun setupObserver() {
        val token = "${mPreferenceEntity.tokenType} ${mPreferenceEntity.token}"

        viewModel.getParId(token).observe(this, { parid ->
            if (parid != null) {
                when (parid) {
                    is Resource.Loading -> binding.content.progressBar.visibility = View.VISIBLE
                    is Resource.Success -> {
                        Timber.d("parIDHome : ${parid.data?.get(0)?.id}")

                        mPreferenceEntity.parId = parid.data?.get(0)?.id ?: 0
                        mPreference.setPref(mPreferenceEntity)
                        binding.content.progressBar.visibility = View.GONE

                    }
                    is Resource.Error -> {
                        val loginMessage = getString(R.string.something_wrong)
                        binding.content.progressBar.visibility = View.GONE
                        Timber.tag("ERROR_PARID").e(parid.message)
                        Toast.makeText(this, loginMessage, Toast.LENGTH_SHORT).show()
                    }

                }

            }

        })

    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.student -> {
                val mIntent = Intent(this, StudentActivity::class.java)
                startActivity(mIntent)
            }
            R.id.roadMap -> {
                val mIntent = Intent(this, RoadmapActivity::class.java)
                startActivity(mIntent)
            }
            R.id.learningProposal -> {
                val mIntent = Intent(this, CuriculumActivity::class.java)
                startActivity(mIntent)
            }
            R.id.searchMateri -> {
                val mIntent = Intent(this, MateriActivity::class.java)
                startActivity(mIntent)
            }
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        return super.onCreateOptionsMenu(menu)
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_home, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        return if (id == R.id.action_profile) {
            val mIntent = Intent(this, ProfileActivity::class.java)
            startActivity(mIntent)
            true
        } else super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            val intent = Intent(Intent.ACTION_MAIN)
            intent.addCategory(Intent.CATEGORY_HOME)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
            finish()
            exitProcess(0)
        }
        this.doubleBackToExitPressedOnce = true
        Toast.makeText(this, "Klik sekali lagi untuk keluar", Toast.LENGTH_SHORT).show()
//        Toasty.warning(this, "Klik sekali lagi untuk keluar", Toasty.LENGTH_SHORT).show()
        Handler(Looper.getMainLooper()).postDelayed(
            { doubleBackToExitPressedOnce = false },
            2000
        ) // review
    }


}

