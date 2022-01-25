package com.pos.lms.core.data.source.remote.response.mentor

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MentorTemp(

    val object_identifier: Int? = 0,
    val begiDate: String? = "",
    val endDate: String? = "",
    val business_code: String? = "",

    val idMEntor: Int? = 0,
    val nameMentor: String? = "",
    val personnel_number: String = "",

    val otype: String? = "",

    val Tittle: String? = "",
    val topic: String? = "",
    val description: String? = "",
    val duration: Int? = 0,
    val mentoringId: Int? = 0,
    val session: Int? = 0

) : Parcelable
