package com.pos.lms.core.domain.model

import com.google.gson.annotations.SerializedName

data class Avatar(

    @field:SerializedName("object_identifier")
    val objectIdentifier: Int?,

    @field:SerializedName("change_date")
    val changeDate: String?,

    @field:SerializedName("change_user")
    val changeUser: String?,

    @field:SerializedName("business_code")
    val businessCode: String?,

    @field:SerializedName("avatar")
    val avatar: String?,

    @field:SerializedName("username")
    val username: String?
)