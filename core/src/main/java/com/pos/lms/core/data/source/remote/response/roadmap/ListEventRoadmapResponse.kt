package com.pos.lms.core.data.source.remote.response.roadmap

import com.google.gson.annotations.SerializedName

data class ListEventRoadmapResponse(

	@field:SerializedName("data")
	val data: List<EventRoadmapResponse>
)