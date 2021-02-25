package com.pos.lms.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class EventRoadmap(
	val endDate: String,
	val objectIdentifier: Int,
	val questionGroup: String,
	val changeDate: String,
	val beginDate: String,
	val description: String,
	val businessCode: String,
	val eventEmployeeDateline: String,
	val eventType: String,
	val eventTalentUnitDateline: String,
	val eventCode: String,
	val startHour: String,
	val quota: String,
	val eventName: String,
	val changeUser: String,
	val endHour: String,
	val eventStatus: String
) : Parcelable