package com.pos.lms.core.data.source.remote.response.profile

import com.google.gson.annotations.SerializedName

data class AvatarResponse(

    @field:SerializedName("object_identifier")
    val objectIdentifier: Int? = 0,

    @field:SerializedName("change_date")
    val changeDate: String? = "",

    @field:SerializedName("change_user")
    val changeUser: String? = "",

    @field:SerializedName("business_code")
    val businessCode: String? = "",

    @field:SerializedName("avatar")
    val avatar: String? = "",

    @field:SerializedName("username")
    val username: String? = ""
)