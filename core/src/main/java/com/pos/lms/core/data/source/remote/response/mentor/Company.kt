package com.pos.lms.core.data.source.remote.response.mentor

import com.google.gson.annotations.SerializedName

data class Company(

	@field:SerializedName("end_date")
	val endDate: String? = null,

	@field:SerializedName("company_type")
	val companyType: CompanyType? = null,

	@field:SerializedName("country")
	val country: Country? = null,

	@field:SerializedName("object_identifier")
	val objectIdentifier: Int? = null,

	@field:SerializedName("city")
	val city: List<Any?>? = null,

	@field:SerializedName("change_date")
	val changeDate: String? = null,

	@field:SerializedName("begin_date")
	val beginDate: String? = null,

	@field:SerializedName("business_code")
	val businessCode: String? = null,

	@field:SerializedName("province")
	val province: Province? = null,

	@field:SerializedName("phone")
	val phone: String? = null,

	@field:SerializedName("street")
	val street: String? = null,

	@field:SerializedName("company_name")
	val companyName: String? = null,

	@field:SerializedName("change_user")
	val changeUser: String? = null,

	@field:SerializedName("postal_code")
	val postalCode: String? = null
)