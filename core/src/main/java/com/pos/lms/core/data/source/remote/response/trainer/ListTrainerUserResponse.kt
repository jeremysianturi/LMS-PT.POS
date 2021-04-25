package com.pos.lms.core.data.source.remote.response.trainer

import com.google.gson.annotations.SerializedName

data class ListTrainerUserResponse(

	@field:SerializedName("data")
	val data: List<TrainerResponse>
)