package com.pos.lms.core.data.source.remote.post

import com.google.gson.annotations.SerializedName

data class TestJawabanPost(

	@field:SerializedName("end_date")
	val endDate: String,

	@field:SerializedName("question")
	val question: Int,

	@field:SerializedName("text_choice")
	val textChoice: String,

	@field:SerializedName("begin_date")
	val beginDate: String,

	@field:SerializedName("business_code")
	val businessCode: String,

	@field:SerializedName("participant")
	val participant: Int,

	@field:SerializedName("sequence_no")
	val sequenceNo: Int,

	@field:SerializedName("relation_question")
	val relationQuestion: Int
)