package com.pos.lms.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Schedule(
    val endDate: String,
    val objectIdentifier: Int,
    val changeDate: String,
    val beginDate: String,
    val endTime: String,
    val beginTime: String,
    val changeUser: String,
    val dayNumber: Int,
    val topic: String,
    val scheduleDate: String,
    val scheduleId: Int,
    val scheduleName: String
) : Parcelable