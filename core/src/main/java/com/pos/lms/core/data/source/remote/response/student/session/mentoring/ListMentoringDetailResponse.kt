package com.pos.lms.core.data.source.remote.response.student.session.mentoring

import com.google.gson.annotations.SerializedName

data class ListMentoringDetailResponse(

    @field:SerializedName("data")
	val data: List<MentoringDetailResponse>,

    @field:SerializedName("status")
	val status: Boolean
)