package com.pos.lms.core.data.source.remote.response.student.session.detailSchedule

import com.google.gson.annotations.SerializedName

data class QuisionerAnswerResponse(

	@field:SerializedName("end_date")
	val endDate: String,

	@field:SerializedName("object_identifier")
	val objectIdentifier: Int,

	@field:SerializedName("change_date")
	val changeDate: String,

	@field:SerializedName("begin_date")
	val beginDate: String,

	@field:SerializedName("text_choice")
	val textChoice: String,

	@field:SerializedName("change_user")
	val changeUser: String,

	@field:SerializedName("sequence_no")
	val sequenceNo: Int
)