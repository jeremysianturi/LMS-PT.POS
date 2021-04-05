package com.pos.lms.core.data.source.remote.response.student.session.detailSchedule

import com.google.gson.annotations.SerializedName

data class TestJawabanResponse(

    @field:SerializedName("end_date")
    val endDate: String? = "",

    @field:SerializedName("score")
    val score: Int? = 0,

    @field:SerializedName("flag_true")
    val flagTrue: Boolean? = false,

    @field:SerializedName("object_identifier")
    val objectIdentifier: Int? = 0,

    @field:SerializedName("question")
    val question: Int? = 0,

    @field:SerializedName("change_date")
    val changeDate: String? = "",

    @field:SerializedName("begin_date")
    val beginDate: String? = "",

    @field:SerializedName("text_choice")
    val textChoice: String? = "",

    @field:SerializedName("change_user")
    val changeUser: String? = "",

    @field:SerializedName("business_code")
    val businessCode: String? = "",

    @field:SerializedName("sequence_no")
    val sequenceNo: Int? = 0,
)