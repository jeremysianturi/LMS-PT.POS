package com.pos.lms.core.data.source.remote.response.mentor

import com.google.gson.annotations.SerializedName

data class Meta(

	@field:SerializedName("pagination")
	val pagination: Pagination? = null
)