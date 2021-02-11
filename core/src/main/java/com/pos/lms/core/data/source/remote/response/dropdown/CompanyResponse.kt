package com.pos.lms.core.data.source.remote.response.dropdown

import com.google.gson.annotations.SerializedName

data class CompanyResponse(

	@field:SerializedName("end_date")
	val endDate: String,

	@field:SerializedName("country")
	val country: String,

	@field:SerializedName("object_identifier")
	val objectIdentifier: Int,

	@field:SerializedName("company_id")
	val companyId: String,

	@field:SerializedName("city")
	val city: String,

	@field:SerializedName("change_date")
	val changeDate: String,

	@field:SerializedName("begin_date")
	val beginDate: String,

	@field:SerializedName("business_code")
	val businessCode: String,

	@field:SerializedName("province")
	val province: String,

	@field:SerializedName("phone")
	val phone: String,

	@field:SerializedName("street")
	val street: String,

	@field:SerializedName("company_name")
	val companyName: String,

	@field:SerializedName("change_user")
	val changeUser: String,

	@field:SerializedName("postal_code")
	val postalCode: String
)