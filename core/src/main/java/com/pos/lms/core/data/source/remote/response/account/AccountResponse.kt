package com.pos.lms.core.data.source.remote.response.account

import com.google.gson.annotations.SerializedName

data class AccountResponse(

	@field:SerializedName("end_date")
	val endDate: String? = null,

	@field:SerializedName("business_name")
	val businessName: String? = null,

	@field:SerializedName("object_identifier")
	val objectIdentifier: Any? = null,

	@field:SerializedName("role")
	val role: List<String?>? = null,

	@field:SerializedName("business_address")
	val businessAddress: Any? = null,

	@field:SerializedName("change_date")
	val changeDate: String? = null,

	@field:SerializedName("begin_date")
	val beginDate: String? = null,

	@field:SerializedName("change_user")
	val changeUser: String? = null,

	@field:SerializedName("company")
	val company: String? = null,

	@field:SerializedName("email")
	val email: Any? = null,

	@field:SerializedName("company_address")
	val companyAddress: Any? = null,

	@field:SerializedName("username")
	val username: String? = null
)