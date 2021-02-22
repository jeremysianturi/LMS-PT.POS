package com.pos.lms.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Mentoring(
    val endDate: String,
    val objectIdentifier: String,
    val session: String,
    val changeDate: String,
    val beginDate: String,
    val referenceMentoring: String,
    val description: String,
    val businessCode: String,
    val title: String,
    val duration: String,
    val topic: String,
    val changeUser: String,
    val mentoringId: String
) : Parcelable