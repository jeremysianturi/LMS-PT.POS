package com.pos.lms.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class QuisionerSchedule(
	val endDate: String,
	val templateCodeName: String,
	val objectIdentifier: String,
	val relationTypeId: String,
	val beginDate: String,
	val endTime: String,
	val sessionId: String,
	val beginTime: String,
	val businessCode: String,
	val changedDate: String,
	val scheduleDate: String,
	val scheduleName: String,
	val changedUser: String,
	val relationTypeName: String,
	val relationQuesionerId: String,
	val reference: String,
	val templateCodeId: String,
	val companyName: String,
	val templateTypeName: String,
	val templateTypeId: String,
	val topic: String,
	val dayNumber: String,
	val id: String,
	val scheduleId: String
) : Parcelable