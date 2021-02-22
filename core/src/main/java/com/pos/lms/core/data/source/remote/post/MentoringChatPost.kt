package com.pos.lms.core.data.source.remote.post

import com.google.gson.annotations.SerializedName

data class MentoringChatPost(

	@field:SerializedName("sender")
	val sender: Int,

	@field:SerializedName("sender_type")
	val senderType: String,

	@field:SerializedName("business_code")
	val businessCode: String,

	@field:SerializedName("mentoring")
	val mentoring: Int,

	@field:SerializedName("otype")
	val otype: String,

	@field:SerializedName("text")
	val text: String
)