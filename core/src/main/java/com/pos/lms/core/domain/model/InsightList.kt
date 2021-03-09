package com.pos.lms.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class InsightList(
    val beginDate: String,
    val endDate: String,
    val changeDate: String,
    val changeUser: String,
    val forumId: String,
    val forumImage: String,
    val forumText: String,
    val forumTime: String,
    val forumTitle: String,
    val objectIdentifier: String,
    val owner: String,
    val batchName: String,
    val batchId: String,

    ) : Parcelable