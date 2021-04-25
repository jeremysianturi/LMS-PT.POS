package com.pos.lms.core.data.source.remote.response.mentor

import com.google.gson.annotations.SerializedName

data class MentorStatus(

	@field:SerializedName("object_type")
	val objectType: String? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("value")
	val value: String? = null
)