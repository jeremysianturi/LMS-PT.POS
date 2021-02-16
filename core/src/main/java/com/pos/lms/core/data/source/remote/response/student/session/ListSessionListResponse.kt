package com.pos.lms.core.data.source.remote.response.student.session

import com.google.gson.annotations.SerializedName

data class ListSessionListResponse(

	@field:SerializedName("data")
	val data: List<SessionListResponse>,

	@field:SerializedName("status")
	val status: Boolean
)