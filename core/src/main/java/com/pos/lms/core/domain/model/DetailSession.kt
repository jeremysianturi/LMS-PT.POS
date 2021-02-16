package com.pos.lms.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DetailSession(
    val endDate: String,
    val sessionName: String,
    val activityName: String,
    val curriculumName: String,
    val objectIdentifier: String,
    val batchId: String,
    val beginDate: String,
    val eventDescription: String,
    val businessCode: String,
    val changedDate: String,
    val locationId: String,
    val reference: String,
    val eventType: String,
    val activityId: String,
    val batchTypeName: String,
    val businessName: String,
    val sessionId: String,
    val curriculumId: String,
    val vendorName: String,
    val changedUser: String,
    val batchName: String,
    val locationName: String,
    val eventId: String,
    val vendorId: String,
    val batchTypeId: String,
    val eventName: String
) : Parcelable