package com.pos.lms.mobile.helper

import android.os.Build
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

/**
 * Created by Muhammad Zaim Milzam on 03/12/2020.
 * linkedin : Muhammad Zaim Milzam
 */

class CurrentTime {

    companion object {
        const val HOUR_MINUNUTES = "hh:mm"
    }

    fun getCurrentTime() : String {

        val currentDate: String

        currentDate = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val current = LocalDateTime.now()
            val formatter = DateTimeFormatter.ofPattern(HOUR_MINUNUTES)
            val answer: String = current.format(formatter)
            answer

        } else {
            val date = Date()
            val formatter = SimpleDateFormat(HOUR_MINUNUTES, Locale.getDefault())
            val answer: String = formatter.format(date)
            answer

        }

        return currentDate
    }


}