package com.pos.lms.core.data.source.remote.response.student.session.mentoring

import com.google.gson.annotations.SerializedName

data class MentoringDetailResponse(

	@field:SerializedName("end_date")
	val endDate: String,

	@field:SerializedName("mentoring_title")
	val mentoringTitle: String,

	@field:SerializedName("object_identifier")
	val objectIdentifier: String,

	@field:SerializedName("mentoring_duration")
	val mentoringDuration: String,

	@field:SerializedName("mentoring_reference")
	val mentoringReference: String,

	@field:SerializedName("begin_date")
	val beginDate: String,

	@field:SerializedName("business_code")
	val businessCode: String,

	@field:SerializedName("changed_date")
	val changedDate: String,

	@field:SerializedName("changed_user")
	val changedUser: String,

	@field:SerializedName("mentoring_topic")
	val mentoringTopic: String,

	@field:SerializedName("mentoring_session")
	val mentoringSession: String,

	@field:SerializedName("mentor_id")
	val mentorId: String,

	@field:SerializedName("mentoring_description")
	val mentoringDescription: String,

	@field:SerializedName("company_name")
	val companyName: String,

	@field:SerializedName("mentor_type_name")
	val mentorTypeName: String,

	@field:SerializedName("mentoring_id")
	val mentoringId: String,

	@field:SerializedName("mentor_type_id")
	val mentorTypeId: String,

	@field:SerializedName("mentor_name")
	val mentorName: String
)