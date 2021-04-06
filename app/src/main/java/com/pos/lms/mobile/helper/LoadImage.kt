package com.pos.lms.mobile.helper

import android.content.Context
import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.pos.lms.mobile.R

/**
 * Created by Muhammad Zaim Milzam on 06/04/21.
 * linkedin : Muhammad Zaim Milzam
 */
class LoadImage {

    // set circular progress loading


    fun ImageView.loadImage(
        context: Context,
        url: String,
        @DrawableRes placeholder: Int = R.drawable.circle_orange
    ) {

        val circularProgressDrawable = CircularProgressDrawable(context)
        circularProgressDrawable.strokeWidth = 10f
        circularProgressDrawable.centerRadius = 50f
        circularProgressDrawable.setColorSchemeColors(
            ContextCompat.getColor(context, R.color.colorPrimary)
        )
        circularProgressDrawable.start()

        Glide.with(this)
            .load(url)
            .placeholder(circularProgressDrawable)
            .into(this)

    }
}