package com.pos.lms.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Curiculum(
    val endDate: String,
    val objectIdentifier: String,
    val beginDate: String,
    val businessCode: String,
    val requestDescription: String,
    val changedDate: String,
    val changedUser: String,
    val requestName: String,
    val companyName: String,
    val competenceId: String,
    val requestTypeName: String,
    val competenceName: String,
    val requestId: String,
    val requestTypeId: String,
    val plName: String,
    val plCode: String
) : Parcelable
