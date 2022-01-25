package com.pos.lms.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class TrainerUser(
    val sessionName: String,
    val cHGDT: String,
    val pERNR: String,
    val eNDDA: String,
    val bUSCD: String,
    val situationCode: String,
    val scheduleName: String,
    val dayNumber: Int,
    val tRAID: Int,
    val eventStatId: String,
    val trainerName: String,
    val eventStatus: String,
    val situationName: String,
    val bEGDA: String,
    val bUSC1: String,
    val endTime: String,
    val batch: Int,
    val sessionId: Int,
    val beginTime: String,
    val batchName: String,
    val eventId: Int,
    val topic: String,
    val eventName: String,
    val tRNAM: String,
    val sTTAR: String,
    val cHUSR: String,
    val scheduleId: Int
) : Parcelable