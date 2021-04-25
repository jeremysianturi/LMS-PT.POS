package com.pos.lms.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MentorUser(
    val endDate: String? = null,
    val mentoringTitle: String? = null,
    val objectIdentifier: Int? = null,
    val mentoringDuration: Int? = null,
    val mentoringChangeUser: String? = null,
    val changeDate: String? = null,
    val beginDate: String? = null,
    val businessCode: String? = null,
    val mentoring: Int? = null,
    val personnelNumber: String? = null,
    val mentoringChangeDate: String? = null,
    val mentoringTopic: String? = null,
    val mentoringSession: Int? = null,
    val mentoringMentoringId: Int? = null,
    val mentoringBusinessCode: String? = null,
    val mentorId: Int? = null,
    val mentoringEndDate: String? = null,
    val mentoringDescription: String? = null,
    val mentoringReferenceMentoring: Int? = null,
    val changeUser: String? = null,
    val otype: String? = null,
    val id: Int? = null,
    val mentorName: String? = null,
    val mentoringBeginDate: String? = null
) : Parcelable