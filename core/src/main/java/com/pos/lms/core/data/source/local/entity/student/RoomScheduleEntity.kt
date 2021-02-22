package com.pos.lms.core.data.source.local.entity.student

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "RoomSchedule")
data class RoomScheduleEntity(

	@ColumnInfo(name ="end_date")
	val endDate: String,

	@ColumnInfo(name ="building_name")
	val buildingName: String,

	@PrimaryKey
	@NotNull
	@ColumnInfo(name ="object_identifier")
	val objectIdentifier: String,

	@ColumnInfo(name ="begin_date")
	val beginDate: String,

	@ColumnInfo(name ="end_time")
	val endTime: String,

	@ColumnInfo(name ="session_id")
	val sessionId: String,

	@ColumnInfo(name ="begin_time")
	val beginTime: String,

	@ColumnInfo(name ="business_code")
	val businessCode: String,

	@ColumnInfo(name ="changed_date")
	val changedDate: String,

	@ColumnInfo(name ="parent_type")
	val parentType: String,

	@ColumnInfo(name ="schedule_date")
	val scheduleDate: String,

	@ColumnInfo(name ="schedule_name")
	val scheduleName: String,

	@ColumnInfo(name ="changed_user")
	val changedUser: String,

	@ColumnInfo(name ="relation")
	val relation: String,

	@ColumnInfo(name ="reference")
	val reference: String,

	@ColumnInfo(name ="floor_name")
	val floorName: String,

	@ColumnInfo(name ="room_name")
	val roomName: String,

	@ColumnInfo(name ="building_location")
	val buildingLocation: String,

	@ColumnInfo(name ="child_id")
	val childId: String,

	@ColumnInfo(name ="parent_id")
	val parentId: String,

	@ColumnInfo(name ="company_name")
	val companyName: String,

	@ColumnInfo(name ="topic")
	val topic: String,

	@ColumnInfo(name ="day_number")
	val dayNumber: String,

	@ColumnInfo(name ="child_type")
	val childType: String
)