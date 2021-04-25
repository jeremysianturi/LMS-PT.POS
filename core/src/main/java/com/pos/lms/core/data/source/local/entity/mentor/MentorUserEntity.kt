package com.pos.lms.core.data.source.local.entity.mentor

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "mentorUser")
data class MentorUserEntity(

    @ColumnInfo(name = "end_date")
    val endDate: String? = null,

    @ColumnInfo(name = "mentoring_title")
    val mentoringTitle: String? = null,

    @NotNull
    @PrimaryKey
    @ColumnInfo(name = "object_identifier")
    val objectIdentifier: Int? = null,

    @ColumnInfo(name = "mentoring_duration")
    val mentoringDuration: Int? = null,

    @ColumnInfo(name = "mentoring_change_user")
    val mentoringChangeUser: String? = null,

    @ColumnInfo(name = "change_date")
    val changeDate: String? = null,

    @ColumnInfo(name = "begin_date")
    val beginDate: String? = null,

    @ColumnInfo(name = "business_code")
    val businessCode: String? = null,

    @ColumnInfo(name = "mentoring")
    val mentoring: Int? = null,

    @ColumnInfo(name = "personnel_number")
    val personnelNumber: String? = null,

    @ColumnInfo(name = "mentoring_change_date")
    val mentoringChangeDate: String? = null,

    @ColumnInfo(name = "mentoring_topic")
    val mentoringTopic: String? = null,

    @ColumnInfo(name = "mentoring_session")
    val mentoringSession: Int? = null,

    @ColumnInfo(name = "mentoring_mentoring_id")
    val mentoringMentoringId: Int? = null,

    @ColumnInfo(name = "mentoring_business_code")
    val mentoringBusinessCode: String? = null,

    @ColumnInfo(name = "mentor_id")
    val mentorId: Int? = null,

    @ColumnInfo(name = "mentoring_end_date")
    val mentoringEndDate: String? = null,

    @ColumnInfo(name = "mentoring_description")
    val mentoringDescription: String? = null,

    @ColumnInfo(name = "mentoring_reference_mentoring")
    val mentoringReferenceMentoring: Int? = null,

    @ColumnInfo(name = "change_user")
    val changeUser: String? = null,

    @ColumnInfo(name = "otype")
    val otype: String? = null,

    @ColumnInfo(name = "id")
    val id: Int? = null,

    @ColumnInfo(name = "mentor_name")
    val mentorName: String? = null,

    @ColumnInfo(name = "mentoring_begin_date")
    val mentoringBeginDate: String? = null
)