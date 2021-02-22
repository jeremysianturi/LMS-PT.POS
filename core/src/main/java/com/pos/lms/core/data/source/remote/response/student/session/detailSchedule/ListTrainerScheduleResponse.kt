package com.pos.lms.core.data.source.remote.response.student.session.detailSchedule

import com.google.gson.annotations.SerializedName

data class ListTrainerScheduleResponse(

    @field:SerializedName("data")
	val data: List<TrainerScheduleResponse>,

    @field:SerializedName("status")
	val status: Boolean
)