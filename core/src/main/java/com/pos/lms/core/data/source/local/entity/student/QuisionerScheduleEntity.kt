package com.pos.lms.core.data.source.local.entity.student

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "quisionerSchedule")
data class QuisionerScheduleEntity(

	@ColumnInfo(name ="end_date")
	val endDate: String,

	@ColumnInfo(name ="template_code_name")
	val templateCodeName: String,

	@PrimaryKey
	@NotNull
	@ColumnInfo(name ="object_identifier")
	val objectIdentifier: String,

	@ColumnInfo(name ="relation_type_id")
	val relationTypeId: String,

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

	@ColumnInfo(name ="schedule_date")
	val scheduleDate: String,

	@ColumnInfo(name ="schedule_name")
	val scheduleName: String,

	@ColumnInfo(name ="changed_user")
	val changedUser: String,

	@ColumnInfo(name ="relation_type_name")
	val relationTypeName: String,

	@ColumnInfo(name ="relation_quesioner_id")
	val relationQuesionerId: String,

	@ColumnInfo(name ="reference")
	val reference: String,

	@ColumnInfo(name ="template_code_id")
	val templateCodeId: String,

	@ColumnInfo(name ="company_name")
	val companyName: String,

	@ColumnInfo(name ="template_type_name")
	val templateTypeName: String,

	@ColumnInfo(name ="template_type_id")
	val templateTypeId: String,

	@ColumnInfo(name ="topic")
	val topic: String,

	@ColumnInfo(name ="day_number")
	val dayNumber: String,

	@ColumnInfo(name ="id")
	val id: String,

	@ColumnInfo(name ="schedule_id")
	val scheduleId: String
)