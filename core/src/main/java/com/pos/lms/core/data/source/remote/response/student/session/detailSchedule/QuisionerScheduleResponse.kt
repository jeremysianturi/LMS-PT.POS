package com.pos.lms.core.data.source.remote.response.student.session.detailSchedule

import com.google.gson.annotations.SerializedName

data class QuisionerScheduleResponse(

	@field:SerializedName("end_date")
	val endDate: String,

	@field:SerializedName("template_code_name")
	val templateCodeName: String,

	@field:SerializedName("object_identifier")
	val objectIdentifier: String,

	@field:SerializedName("relation_type_id")
	val relationTypeId: String,

	@field:SerializedName("begin_date")
	val beginDate: String,

	@field:SerializedName("end_time")
	val endTime: String,

	@field:SerializedName("session_id")
	val sessionId: String,

	@field:SerializedName("begin_time")
	val beginTime: String,

	@field:SerializedName("business_code")
	val businessCode: String,

	@field:SerializedName("changed_date")
	val changedDate: String,

	@field:SerializedName("schedule_date")
	val scheduleDate: String,

	@field:SerializedName("schedule_name")
	val scheduleName: String,

	@field:SerializedName("changed_user")
	val changedUser: String,

	@field:SerializedName("relation_type_name")
	val relationTypeName: String,

	@field:SerializedName("relation_quesioner_id")
	val relationQuesionerId: String,

	@field:SerializedName("reference")
	val reference: String,

	@field:SerializedName("template_code_id")
	val templateCodeId: String,

	@field:SerializedName("company_name")
	val companyName: String,

	@field:SerializedName("template_type_name")
	val templateTypeName: String,

	@field:SerializedName("template_type_id")
	val templateTypeId: String,

	@field:SerializedName("topic")
	val topic: String,

	@field:SerializedName("day_number")
	val dayNumber: String,

	@field:SerializedName("id")
	val id: String,

	@field:SerializedName("schedule_id")
	val scheduleId: String
)