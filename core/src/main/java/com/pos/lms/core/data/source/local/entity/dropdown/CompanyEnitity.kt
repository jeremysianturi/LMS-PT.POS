package com.pos.lms.core.data.source.local.entity.dropdown

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "Company")
data class CompanyEnitity(

	@ColumnInfo(name = "end_date")
	val endDate: String,

	@ColumnInfo(name = "country")
	val country: String,

	@PrimaryKey
	@NotNull
	@ColumnInfo(name = "object_identifier")
	val objectIdentifier: Int,

	@ColumnInfo(name = "company_id")
	val companyId: String,

	@ColumnInfo(name = "city")
	val city: String,

	@ColumnInfo(name = "change_date")
	val changeDate: String,

	@ColumnInfo(name = "begin_date")
	val beginDate: String,

	@ColumnInfo(name = "business_code")
	val businessCode: String,

	@ColumnInfo(name = "province")
	val province: String,

	@ColumnInfo(name = "phone")
	val phone: String,

	@ColumnInfo(name = "street")
	val street: String,

	@ColumnInfo(name = "company_name")
	val companyName: String,

	@ColumnInfo(name = "change_user")
	val changeUser: String,

	@ColumnInfo(name = "postal_code")
	val postalCode: String
)