package com.pos.lms.core.data.source.remote.response.dropdown

import com.google.gson.annotations.SerializedName

data class ListPLResponse(

	@field:SerializedName("data")
	val data: List<PLResponse>
)