package com.pos.lms.core.data.source.remote.response.student.forum

import com.google.gson.annotations.SerializedName

data class ListForumCommentResponse(

	@field:SerializedName("data")
	val data: List<ForumCommentResponse>
)