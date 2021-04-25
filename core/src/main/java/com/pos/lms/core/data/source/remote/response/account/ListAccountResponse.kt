package com.pos.lms.core.data.source.remote.response.account

import com.google.gson.annotations.SerializedName

data class ListAccountResponse(

	@field:SerializedName("data")
	val accountResponse: AccountResponse? = null
)