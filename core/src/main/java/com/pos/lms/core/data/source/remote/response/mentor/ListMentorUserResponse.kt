package com.pos.lms.core.data.source.remote.response.mentor

import com.google.gson.annotations.SerializedName

data class ListMentorUserResponse(

    @field:SerializedName("data")
    val data: List<MentorUserResponse>
)