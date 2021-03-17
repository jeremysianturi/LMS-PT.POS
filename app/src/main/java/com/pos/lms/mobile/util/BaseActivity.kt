package com.pos.lms.mobile.util

import android.app.Activity
import android.content.Intent
import com.pos.lms.mobile.ui.login.LoginActivity
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe


/**
 * Created by Muhammad Zaim Milzam on 17/03/21.
 * linkedin : Muhammad Zaim Milzam
 */
@ExperimentalCoroutinesApi
class BaseActivity : Activity() {
    public override fun onStart() {
        super.onStart()
        EventBus.getDefault().register(this)
//        EventBus.getDefault().register(this)
    }

    public override fun onStop() {
        super.onStop()
        EventBus.getDefault().unregister(this)
    }

    @Subscribe
    fun onUnauthorizedEvent(e: UnauthorizedEvent?) {
        handleUnauthorizedEvent()
    }

    private fun handleUnauthorizedEvent() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }
}