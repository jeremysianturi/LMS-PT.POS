package com.pos.lms.core.data.source.remote.response.student.forum

import com.google.gson.annotations.SerializedName

data class MetaResponse(

	@field:SerializedName("pagination")
	val paginationResponse: PaginationResponse
)