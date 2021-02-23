package com.pos.lms.core.data.source.local.entity.student

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "mentoringDetail")
data class MentoringDetailEntity(

	@ColumnInfo(name ="end_date")
	val endDate: String,

	@ColumnInfo(name ="mentoring_title")
	val mentoringTitle: String,

	@PrimaryKey
	@NotNull
	@ColumnInfo(name ="object_identifier")
	val objectIdentifier: String,

	@ColumnInfo(name ="mentoring_duration")
	val mentoringDuration: String,

	@ColumnInfo(name ="mentoring_reference")
	val mentoringReference: String,

	@ColumnInfo(name ="begin_date")
	val beginDate: String,

	@ColumnInfo(name ="business_code")
	val businessCode: String,

	@ColumnInfo(name ="changed_date")
	val changedDate: String,

	@ColumnInfo(name ="changed_user")
	val changedUser: String,

	@ColumnInfo(name ="mentoring_topic")
	val mentoringTopic: String,

	@ColumnInfo(name ="mentoring_session")
	val mentoringSession: String,

	@ColumnInfo(name ="mentor_id")
	val mentorId: String,

	@ColumnInfo(name ="mentoring_description")
	val mentoringDescription: String,

	@ColumnInfo(name ="company_name")
	val companyName: String,

	@ColumnInfo(name ="mentor_type_name")
	val mentorTypeName: String,

	@ColumnInfo(name ="mentoring_id")
	val mentoringId: String,

	@ColumnInfo(name ="mentor_type_id")
	val mentorTypeId: String,

	@ColumnInfo(name ="mentor_name")
	val mentorName: String
)