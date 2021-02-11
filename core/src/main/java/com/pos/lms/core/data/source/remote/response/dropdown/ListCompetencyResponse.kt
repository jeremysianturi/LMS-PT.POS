package com.pos.lms.core.data.source.remote.response.dropdown

import com.google.gson.annotations.SerializedName

data class ListCompetencyResponse(

	@field:SerializedName("data")
	val data: List<CompetencyResponse>

)

