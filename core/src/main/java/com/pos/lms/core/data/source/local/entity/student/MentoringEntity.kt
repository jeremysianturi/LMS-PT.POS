package com.pos.lms.core.data.source.local.entity.student

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "mentoringList")
data class MentoringEntity(

	@ColumnInfo(name ="end_date")
	val endDate: String,

	@PrimaryKey
	@NotNull
	@ColumnInfo(name ="object_identifier")
	val objectIdentifier: String,

	@ColumnInfo(name ="session")
	val session: String,

	@ColumnInfo(name ="change_date")
	val changeDate: String,

	@ColumnInfo(name ="begin_date")
	val beginDate: String,

	@ColumnInfo(name ="reference_mentoring")
	val referenceMentoring: String,

	@ColumnInfo(name ="description")
	val description: String,

	@ColumnInfo(name ="business_code")
	val businessCode: String,

	@ColumnInfo(name ="title")
	val title: String,

	@ColumnInfo(name ="duration")
	val duration: String,

	@ColumnInfo(name ="topic")
	val topic: String,

	@ColumnInfo(name ="change_user")
	val changeUser: String,

	@ColumnInfo(name ="mentoring_id")
	val mentoringId: String
)