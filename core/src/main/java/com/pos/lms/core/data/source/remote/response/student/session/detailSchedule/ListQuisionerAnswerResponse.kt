package com.pos.lms.core.data.source.remote.response.student.session.detailSchedule

import com.google.gson.annotations.SerializedName

data class ListQuisionerAnswerResponse(

	@field:SerializedName("data")
	val data: List<QuisionerAnswerResponse>
)