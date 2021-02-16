package com.pos.lms.core.data.source.remote.response.student.session.schedule

import com.google.gson.annotations.SerializedName

data class ScheduleResponse(

	@field:SerializedName("end_date")
	val endDate: String,

	@field:SerializedName("object_identifier")
	val objectIdentifier: Int,

	@field:SerializedName("change_date")
	val changeDate: String,

	@field:SerializedName("begin_date")
	val beginDate: String,

	@field:SerializedName("end_time")
	val endTime: String,

	@field:SerializedName("begin_time")
	val beginTime: String,

	@field:SerializedName("change_user")
	val changeUser: String,

	@field:SerializedName("day_number")
	val dayNumber: Int,

	@field:SerializedName("topic")
	val topic: String,

	@field:SerializedName("schedule_date")
	val scheduleDate: String,

	@field:SerializedName("schedule_id")
	val scheduleId: Int,

	@field:SerializedName("schedule_name")
	val scheduleName: String
)