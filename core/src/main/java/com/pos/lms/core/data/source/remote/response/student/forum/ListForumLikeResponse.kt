package com.pos.lms.core.data.source.remote.response.student.forum

import com.google.gson.annotations.SerializedName

data class ListForumLikeResponse(

	@field:SerializedName("data")
	val data: List<ForumLikeResponse>,

	@field:SerializedName("meta")
	val metaResponse: MetaResponse
)