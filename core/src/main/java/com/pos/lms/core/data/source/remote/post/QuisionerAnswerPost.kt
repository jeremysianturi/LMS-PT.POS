package com.pos.lms.core.data.source.remote.post

import com.google.gson.annotations.SerializedName

data class QuisionerAnswerPost(

	@field:SerializedName("end_date")
	val endDate: String,

	@field:SerializedName("text_choice")
	val textChoice: String,

	@field:SerializedName("begin_date")
	val beginDate: String,

	@field:SerializedName("business_code")
	val businessCode: String,

	@field:SerializedName("participant")
	val participant: Int,

	@field:SerializedName("relation_quesioner")
	val relationQuesioner: Int,

	@field:SerializedName("quesioner")
	val quesioner: Int
)