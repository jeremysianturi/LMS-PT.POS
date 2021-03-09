package com.pos.lms.core.data.source.remote.response.student.insight

import com.google.gson.annotations.SerializedName

data class InsightListResponse(

    @field:SerializedName("end_date")
    val endDate: String,

    @field:SerializedName("curriculum_name")
    val curriculumName: String,

    @field:SerializedName("object_identifier")
    val objectIdentifier: String,

    @field:SerializedName("forum_owner")
    val forumOwner: String,

    @field:SerializedName("batch_id")
    val batchId: String,

    @field:SerializedName("forum_image")
    val forumImage: String,

    @field:SerializedName("change_date")
    val changeDate: String,

    @field:SerializedName("begin_date")
    val beginDate: String,

    @field:SerializedName("event_description")
    val eventDescription: String,

    @field:SerializedName("business_code")
    val businessCode: String,

    @field:SerializedName("location_id")
    val locationId: String,

    @field:SerializedName("forum_id")
    val forumId: String,

    @field:SerializedName("event_type")
    val eventType: String,

    @field:SerializedName("forum_text")
    val forumText: String,

    @field:SerializedName("change_user")
    val changeUser: String,

    @field:SerializedName("batch_type_name")
    val batchTypeName: String,

    @field:SerializedName("forum_type_id")
    val forumTypeId: String,

    @field:SerializedName("forum_type_name")
    val forumTypeName: String,

    @field:SerializedName("curriculum_id")
    val curriculumId: String,

    @field:SerializedName("vendor_name")
    val vendorName: String,

    @field:SerializedName("forum_title")
    val forumTitle: String,

    @field:SerializedName("batch_name")
    val batchName: String,

    @field:SerializedName("location_name")
    val locationName: String,

    @field:SerializedName("event_id")
    val eventId: String,

    @field:SerializedName("forum_time")
    val forumTime: String,

    @field:SerializedName("vendor_id")
    val vendorId: String,

    @field:SerializedName("batch_type_id")
    val batchTypeId: String,

    @field:SerializedName("event_name")
    val eventName: String

)