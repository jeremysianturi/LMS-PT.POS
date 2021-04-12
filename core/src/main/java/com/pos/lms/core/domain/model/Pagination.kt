package com.pos.lms.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Pagination(
    val perPage: Int,
    val total: Int,
    val count: Int,
    val totalPages: Int,
    val currentPage: Int
) : Parcelable