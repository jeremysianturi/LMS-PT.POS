package com.pos.lms.core.data.source.remote.response.student.session.detailSchedule

import com.google.gson.annotations.SerializedName

data class TestScheduleResponse(

	@field:SerializedName("end_date")
	val endDate: String,

	@field:SerializedName("test_code_name")
	val testCodeName: String,

	@field:SerializedName("object_identifier")
	val objectIdentifier: String,

	@field:SerializedName("test_type_id")
	val testTypeId: String,

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

	@field:SerializedName("test_code_id")
	val testCodeId: String,

	@field:SerializedName("schedule_date")
	val scheduleDate: String,

	@field:SerializedName("schedule_name")
	val scheduleName: String,

	@field:SerializedName("changed_user")
	val changedUser: String,

	@field:SerializedName("reference")
	val reference: String,

	@field:SerializedName("test_type_name")
	val testTypeName: String,

	@field:SerializedName("relation_question_id")
	val relationQuestionId: String,

	@field:SerializedName("company_name")
	val companyName: String,

	@field:SerializedName("topic")
	val topic: String,

	@field:SerializedName("day_number")
	val dayNumber: String,

	@field:SerializedName("schedule_id")
	val scheduleId: String
)