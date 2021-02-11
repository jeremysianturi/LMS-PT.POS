package com.pos.lms.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Type(
    val endDate: String,
    val objectIdentifier: Int,
    val objectType: String,
    val changeDate: String,
    val shortText: String,
    val beginDate: String,
    val businessCode: String,
    val longText: String,
    val planVersion: String,
    val objectDescription: String,
    val changeUser: String,
    val id: String,
    val value: String
) : Parcelable