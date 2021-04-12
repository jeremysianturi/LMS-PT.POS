package com.pos.lms.core.data.source.remote.post

import com.google.gson.annotations.SerializedName

data class ForumLikePost(

	@field:SerializedName("otype_parent")
	val otypeParent: String,

	@field:SerializedName("forum")
	val forum: Int,

	@field:SerializedName("owner")
	val owner: String,

	@field:SerializedName("like")
	val like: Boolean,

	@field:SerializedName("begin_date")
	val beginDate: String,

	@field:SerializedName("begin_time")
	val beginTime: String,

	@field:SerializedName("business_code")
	val businessCode: String
)