package com.pos.lms.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class QuisionerPertanyaan(
    val endDate: String,
    val objectIdentifier: String,
    val quesionerPurposeName: String,
    val beginDate: String,
    val quesionerPurposeId: String,
    val businessCode: String,
    val changedDate: String,
    val quesionerTitle: String,
    val changedUser: String,
    val quesionerTypeId: String,
    val relation: String,
    val tableCode: String,
    val companyName: String,
    val quesionerId: String,
    val otype: String,
    val quesionerCategoryId: String,
    val questionerTypeName: String,
    val quesionerCategoryName: String,
    val quesionerText: String,
    val numberOfChoice: String,
    val objects: String,
    val _id: Long
) : Parcelable