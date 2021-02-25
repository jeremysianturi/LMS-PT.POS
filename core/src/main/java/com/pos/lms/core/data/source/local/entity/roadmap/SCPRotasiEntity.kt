package com.pos.lms.core.data.source.local.entity.roadmap

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "scpRotasi")
data class SCPRotasiEntity(
    @ColumnInfo(name = "payroll_area")
    val payrollArea: String,

    @PrimaryKey
    @NotNull
    @ColumnInfo(name = "object_identifier")
    val objectIdentifier: Int,

    @ColumnInfo(name = "wilayah_code")
    val wilayahCode: String,

    @ColumnInfo(name = "position_code")
    val positionCode: String,

    @ColumnInfo(name = "applicants")
    val applicants: String,

    @ColumnInfo(name = "position_name")
    val positionName: String,

    @ColumnInfo(name = "business_area")
    val businessArea: String,

    @ColumnInfo(name = "wilayah_name")
    val wilayahName: String,

    @ColumnInfo(name = "personnel_number")
    val personnelNumber: String,

    @ColumnInfo(name = "level_jabatan")
    val levelJabatan: String,

    @ColumnInfo(name = "kantor_code")
    val kantorCode: String,

    @ColumnInfo(name = "kantor_name")
    val kantorName: String,

    @ColumnInfo(name = "job_family_name")
    val jobFamilyName: String,

    @ColumnInfo(name = "score")
    val score: String,

    @ColumnInfo(name = "job_name")
    val jobName: String,

    @ColumnInfo(name = "event_code")
    val eventCode: String,

    @ColumnInfo(name = "aspiration")
    val aspiration: String,

    @ColumnInfo(name = "level_jabatan_order")
    val levelJabatanOrder: String,

    @ColumnInfo(name = "ranking")
    val ranking: String,

    @ColumnInfo(name = "job_code")
    val jobCode: String,

    @ColumnInfo(name = "aspiration_type")
    val aspirationType: String,

    @ColumnInfo(name = "tipe_jabatan")
    val tipeJabatan: String,

    @ColumnInfo(name = "commitee_code")
    val commiteeCode: String,

    @ColumnInfo(name = "job_family_id")
    val jobFamilyId: String
)