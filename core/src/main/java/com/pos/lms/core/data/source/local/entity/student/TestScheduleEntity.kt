package com.pos.lms.core.data.source.local.entity.student

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "TestSchedule")
data class TestScheduleEntity(

	@ColumnInfo(name ="end_date")
	val endDate: String,

	@ColumnInfo(name ="test_code_name")
	val testCodeName: String,

	@PrimaryKey
	@NotNull
	@ColumnInfo(name ="object_identifier")
	val objectIdentifier: String,

	@ColumnInfo(name ="test_type_id")
	val testTypeId: String,

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

	@ColumnInfo(name ="test_code_id")
	val testCodeId: String,

	@ColumnInfo(name ="schedule_date")
	val scheduleDate: String,

	@ColumnInfo(name ="schedule_name")
	val scheduleName: String,

	@ColumnInfo(name ="changed_user")
	val changedUser: String,

	@ColumnInfo(name ="reference")
	val reference: String,

	@ColumnInfo(name ="test_type_name")
	val testTypeName: String,

	@ColumnInfo(name ="relation_question_id")
	val relationQuestionId: String,

	@ColumnInfo(name ="company_name")
	val companyName: String,

	@ColumnInfo(name ="topic")
	val topic: String,

	@ColumnInfo(name ="day_number")
	val dayNumber: String,

	@ColumnInfo(name ="schedule_id")
	val scheduleId: String
)