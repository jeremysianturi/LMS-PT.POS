package com.pos.lms.core.data.source.remote.response.student.session.mentoring

import com.google.gson.annotations.SerializedName

data class ListMentoringResponse(

    @field:SerializedName("data")
	val data: List<MentoringResponse>,

    @field:SerializedName("status")
	val status: Boolean
)