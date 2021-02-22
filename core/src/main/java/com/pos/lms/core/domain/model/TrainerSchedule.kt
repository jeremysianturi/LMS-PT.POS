package com.pos.lms.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class TrainerSchedule(
	val endDate: String,
	val objectIdentifier: String,
	val beginDate: String,
	val endTime: String,
	val sessionId: String,
	val beginTime: String,
	val businessCode: String,
	val changedDate: String,
	val parentType: String,
	val scheduleDate: String,
	val scheduleName: String,
	val changedUser: String,
	val relation: String,
	val reference: String,
	val childId: String,
	val parentId: String,
	val companyName: String,
	val topic: String,
	val dayNumber: String,
	val childType: String,
	val trainerName: String
) : Parcelable