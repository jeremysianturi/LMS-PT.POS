package com.pos.lms.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class TestJawaban(
    val endDate: String,
    val score: Int,
    val flagTrue: Boolean,
    val objectIdentifier: Int,
    val question: Int,
    val changeDate: String,
    val beginDate: String,
    val textChoice: String,
    val changeUser: String,
    val businessCode: String,
    val sequenceNo: Int,
    var isChecked: Boolean
) : Parcelable