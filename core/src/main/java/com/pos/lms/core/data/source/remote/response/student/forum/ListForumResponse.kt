package com.pos.lms.core.data.source.remote.response.student.forum

import com.google.gson.annotations.SerializedName

data class ListForumResponse(

    @field:SerializedName("data")
	val data: List<ForumListResponse>,

    @field:SerializedName("status")
	val status: Boolean
)