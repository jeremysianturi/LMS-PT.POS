package com.pos.lms.core.data.source.remote.response.dropdown

import com.google.gson.annotations.SerializedName

/**
 * Created by Muhammad Zaim Milzam on 08/02/21.
 * linkedin : Muhammad Zaim Milzam
 */

data class CompetencyResponse(

    @field:SerializedName("end_date")
    val endDate: String,

    @field:SerializedName("object_identifier")
    val objectIdentifier: Int,

    @field:SerializedName("object_type")
    val objectType: String,

    @field:SerializedName("change_date")
    val changeDate: String,

    @field:SerializedName("short_text")
    val shortText: String,

    @field:SerializedName("begin_date")
    val beginDate: String,

    @field:SerializedName("business_code")
    val businessCode: String,

    @field:SerializedName("long_text")
    val longText: String,

    @field:SerializedName("plan_version")
    val planVersion: String,

    @field:SerializedName("object_description")
    val objectDescription: String,

    @field:SerializedName("change_user")
    val changeUser: String,

    @field:SerializedName("id")
    val id: String,

    @field:SerializedName("value")
    val value: String

)
