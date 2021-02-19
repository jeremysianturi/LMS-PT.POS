package com.pos.lms.core.data.source.remote.response.student.session.detailSchedule

import com.google.gson.annotations.SerializedName

data class ListMateriScheduleResponse(

    @field:SerializedName("data")
	val data: List<MateriScheduleResponse>,

    @field:SerializedName("status")
	val status: Boolean
)