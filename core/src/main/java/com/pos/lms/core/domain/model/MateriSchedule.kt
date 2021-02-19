package com.pos.lms.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MateriSchedule(

    val endDate: String,
    val materiName: String,
    val sellingPrice: String,
    val objectIdentifier: String,
    val beginDate: String,
    val description: String,
    val businessCode: String,
    val changedDate: String,
    val scheduleName: String,
    val relation: String,
    val reference: String,
    val methodName: String,
    val fileType: String,
    val dayNumber: String,
    val plCodeId: String,
    val competenceName: String,
    val plCodeName: String,
    val address: String,
    val materiTypeName: String,
    val endTime: String,
    val sessionId: String,
    val beginTime: String,
    val parentType: String,
    val scheduleDate: String,
    val changedUser: String,
    val childId: String,
    val parentId: String,
    val methodId: String,
    val companyName: String,
    val materiTypeId: String,
    val purchasePrice: String,
    val topic: String,
    val competenceId: String,
    val childType: String
) : Parcelable