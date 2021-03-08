package com.pos.lms.core.data.source.remote.response.student

import com.google.gson.annotations.SerializedName

data class StudentResponse(

    @field:SerializedName("end_date")
    val endDate: String? = "",

    @field:SerializedName("bussines_code")
    val bussinesCode: String? = "",

    @field:SerializedName("parti_nicknm")
    val partiNicknm: String? = "",

    @field:SerializedName("begin_date")
    val beginDate: String? = "",

    @field:SerializedName("participant_id")
    val participantId: Int,

    @field:SerializedName("batch")
    val batch: Int,

    @field:SerializedName("event_curr_stat")
    val eventCurrStat: String? = "",

    @field:SerializedName("BUSCD")
    val bUSCD: String,

    @field:SerializedName("curriculum")
    val curriculum: String? = "",

    @field:SerializedName("location_id")
    val locationId: String? = "",

    @field:SerializedName("curriculum_buscd")
    val curriculumBuscd: String,

    @field:SerializedName("cur_id")
    val curId: String? = "",

    @field:SerializedName("batch_name")
    val batchName: String? = "",

    @field:SerializedName("evnt_curr_statid")
    val evntCurrStatid: String? = "",

    @field:SerializedName("event_id")
    val eventId: Int,

    @field:SerializedName("event_type")
    val eventType: String? = "",

    @field:SerializedName("company_name")
    val companyName: String? = "",

    @field:SerializedName("event_name")
    val eventName: String? = "",

    @field:SerializedName("location")
    val location: String? = "",

    @field:SerializedName("partcipant_name")
    val partcipantName: String? = "",

    @field:SerializedName("event_stat_id")
    val eventStatId: String? = "",

    @field:SerializedName("curiculum1_buscd")
    val curiculum1Buscd: String? = "",

    @field:SerializedName("event_status")
    val eventStatus: String? = ""
)