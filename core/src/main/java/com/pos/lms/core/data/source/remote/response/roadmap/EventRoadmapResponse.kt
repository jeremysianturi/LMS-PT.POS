package com.pos.lms.core.data.source.remote.response.roadmap

import com.google.gson.annotations.SerializedName

data class EventRoadmapResponse(

	@field:SerializedName("end_date")
	val endDate: String,

	@field:SerializedName("object_identifier")
	val objectIdentifier: Int,

	@field:SerializedName("question_group")
	val questionGroup: String,

	@field:SerializedName("change_date")
	val changeDate: String,

	@field:SerializedName("begin_date")
	val beginDate: String,

	@field:SerializedName("description")
	val description: String,

	@field:SerializedName("business_code")
	val businessCode: String,

	@field:SerializedName("event_employee_dateline")
	val eventEmployeeDateline: Any? = "".toString(),

	@field:SerializedName("event_type")
	val eventType: String,

	@field:SerializedName("event_talent_unit_dateline")
	val eventTalentUnitDateline: Any? = "",

	@field:SerializedName("event_code")
	val eventCode: String,

	@field:SerializedName("start_hour")
	val startHour: String,

	@field:SerializedName("quota")
	val quota: Any? = "",

	@field:SerializedName("event_name")
	val eventName: String,

	@field:SerializedName("change_user")
	val changeUser: String,

	@field:SerializedName("end_hour")
	val endHour: String,

	@field:SerializedName("event_status")
	val eventStatus: String
)