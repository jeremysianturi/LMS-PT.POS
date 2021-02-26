package com.pos.lms.core.data.source.remote.response.student.session.detailSchedule

import com.google.gson.annotations.SerializedName

data class QuisionerPertanyaanResponse(

	@field:SerializedName("end_date")
	val endDate: String,

	@field:SerializedName("object_identifier")
	val objectIdentifier: String,

	@field:SerializedName("quesioner_purpose_name")
	val quesionerPurposeName: String,

	@field:SerializedName("begin_date")
	val beginDate: String,

	@field:SerializedName("quesioner_purpose_id")
	val quesionerPurposeId: String,

	@field:SerializedName("business_code")
	val businessCode: String,

	@field:SerializedName("changed_date")
	val changedDate: String,

	@field:SerializedName("quesioner_title")
	val quesionerTitle: String,

	@field:SerializedName("changed_user")
	val changedUser: String,

	@field:SerializedName("quesioner_type_id")
	val quesionerTypeId: String,

	@field:SerializedName("relation")
	val relation: String,

	@field:SerializedName("table_code")
	val tableCode: String,

	@field:SerializedName("company_name")
	val companyName: String,

	@field:SerializedName("quesioner_id")
	val quesionerId: String,

	@field:SerializedName("otype")
	val otype: String,

	@field:SerializedName("quesioner_category_id")
	val quesionerCategoryId: String,

	@field:SerializedName("questioner_type_name")
	val questionerTypeName: String,

	@field:SerializedName("quesioner_category_name")
	val quesionerCategoryName: String,

	@field:SerializedName("quesioner_text")
	val quesionerText: String,

	@field:SerializedName("number_of_choice")
	val numberOfChoice: String,

	@field:SerializedName("object")
	val objects: String
)