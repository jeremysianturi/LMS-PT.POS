package com.pos.lms.core.data.source.remote.response.student.session.detailSchedule

import com.google.gson.annotations.SerializedName

data class ListQuisionerPertanyaanResponse(

    @field:SerializedName("data")
	val data: List<QuisionerPertanyaanResponse>,

    @field:SerializedName("status")
	val status: Boolean
)