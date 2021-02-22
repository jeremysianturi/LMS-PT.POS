package com.pos.lms.core.data.source.remote.response.student.session.detailSchedule

import com.google.gson.annotations.SerializedName

data class ListTestScheduleResponse(

    @field:SerializedName("data")
	val data: List<TestScheduleResponse>,

    @field:SerializedName("status")
	val status: Boolean
)