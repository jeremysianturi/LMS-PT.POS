package com.pos.lms.core.data.source.remote.response.student.insight

import com.google.gson.annotations.SerializedName

data class ListInsightResponse(

    @field:SerializedName("data")
	val data: List<InsightListResponse>,

    @field:SerializedName("status")
	val status: Boolean
)