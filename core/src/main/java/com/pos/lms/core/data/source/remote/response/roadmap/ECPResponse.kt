package com.pos.lms.core.data.source.remote.response.roadmap

import com.google.gson.annotations.SerializedName

data class ECPResponse(

    @field:SerializedName("payroll_area")
    val payrollArea: Any? = "",

    @field:SerializedName("object_identifier")
    val objectIdentifier: Int,

    @field:SerializedName("wilayah_code")
    val wilayahCode: Any? = "",

    @field:SerializedName("position_code")
    val positionCode: Any? = "",

    @field:SerializedName("applicants")
    val applicants: Any? = "",

    @field:SerializedName("position_name")
    val positionName: Any? = "",

    @field:SerializedName("business_area")
    val businessArea: Any? = "",

    @field:SerializedName("wilayah_name")
    val wilayahName: Any? = "",

    @field:SerializedName("personnel_number")
    val personnelNumber: Any? = "",

    @field:SerializedName("level_jabatan")
    val levelJabatan: Any? = "",

    @field:SerializedName("kantor_code")
    val kantorCode: Any? = "",

    @field:SerializedName("kantor_name")
    val kantorName: Any? = "",

    @field:SerializedName("job_family_name")
    val jobFamilyName: Any? = "",

    @field:SerializedName("score")
    val score: Any? = "",

    @field:SerializedName("job_name")
    val jobName: Any? = "",

    @field:SerializedName("event_code")
    val eventCode: Any? = "",

    @field:SerializedName("aspiration")
    val aspiration: Any? = "",

    @field:SerializedName("level_jabatan_order")
    val levelJabatanOrder: Any? = "",

    @field:SerializedName("ranking")
    val ranking: Any? = "",

    @field:SerializedName("job_code")
    val jobCode: Any? = "",

    @field:SerializedName("aspiration_type")
    val aspirationType: Any? = "",

    @field:SerializedName("tipe_jabatan")
    val tipeJabatan: Any? = "",

    @field:SerializedName("commitee_code")
    val commiteeCode: Any? = "",

    @field:SerializedName("job_family_id")
    val jobFamilyId: Any? = ""
)