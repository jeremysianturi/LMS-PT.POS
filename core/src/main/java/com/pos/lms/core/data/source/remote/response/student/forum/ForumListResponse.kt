package com.pos.lms.core.data.source.remote.response.student.forum

import com.google.gson.annotations.SerializedName

data class ForumListResponse(

    @field:SerializedName("begin_date")
    val beginDate: String,

    @field:SerializedName("end_date")
    val endDate: String,

    @field:SerializedName("change_date")
    val changeDate: String,

    @field:SerializedName("change_user")
    val changeUser: String,

    @field:SerializedName("forum_id")
    val forumId: String,

    @field:SerializedName("forum_image")
    val forumImage: String,

    @field:SerializedName("forum_text")
    val forumText: String,

    @field:SerializedName("forum_time")
    val forumTime: String,

   @field:SerializedName("forum_title")
    val forumTitle: String,

    @field:SerializedName("object_identifier")
    val objectIdentifier: String,

    @field:SerializedName("owner")
    val owner: String,

    )