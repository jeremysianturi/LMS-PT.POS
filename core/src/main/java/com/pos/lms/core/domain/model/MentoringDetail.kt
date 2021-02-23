package com.pos.lms.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MentoringDetail(
    val endDate: String,
    val mentoringTitle: String,
    val objectIdentifier: String,
    val mentoringDuration: String,
    val mentoringReference: String,
    val beginDate: String,
    val businessCode: String,
    val changedDate: String,
    val changedUser: String,
    val mentoringTopic: String,
    val mentoringSession: String,
    val mentorId: String,
    val mentoringDescription: String,
    val companyName: String,
    val mentorTypeName: String,
    val mentoringId: String,
    val mentorTypeId: String,
    val mentorName: String
) : Parcelable