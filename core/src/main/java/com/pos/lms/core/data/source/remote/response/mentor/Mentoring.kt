package com.pos.lms.core.data.source.remote.response.mentor

import com.google.gson.annotations.SerializedName

data class Mentoring(

	@field:SerializedName("end_date")
	val endDate: String? = null,

	@field:SerializedName("object_identifier")
	val objectIdentifier: Int? = null,

	@field:SerializedName("session")
	val session: Int? = null,

	@field:SerializedName("change_date")
	val changeDate: String? = null,

	@field:SerializedName("begin_date")
	val beginDate: String? = null,

	@field:SerializedName("reference_mentoring")
	val referenceMentoring: Int? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("business_code")
	val businessCode: String? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("duration")
	val duration: Int? = null,

	@field:SerializedName("external_mentoring")
	val externalMentoring: List<Any?>? = null,

	@field:SerializedName("topic")
	val topic: String? = null,

	@field:SerializedName("change_user")
	val changeUser: String? = null,

	@field:SerializedName("mentoring_id")
	val mentoringId: Int? = null
)