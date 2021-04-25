package com.pos.lms.core.data.source.remote.response.mentor

import com.google.gson.annotations.SerializedName

data class DataItem(

	@field:SerializedName("end_date")
	val endDate: String? = null,

	@field:SerializedName("external_mentoring")
	val externalMentoring: List<Any?>? = null,

	@field:SerializedName("object_identifier")
	val objectIdentifier: Int? = null,

	@field:SerializedName("change_date")
	val changeDate: String? = null,

	@field:SerializedName("begin_date")
	val beginDate: String? = null,

	@field:SerializedName("change_user")
	val changeUser: String? = null,

	@field:SerializedName("business_code")
	val businessCode: String? = null,

	@field:SerializedName("mentoring")
	val mentoring: Mentoring? = null,

	@field:SerializedName("otype")
	val otype: String? = null,

	@field:SerializedName("id")
	val id: Id? = null
)