package com.pos.lms.mobile.helper

import android.view.View

/**
 * Created by Muhammad Zaim Milzam on 06/04/21.
 * linkedin : Muhammad Zaim Milzam
 */
object Debounce {

    fun View.onThrottledClick(
        throttleDelay: Long = 500L,
        onClick: (View) -> Unit
    ) {
        setOnClickListener {
            onClick(this)
            isClickable = false
            postDelayed({ isClickable = true }, throttleDelay)
        }
    }
}