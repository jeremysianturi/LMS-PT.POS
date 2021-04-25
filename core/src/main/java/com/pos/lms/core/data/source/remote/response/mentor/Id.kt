package com.pos.lms.core.data.source.remote.response.mentor

import com.google.gson.annotations.SerializedName

data class Id(

	@field:SerializedName("end_date")
	val endDate: String? = null,

	@field:SerializedName("mentor_id")
	val mentorId: Int? = null,

	@field:SerializedName("object_identifier")
	val objectIdentifier: Int? = null,

	@field:SerializedName("change_date")
	val changeDate: String? = null,

	@field:SerializedName("begin_date")
	val beginDate: String? = null,

	@field:SerializedName("change_user")
	val changeUser: String? = null,

	@field:SerializedName("business_code")
	val businessCode: BusinessCode? = null,

	@field:SerializedName("company")
	val company: Company? = null,

	@field:SerializedName("personnel_number")
	val personnelNumber: String? = null,

	@field:SerializedName("mentor_status")
	val mentorStatus: MentorStatus? = null,

	@field:SerializedName("mentor_name")
	val mentorName: String? = null
)