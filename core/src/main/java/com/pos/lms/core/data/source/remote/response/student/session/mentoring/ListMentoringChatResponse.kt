package com.pos.lms.core.data.source.remote.response.student.session.mentoring

import com.google.gson.annotations.SerializedName

data class ListMentoringChatResponse(

    @field:SerializedName("data")
	val data: List<MentoringChatResponse>,

    @field:SerializedName("status")
	val status: Boolean
)