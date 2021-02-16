package com.pos.lms.core.data.source.remote.response.student.session

import com.google.gson.annotations.SerializedName

data class SessionListResponse(

	@field:SerializedName("end_date")
	val endDate: String,

	@field:SerializedName("session_name")
	val sessionName: String,

	@field:SerializedName("activity_name")
	val activityName: String,

	@field:SerializedName("object_identifier")
	val objectIdentifier: String,

	@field:SerializedName("cycle_id")
	val cycleId: String,

	@field:SerializedName("batch_id")
	val batchId: String,

	@field:SerializedName("begin_date")
	val beginDate: String,

	@field:SerializedName("session_id")
	val sessionId: String,

	@field:SerializedName("changed_date")
	val changedDate: String,

	@field:SerializedName("changed_user")
	val changedUser: String,

	@field:SerializedName("activity_type_id")
	val activityTypeId: String,

	@field:SerializedName("activity_type_name")
	val activityTypeName: String,

	@field:SerializedName("activity_id")
	val activityId: String,

	@field:SerializedName("cycle_name")
	val cycleName: String
)