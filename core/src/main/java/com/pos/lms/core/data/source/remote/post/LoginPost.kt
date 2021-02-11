package com.pos.lms.core.data.source.remote.post

import com.google.gson.annotations.SerializedName

data class LoginPost(
	@SerializedName("application_id")
	private var applicationId: String? = "",

	@SerializedName("username")
	private var username: String? = "",

	@SerializedName("password")
	private var password: String? = ""

)

