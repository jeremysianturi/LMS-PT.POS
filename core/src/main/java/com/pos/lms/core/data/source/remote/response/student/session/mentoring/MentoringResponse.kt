package com.pos.lms.core.data.source.remote.response.student.session.mentoring

import com.google.gson.annotations.SerializedName

data class MentoringResponse(

	@field:SerializedName("end_date")
	val endDate: String,

	@field:SerializedName("object_identifier")
	val objectIdentifier: String,

	@field:SerializedName("session")
	val session: String,

	@field:SerializedName("change_date")
	val changeDate: String,

	@field:SerializedName("begin_date")
	val beginDate: String,

	@field:SerializedName("reference_mentoring")
	val referenceMentoring: String,

	@field:SerializedName("description")
	val description: String,

	@field:SerializedName("business_code")
	val businessCode: String,

	@field:SerializedName("title")
	val title: String,

	@field:SerializedName("duration")
	val duration: String,

	@field:SerializedName("topic")
	val topic: String,

	@field:SerializedName("change_user")
	val changeUser: String,

	@field:SerializedName("mentoring_id")
	val mentoringId: String
)