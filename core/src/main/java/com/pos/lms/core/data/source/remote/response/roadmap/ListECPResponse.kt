package com.pos.lms.core.data.source.remote.response.roadmap

import com.google.gson.annotations.SerializedName

data class ListECPResponse(

	@field:SerializedName("data")
	val data: List<ECPResponse>
)