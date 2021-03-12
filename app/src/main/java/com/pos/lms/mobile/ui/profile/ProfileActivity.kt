package com.pos.lms.mobile.ui.profile

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pos.lms.mobile.databinding.ActivityProfileBinding
import com.pos.lms.mobile.ui.login.LoginActivity

class ProfileActivity : AppCompatActivity() {

    private var binding: ActivityProfileBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

        //setup Actionbar and navigasi up
        val actionbar = supportActionBar
        actionbar?.title = "Profile"
        actionbar?.setDisplayHomeAsUpEnabled(true)

        onclick()
    }

    private fun onclick() {
        binding?.apply {
            btnLogout.setOnClickListener {
                val mIntent = Intent(this@ProfileActivity, LoginActivity::class.java)
                startActivity(mIntent)
                finish()
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}