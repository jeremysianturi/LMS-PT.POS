package com.pos.lms.mobile.ui.splash

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.pos.lms.core.utils.PreferenceEntity
import com.pos.lms.core.utils.UserPreference
import com.pos.lms.mobile.R
import com.pos.lms.mobile.databinding.ActivitySplashScreenBinding
import com.pos.lms.mobile.ui.home.HomeActivity
import com.pos.lms.mobile.ui.login.LoginActivity
import com.pos.lms.mobile.util.CheckConnection
import kotlinx.coroutines.ExperimentalCoroutinesApi
import timber.log.Timber

/**
 * Created by Muhammad Zaim Milzam on 15/02/21.
 * linkedin : Muhammad Zaim Milzam
 */
@ExperimentalCoroutinesApi
class SplashScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashScreenBinding

    private var mPreference: UserPreference? = null
    private val mPreferenceEntity: PreferenceEntity get() = mPreference!!.getPref()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mPreference = UserPreference(this)

        // animation
        val rightToLeftAnimation =
            android.view.animation.AnimationUtils.loadAnimation(this, R.anim.right_animation)

        binding.imageView8.animation = rightToLeftAnimation

        val checkConnection = CheckConnection.internetAvailable(this)
        if (!checkConnection) {
            Toast.makeText(this, "No Connection Detected", Toast.LENGTH_SHORT).show()
        } else {
            Timber.d("checkConnectionClass : $checkConnection")
        }

        val splashTread: Thread = object : Thread() {
            override fun run() {
                try {
                    sleep(2000)
                } catch (e: InterruptedException) {
                    // do nothing
                } finally {
//                    val mIntent = Intent(this@SplashScreenActivity, LoginActivity::class.java)
//                    startActivity(mIntent)
                    if (mPreferenceEntity.isLogin == true) {
                        val mIntent = Intent(this@SplashScreenActivity, HomeActivity::class.java)
//                        val i = Intent(this, HomeActivity::class.java)
////                        i.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
////                        i.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK
                        startActivity(mIntent)
//                        finish()
                    } else {
                        val mIntent = Intent(this@SplashScreenActivity, LoginActivity::class.java)
                        startActivity(mIntent)
                        finish()
                    }
                }

            }

        }

        splashTread.start()

    }
}