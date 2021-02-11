package com.pos.lms.core.data.source.remote.response.materi

import com.google.gson.annotations.SerializedName

data class ListMateriResponse(

    @field:SerializedName("data")
	val data: List<MateriResponse>,

    @field:SerializedName("status")
	val status: Boolean
)