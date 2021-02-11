package com.pos.lms.core.data.source.local.entity.materi

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "materi")
data class MateriEntity(

	@ColumnInfo(name = "end_date")
	val endDate: String,

	@ColumnInfo(name = "materi_name")
	val materiName: String,

	@ColumnInfo(name = "selling_price")
	val sellingPrice: String,

	@PrimaryKey
	@NotNull
	@ColumnInfo(name = "object_identifier")
	val objectIdentifier: String,

	@ColumnInfo(name = "address")
	val address: String,

	@ColumnInfo(name = "materi_type_name")
	val materiTypeName: String,

	@ColumnInfo(name = "begin_date")
	val beginDate: String,

	@ColumnInfo(name = "materi_id")
	val materiId: String,

	@ColumnInfo(name = "business_code")
	val businessCode: String,

	@ColumnInfo(name = "changed_date")
	val changedDate: String,

	@ColumnInfo(name = "changed_user")
	val changedUser: String,

	@ColumnInfo(name = "method_name")
	val methodName: String,

	@ColumnInfo(name = "method_id")
	val methodId: String,

	@ColumnInfo(name = "file_type")
	val fileType: String,

	@ColumnInfo(name = "company_name")
	val companyName: String,

	@ColumnInfo(name = "materi_type_id")
	val materiTypeId: String,

	@ColumnInfo(name = "purchase_price")
	val purchasePrice: String,

	@ColumnInfo(name = "pl_code_id")
	val plCodeId: String,

	@ColumnInfo(name = "competence_id")
	val competenceId: String,

	@ColumnInfo(name = "competence_name")
	val competenceName: String,

	@ColumnInfo(name = "pl_code_name")
	val plCodeName: String,

	@ColumnInfo(name = "description")
	val description: String
)