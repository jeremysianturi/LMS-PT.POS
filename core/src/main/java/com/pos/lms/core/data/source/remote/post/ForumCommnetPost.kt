package com.pos.lms.core.data.source.remote.post

import com.google.gson.annotations.SerializedName

data class ForumCommnetPost(

	@field:SerializedName("otype_parent")
	val otypeParent: String,

	@field:SerializedName("forum")
	val forum: String?,

	@field:SerializedName("owner")
	val owner: String?,

	@field:SerializedName("begin_date")
	val beginDate: String?,

	@field:SerializedName("begin_time")
	val beginTime: String?,

	@field:SerializedName("business_code")
	val businessCode: String,

	@field:SerializedName("comment")
	val comment: String
)