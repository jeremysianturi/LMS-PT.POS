package com.pos.lms.core.data.source.local.entity.trainer

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "TrainerUser")
data class TrainerUserEntity(

    @ColumnInfo(name = "session_name")
    val sessionName: String,

    @ColumnInfo(name = "CHGDT")
    val cHGDT: String,

    @PrimaryKey
    @NotNull
    @ColumnInfo(name = "PERNR")
    val pERNR: String,

    @ColumnInfo(name = "ENDDA")
    val eNDDA: String,

    @ColumnInfo(name = "BUSCD")
    val bUSCD: String,

    @ColumnInfo(name = "situation_code")
    val situationCode: String,

    @ColumnInfo(name = "schedule_name")
    val scheduleName: String,

    @ColumnInfo(name = "day_number")
    val dayNumber: Int,

    @ColumnInfo(name = "TRAID")
    val tRAID: Int,

    @ColumnInfo(name = "event_stat_id")
    val eventStatId: String,

    @ColumnInfo(name = "trainer_name")
    val trainerName: String,

    @ColumnInfo(name = "event_status")
    val eventStatus: String,

    @ColumnInfo(name = "situation_name")
    val situationName: String,

    @ColumnInfo(name = "BEGDA")
    val bEGDA: String,

    @ColumnInfo(name = "BUSC1")
    val bUSC1: String,

    @ColumnInfo(name = "end_time")
    val endTime: String,

    @ColumnInfo(name = "batch")
    val batch: Int,

    @ColumnInfo(name = "session_id")
    val sessionId: Int,

    @ColumnInfo(name = "begin_time")
    val beginTime: String,

    @ColumnInfo(name = "batch_name")
    val batchName: String,

    @ColumnInfo(name = "event_id")
    val eventId: Int,

    @ColumnInfo(name = "topic")
    val topic: String,

    @ColumnInfo(name = "event_name")
    val eventName: String,

    @ColumnInfo(name = "TRNAM")
    val tRNAM: String,

    @ColumnInfo(name = "STTAR")
    val sTTAR: String,

    @ColumnInfo(name = "CHUSR")
    val cHUSR: String,

    @ColumnInfo(name = "schedule_id")
    val scheduleId: Int
)