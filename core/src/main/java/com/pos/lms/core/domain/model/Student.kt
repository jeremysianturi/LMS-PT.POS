package com.pos.lms.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Student(
    val endDate: String,
    val bussinesCode: String,
    val partiNicknm: String,
    val beginDate: String,
    val participantId: Int,
    val batch: Int,
    val eventCurrStat: String,
    val bUSCD: String,
    val curriculum: String,
    val locationId: String,
    val curriculumBuscd: String,
    val curId: String,
    val batchName: String,
    val evntCurrStatid: String,
    val eventId: Int,
    val eventType: String,
    val companyName: String,
    val eventName: String,
    val location: String,
    val partcipantName: String,
    val eventStatId: String,
    val curiculum1Buscd: String,
    val eventStatus: String
) : Parcelable