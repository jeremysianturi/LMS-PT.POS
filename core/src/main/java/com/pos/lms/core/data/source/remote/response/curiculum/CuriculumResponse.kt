package com.pos.lms.core.data.source.remote.response.curiculum

import com.google.gson.annotations.SerializedName

data class CuriculumResponse(

	@field:SerializedName("end_date")
	val endDate: String,

	@field:SerializedName("object_identifier")
	val objectIdentifier: String,

	@field:SerializedName("begin_date")
	val beginDate: String,

	@field:SerializedName("business_code")
	val businessCode: String,

	@field:SerializedName("request_description")
	val requestDescription: String,

	@field:SerializedName("changed_date")
	val changedDate: String,

	@field:SerializedName("changed_user")
	val changedUser: String,

	@field:SerializedName("request_name")
	val requestName: String,

	@field:SerializedName("company_name")
	val companyName: String,

	@field:SerializedName("competence_id")
	val competenceId: String,

	@field:SerializedName("request_type_name")
	val requestTypeName: String,

	@field:SerializedName("competence_name")
	val competenceName: String,

	@field:SerializedName("request_id")
	val requestId: String,

	@field:SerializedName("request_type_id")
	val requestTypeId: String,

	@field:SerializedName("pl_name")
	val plName: String,

	@field:SerializedName("pl_code")
	val plCode: String
)