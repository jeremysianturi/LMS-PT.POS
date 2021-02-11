package com.pos.lms.core.data.source.remote.response.student

import com.google.gson.annotations.SerializedName

data class ListStudentResponse(

	@field:SerializedName("data")
	val data: List<StudentResponse>
)