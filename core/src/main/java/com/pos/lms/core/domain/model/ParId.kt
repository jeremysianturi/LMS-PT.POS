package com.pos.lms.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ParId(
    val accessToken: String,
    val username: String,
    val type: String,
    val id: Int,
    ) : Parcelable
