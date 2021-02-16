package com.pos.lms.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class SessionList(
	val endDate: String,
	val sessionName: String,
	val activityName: String,
	val objectIdentifier: String,
	val cycleId: String,
	val batchId: String,
	val beginDate: String,
	val sessionId: String,
	val changedDate: String,
	val changedUser: String,
	val activityTypeId: String,
	val activityTypeName: String,
	val activityId: String,
	val cycleName: String
) : Parcelable