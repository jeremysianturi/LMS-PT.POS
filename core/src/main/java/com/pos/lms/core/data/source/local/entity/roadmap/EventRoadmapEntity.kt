package com.pos.lms.core.data.source.local.entity.roadmap

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "eventRoadmap")
data class EventRoadmapEntity(

	@ColumnInfo(name = "end_date")
	val endDate: String,

	@PrimaryKey
	@NotNull
	@ColumnInfo(name = "object_identifier")
	val objectIdentifier: Int,

	@ColumnInfo(name = "question_group")
	val questionGroup: String,

	@ColumnInfo(name = "change_date")
	val changeDate: String,

	@ColumnInfo(name = "begin_date")
	val beginDate: String,

	@ColumnInfo(name = "description")
	val description: String,

	@ColumnInfo(name = "business_code")
	val businessCode: String,

	@ColumnInfo(name = "event_employee_dateline")
	val eventEmployeeDateline: String,

	@ColumnInfo(name = "event_type")
	val eventType: String,

	@ColumnInfo(name = "event_talent_unit_dateline")
	val eventTalentUnitDateline: String,

	@ColumnInfo(name = "event_code")
	val eventCode: String,

	@ColumnInfo(name = "start_hour")
	val startHour: String,

	@ColumnInfo(name = "quota")
	val quota: String,

	@ColumnInfo(name = "event_name")
	val eventName: String,

	@ColumnInfo(name = "change_user")
	val changeUser: String,

	@ColumnInfo(name = "end_hour")
	val endHour: String,

	@ColumnInfo(name = "event_status")
	val eventStatus: String
)