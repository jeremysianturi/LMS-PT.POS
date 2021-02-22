package com.pos.lms.core.data.source.remote.response.student.session.detailSchedule

import com.google.gson.annotations.SerializedName

data class RoomScheduleResponse(

	@field:SerializedName("end_date")
	val endDate: String,

	@field:SerializedName("building_name")
	val buildingName: String,

	@field:SerializedName("object_identifier")
	val objectIdentifier: String,

	@field:SerializedName("begin_date")
	val beginDate: String,

	@field:SerializedName("end_time")
	val endTime: String,

	@field:SerializedName("session_id")
	val sessionId: String,

	@field:SerializedName("begin_time")
	val beginTime: String,

	@field:SerializedName("business_code")
	val businessCode: String,

	@field:SerializedName("changed_date")
	val changedDate: String,

	@field:SerializedName("parent_type")
	val parentType: String,

	@field:SerializedName("schedule_date")
	val scheduleDate: String,

	@field:SerializedName("schedule_name")
	val scheduleName: String,

	@field:SerializedName("changed_user")
	val changedUser: String,

	@field:SerializedName("relation")
	val relation: String,

	@field:SerializedName("reference")
	val reference: String,

	@field:SerializedName("floor_name")
	val floorName: String,

	@field:SerializedName("room_name")
	val roomName: String,

	@field:SerializedName("building_location")
	val buildingLocation: String,

	@field:SerializedName("child_id")
	val childId: String,

	@field:SerializedName("parent_id")
	val parentId: String,

	@field:SerializedName("company_name")
	val companyName: String,

	@field:SerializedName("topic")
	val topic: String,

	@field:SerializedName("day_number")
	val dayNumber: String,

	@field:SerializedName("child_type")
	val childType: String
)