package com.pos.lms.core.data.source.remote.response.student.forum

import com.google.gson.annotations.SerializedName

data class PaginationResponse(

	@field:SerializedName("per_page")
	val perPage: Int,

	@field:SerializedName("total")
	val total: Int,

	@field:SerializedName("count")
	val count: Int,

	@field:SerializedName("links")
	val links: List<Any>,

	@field:SerializedName("total_pages")
	val totalPages: Int,

	@field:SerializedName("current_page")
	val currentPage: Int
)