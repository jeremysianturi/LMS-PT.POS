package com.pos.lms.core.data.source.remote.response.student.session.mentoring

import com.google.gson.annotations.SerializedName

data class MentoringChatResponse(

	@field:SerializedName("chat_type")
	val chatType: String,

	@field:SerializedName("object_identifier")
	val objectIdentifier: String,

	@field:SerializedName("chat_text")
	val chatText: String,

	@field:SerializedName("sender_type")
	val senderType: String,

	@field:SerializedName("begin_date")
	val beginDate: String,

	@field:SerializedName("business_code")
	val businessCode: String,

	@field:SerializedName("sender_name")
	val senderName: String,

	@field:SerializedName("mentoring_id")
	val mentoringId: String,

	@field:SerializedName("sender_id")
	val senderId: String
)