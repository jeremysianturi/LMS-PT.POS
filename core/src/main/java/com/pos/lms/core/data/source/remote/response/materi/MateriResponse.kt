package com.pos.lms.core.data.source.remote.response.materi

import com.google.gson.annotations.SerializedName

data class MateriResponse(

	@field:SerializedName("end_date")
	val endDate: String,

	@field:SerializedName("materi_name")
	val materiName: String,

	@field:SerializedName("selling_price")
	val sellingPrice: String,

	@field:SerializedName("object_identifier")
	val objectIdentifier: String,

	@field:SerializedName("address")
	val address: String,

	@field:SerializedName("materi_type_name")
	val materiTypeName: String,

	@field:SerializedName("begin_date")
	val beginDate: String,

	@field:SerializedName("materi_id")
	val materiId: String,

	@field:SerializedName("business_code")
	val businessCode: String,

	@field:SerializedName("changed_date")
	val changedDate: String,

	@field:SerializedName("changed_user")
	val changedUser: String,

	@field:SerializedName("method_name")
	val methodName: String,

	@field:SerializedName("method_id")
	val methodId: String,

	@field:SerializedName("file_type")
	val fileType: String,

	@field:SerializedName("company_name")
	val companyName: String,

	@field:SerializedName("materi_type_id")
	val materiTypeId: String,

	@field:SerializedName("purchase_price")
	val purchasePrice: String,

	@field:SerializedName("pl_code_id")
	val plCodeId: String,

	@field:SerializedName("competence_id")
	val competenceId: String,

	@field:SerializedName("competence_name")
	val competenceName: String,

	@field:SerializedName("pl_code_name")
	val plCodeName: String,

	@field:SerializedName("description")
	val description: String
)