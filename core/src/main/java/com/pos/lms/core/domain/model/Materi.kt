package com.pos.lms.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Materi(
    val endDate: String,
    val materiName: String,
    val sellingPrice: String,
    val objectIdentifier: String,
    val address: String,
    val materiTypeName: String,
    val beginDate: String,
    val materiId: String,
    val businessCode: String,
    val changedDate: String,
    val changedUser: String,
    val methodName: String,
    val methodId: String,
    val fileType: String,
    val companyName: String,
    val materiTypeId: String,
    val purchasePrice: String,
    val plCodeId: String,
    val competenceId: String,
    val competenceName: String,
    val plCodeName: String,
    val description: String

) : Parcelable