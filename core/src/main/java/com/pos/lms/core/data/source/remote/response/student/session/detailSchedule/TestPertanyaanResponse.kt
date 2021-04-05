package com.pos.lms.core.data.source.remote.response.student.session.detailSchedule

import com.google.gson.annotations.SerializedName

data class TestPertanyaanResponse(

    @field:SerializedName("question_text")
    val questionText: String? = null,

    @field:SerializedName("table_code")
    val tableCode: String? = null,

    @field:SerializedName("object_identifier")
    val objectIdentifier: Int? = null,

    @field:SerializedName("tqsid")
    val tqsid: Int? = null,

    @field:SerializedName("company_name")
    val companyName: String? = null,

    @field:SerializedName("question_name")
    val questionName: String? = null,

    @field:SerializedName("question_image")
    val questionImage: Any? = null,

    @field:SerializedName("business_code")
    val businessCode: String? = null,

    @field:SerializedName("otype")
    val otype: String? = null,

    @field:SerializedName("relation")
    val relation: String? = null,

    @field:SerializedName("object")
    val objects: String? = null
)