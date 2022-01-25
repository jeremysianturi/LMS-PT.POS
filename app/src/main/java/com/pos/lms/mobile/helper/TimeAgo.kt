package com.pos.lms.mobile.helper

import timber.log.Timber
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit

object TimeAgo {
    fun covertTimeToText(dataDate: String?): String? {
        var convTime: String? = null
        val prefix = ""
        val suffix = "Ago"
        try {
            val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
            val pasTime: Date = dateFormat.parse(dataDate)
            val nowTime = Date()
            val dateDiff: Long = nowTime.time - pasTime.time
            val second: Long = TimeUnit.MILLISECONDS.toSeconds(dateDiff)
            val minute: Long = TimeUnit.MILLISECONDS.toMinutes(dateDiff)
            val hour: Long = TimeUnit.MILLISECONDS.toHours(dateDiff)
            val day: Long = TimeUnit.MILLISECONDS.toDays(dateDiff)
            when {
                second < 60 -> {
                    convTime = "$second Seconds $suffix"
                }
                minute < 60 -> {
                    convTime = "$minute Minutes $suffix"
                }
                hour < 24 -> {
                    convTime = "$hour Hours $suffix"
                }
                day >= 7 -> {
                    convTime =
                        when {
                            day > 360 -> {
                                (day / 360).toString() + " Years " + suffix
                            }
                            day > 30 -> {
                                (day / 30).toString() + " Months " + suffix
                            }
                            else -> {
                                (day / 7).toString() + " Week " + suffix
                            }
                        }
                }
                hour > 24 || day < 2 -> {
                    convTime = "yesterday"
                }
                day < 7 -> {
                    convTime = "$day Days $suffix"
                }
            }
        } catch (e: ParseException) {
            e.printStackTrace()
            Timber.tag("ConvTimeE").e(e)
        }
        return convTime
    }
}