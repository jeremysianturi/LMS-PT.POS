package com.pos.lms.core.data.source.remote.response.student.session.detailSchedule

import com.google.gson.annotations.SerializedName

data class ListQuisionerScheduleResponse(

    @field:SerializedName("data")
	val data: List<QuisionerScheduleResponse>,

    @field:SerializedName("status")
	val status: Boolean
)