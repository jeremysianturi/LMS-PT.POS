package com.pos.lms.core.data.source.remote.response.mentor

import com.google.gson.annotations.SerializedName

data class ListMentorHashResponse(

	@field:SerializedName("data")
	val data: List<DataItem?>? = null,

	@field:SerializedName("meta")
	val meta: Meta? = null
)