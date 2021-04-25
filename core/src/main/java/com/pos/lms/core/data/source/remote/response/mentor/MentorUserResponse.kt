package com.pos.lms.core.data.source.remote.response.mentor

import com.google.gson.annotations.SerializedName

data class MentorUserResponse(

	@field:SerializedName("end_date")
	val endDate: String? = null,

	@field:SerializedName("mentoring_title")
	val mentoringTitle: String? = null,

	@field:SerializedName("object_identifier")
	val objectIdentifier: Int? = null,

	@field:SerializedName("mentoring_duration")
	val mentoringDuration: Int? = null,

	@field:SerializedName("mentoring_change_user")
	val mentoringChangeUser: String? = null,

	@field:SerializedName("change_date")
	val changeDate: String? = null,

	@field:SerializedName("begin_date")
	val beginDate: String? = null,

	@field:SerializedName("business_code")
	val businessCode: String? = null,

	@field:SerializedName("mentoring")
	val mentoring: Int? = null,

	@field:SerializedName("personnel_number")
	val personnelNumber: String? = null,

	@field:SerializedName("mentoring_change_date")
	val mentoringChangeDate: String? = null,

	@field:SerializedName("mentoring_topic")
	val mentoringTopic: String? = null,

	@field:SerializedName("mentoring_session")
	val mentoringSession: Int? = null,

	@field:SerializedName("mentoring_mentoring_id")
	val mentoringMentoringId: Int? = null,

	@field:SerializedName("mentoring_business_code")
	val mentoringBusinessCode: String? = null,

	@field:SerializedName("mentor_id")
	val mentorId: Int? = null,

	@field:SerializedName("mentoring_end_date")
	val mentoringEndDate: String? = null,

	@field:SerializedName("mentoring_description")
	val mentoringDescription: String? = null,

	@field:SerializedName("mentoring_reference_mentoring")
	val mentoringReferenceMentoring: Int? = null,

	@field:SerializedName("change_user")
	val changeUser: String? = null,

	@field:SerializedName("otype")
	val otype: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("mentor_name")
	val mentorName: String? = null,

	@field:SerializedName("mentoring_begin_date")
	val mentoringBeginDate: String? = null
)