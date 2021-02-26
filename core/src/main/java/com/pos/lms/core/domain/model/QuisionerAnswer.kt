package com.pos.lms.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class QuisionerAnswer(
    val endDate: String,
    val objectIdentifier: Int,
    val changeDate: String,
    val beginDate: String,
    val textChoice: String,
    val changeUser: String,
    val sequenceNo: Int,
    var isChecked : Boolean? = false
) :Parcelable