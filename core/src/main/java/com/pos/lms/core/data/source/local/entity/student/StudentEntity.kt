package com.pos.lms.core.data.source.local.entity.student

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "Student")
data class StudentEntity(

	@ColumnInfo(name = "end_date")
	val endDate: String,

	@ColumnInfo(name = "bussines_code")
	val bussinesCode: String,

	@ColumnInfo(name = "parti_nicknm")
	val partiNicknm: String,

	@ColumnInfo(name = "begin_date")
	val beginDate: String,

	@ColumnInfo(name = "participant_id")
	val participantId: Int,

	@ColumnInfo(name = "batch")
	val batch: Int,

	@ColumnInfo(name = "event_curr_stat")
	val eventCurrStat: String,

	@PrimaryKey
	@NotNull
	@ColumnInfo(name = "BUSCD")
	val bUSCD: String,

	@ColumnInfo(name = "curriculum")
	val curriculum: String,

	@ColumnInfo(name = "location_id")
	val locationId: String,

	@ColumnInfo(name = "curriculum_buscd")
	val curriculumBuscd: String,

	@ColumnInfo(name = "cur_id")
	val curId: String,

	@ColumnInfo(name = "batch_name")
	val batchName: String,

	@ColumnInfo(name = "evnt_curr_statid")
	val evntCurrStatid: String,

	@ColumnInfo(name = "event_id")
	val eventId: Int,

	@ColumnInfo(name = "event_type")
	val eventType: String,

	@ColumnInfo(name = "company_name")
	val companyName: String,

	@ColumnInfo(name = "event_name")
	val eventName: String,

	@ColumnInfo(name = "location")
	val location: String,

	@ColumnInfo(name = "partcipant_name")
	val partcipantName: String,

	@ColumnInfo(name = "event_stat_id")
	val eventStatId: String,

	@ColumnInfo(name = "curiculum1_buscd")
	val curiculum1Buscd: String,

	@ColumnInfo(name = "event_status")
	val eventStatus: String
)