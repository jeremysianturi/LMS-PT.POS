package com.pos.lms.core.data.source.remote.response.parId

import com.google.gson.annotations.SerializedName

/**
 * Created by Muhammad Zaim Milzam on 07/02/21.
 * linkedin : Muhammad Zaim Milzam
 */

data class ParResponse(
    @field:SerializedName("access_token")
    val accessToken: String,
    @field:SerializedName("username")
    val username: String,
    @field:SerializedName("type")
    val type: String,
    @field:SerializedName("id")
    val id: Int
)
