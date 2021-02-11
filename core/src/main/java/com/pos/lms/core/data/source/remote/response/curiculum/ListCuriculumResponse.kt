package com.pos.lms.core.data.source.remote.response.curiculum

import com.google.gson.annotations.SerializedName

data class ListCuriculumResponse(

    @field:SerializedName("data")
	val data: List<CuriculumResponse>,

    @field:SerializedName("status")
	val status: Boolean
)