package com.pos.lms.core.data.source.remote.response.student.forum

import com.google.gson.annotations.SerializedName

data class ForumLikeResponse(

    @field:SerializedName("owner")
    val owner: String,

    @field:SerializedName("object_identifier")
    val objectIdentifier: Int,

    @field:SerializedName("like")
    val like: Boolean,

    @field:SerializedName("change_date")
    val changeDate: String,

    @field:SerializedName("begin_date")
    val beginDate: String,

    @field:SerializedName("begin_time")
    val beginTime: String,

    @field:SerializedName("change_user")
    val changeUser: String,

    // pagination Data
    val paginationResponse: PaginationResponse
)