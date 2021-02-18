package com.pos.lms.core.data.source.remote.response.student.forum

import com.google.gson.annotations.SerializedName

data class ForumCommentResponse(

	@field:SerializedName("owner")
	val owner: String,

	@field:SerializedName("object_identifier")
	val objectIdentifier: Int,

	@field:SerializedName("change_date")
	val changeDate: String,

	@field:SerializedName("begin_date")
	val beginDate: String,

	@field:SerializedName("begin_time")
	val beginTime: String,

	@field:SerializedName("change_user")
	val changeUser: String,

	@field:SerializedName("comment")
	val comment: String
)