package com.pos.lms.core.data.source.remote.response.profile

import com.google.gson.annotations.SerializedName

data class ListAvatarResponse(

	@field:SerializedName("data")
	val data: List<AvatarResponse>
)