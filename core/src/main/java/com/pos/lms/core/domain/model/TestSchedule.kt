package com.pos.lms.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class TestSchedule(
	val endDate: String,
	val testCodeName: String,
	val objectIdentifier: String,
	val testTypeId: String,
	val beginDate: String,
	val endTime: String,
	val sessionId: String,
	val beginTime: String,
	val businessCode: String,
	val changedDate: String,
	val testCodeId: String,
	val scheduleDate: String,
	val scheduleName: String,
	val changedUser: String,
	val reference: String,
	val testTypeName: String,
	val relationQuestionId: String,
	val companyName: String,
	val topic: String,
	val dayNumber: String,
	val scheduleId: String
) : Parcelable