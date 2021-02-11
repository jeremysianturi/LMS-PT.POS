package com.pos.lms.core.data.source.remote.post

import com.google.gson.annotations.SerializedName

data class CuriculumUpdate(

	@field:SerializedName("end_date")
	val endDate: String,

	@field:SerializedName("request_name")
	val requestName: String,

	@field:SerializedName("competence")
	val competence: String,

	@field:SerializedName("object_identifier")
	val objectIdentifier: String,

	@field:SerializedName("request_type")
	val requestType: String,

	@field:SerializedName("begin_date")
	val beginDate: String,

	@field:SerializedName("business_code")
	val businessCode: String,

	@field:SerializedName("request_description")
	val requestDescription: String,

	@field:SerializedName("request_id")
	val requestId: String,

	@field:SerializedName("pl_code")
	val plCode: String
)