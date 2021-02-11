package com.pos.lms.core.data.source.remote.response.dropdown

import com.google.gson.annotations.SerializedName

data class ListTypeResponse(

	@field:SerializedName("data")
	val data: List<TypeResponse>

)

