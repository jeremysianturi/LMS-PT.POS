package com.pos.lms.core.data.source.local.entity.student

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "SessionList")
data class SessionListEntity(

	@ColumnInfo(name ="end_date")
	val endDate: String,

	@ColumnInfo(name ="session_name")
	val sessionName: String,

	@ColumnInfo(name ="activity_name")
	val activityName: String,

	@PrimaryKey
	@NotNull
	@ColumnInfo(name ="object_identifier")
	val objectIdentifier: String,

	@ColumnInfo(name ="cycle_id")
	val cycleId: String,

	@ColumnInfo(name ="batch_id")
	val batchId: String,

	@ColumnInfo(name ="begin_date")
	val beginDate: String,

	@ColumnInfo(name ="session_id")
	val sessionId: String,

	@ColumnInfo(name ="changed_date")
	val changedDate: String,

	@ColumnInfo(name ="changed_user")
	val changedUser: String,

	@ColumnInfo(name ="activity_type_id")
	val activityTypeId: String,

	@ColumnInfo(name ="activity_type_name")
	val activityTypeName: String,

	@ColumnInfo(name ="activity_id")
	val activityId: String,

	@ColumnInfo(name ="cycle_name")
	val cycleName: String
)