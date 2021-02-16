package com.pos.lms.core.data.source.remote.response.student.session.schedule

import com.google.gson.annotations.SerializedName

data class ListScheduleResponse(

	@field:SerializedName("data")
	val data: List<ScheduleResponse>
)