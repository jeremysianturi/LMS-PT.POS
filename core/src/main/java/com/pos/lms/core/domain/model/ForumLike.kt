package com.pos.lms.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ForumLike(
    val owner: String,
    val objectIdentifier: Int,
    val like: Boolean,
    val changeDate: String,
    val beginDate: String,
    val beginTime: String,
    val changeUser: String,
) : Parcelable