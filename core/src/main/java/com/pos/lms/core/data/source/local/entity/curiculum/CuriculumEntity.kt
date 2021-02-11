package com.pos.lms.core.data.source.local.entity.curiculum

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "curiculum")
data class CuriculumEntity(

	@ColumnInfo(name = "end_date")
	val endDate: String,

	@PrimaryKey
	@NotNull
	@ColumnInfo(name = "object_identifier")
	val objectIdentifier: String,

	@ColumnInfo(name = "begin_date")
	val beginDate: String,

	@ColumnInfo(name = "business_code")
	val businessCode: String,

	@ColumnInfo(name = "request_description")
	val requestDescription: String,

	@ColumnInfo(name = "changed_date")
	val changedDate: String,

	@ColumnInfo(name = "changed_user")
	val changedUser: String,

	@ColumnInfo(name = "request_name")
	val requestName: String,

	@ColumnInfo(name = "company_name")
	val companyName: String,

	@ColumnInfo(name = "competence_id")
	val competenceId: String,

	@ColumnInfo(name = "request_type_name")
	val requestTypeName: String,

	@ColumnInfo(name = "competence_name")
	val competenceName: String,

	@ColumnInfo(name = "request_id")
	val requestId: String,

	@ColumnInfo(name = "request_type_id")
	val requestTypeId: String,

	@ColumnInfo(name = "pl_name")
	val plName: String,

	@ColumnInfo(name = "pl_code")
	val plCode: String
)