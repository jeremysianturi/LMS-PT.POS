package com.pos.lms.core.data.source.remote.response.student.session.detailSchedule

import com.google.gson.annotations.SerializedName

data class ListRoomScheduleResponse(

    @field:SerializedName("data")
	val data: List<RoomScheduleResponse>,

    @field:SerializedName("status")
	val status: Boolean
)