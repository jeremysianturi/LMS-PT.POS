package com.pos.lms.mobile.helper

import android.os.Build
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*


class CurrentTime {

    companion object {
        const val HOUR_MINUNUTES = "hh:mm"
    }

    fun getCurrentTime(): String {

        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
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
    }


}