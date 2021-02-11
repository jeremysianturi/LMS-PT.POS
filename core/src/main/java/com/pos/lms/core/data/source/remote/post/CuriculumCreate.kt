package com.pos.lms.core.data.source.remote.post

import com.google.gson.annotations.SerializedName

data class CuriculumCreate(

	@field:SerializedName("end_date")
	val endDate: String,

	@field:SerializedName("request_name")
	val requestName: String,

	@field:SerializedName("competence")
	val competence: String,

	@field:SerializedName("request_type")
	val requestType: String,

	@field:SerializedName("begin_date")
	val beginDate: String,

	@field:SerializedName("business_code")
	val businessCode: String,

	@field:SerializedName("request_description")
	val requestDescription: String,

	@field:SerializedName("pl_code")
	val plCode: String
)