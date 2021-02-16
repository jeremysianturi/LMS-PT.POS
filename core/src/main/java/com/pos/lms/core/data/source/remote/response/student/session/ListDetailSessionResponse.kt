package com.pos.lms.core.data.source.remote.response.student.session

import com.google.gson.annotations.SerializedName

data class ListDetailSessionResponse(

    @field:SerializedName("data")
	val data: List<DetailSessionResponse>,

    @field:SerializedName("status")
	val status: Boolean
)