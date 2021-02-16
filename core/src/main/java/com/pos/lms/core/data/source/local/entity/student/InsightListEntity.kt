package com.pos.lms.core.data.source.local.entity.student

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "InsightList")
data class InsightListEntity(

    @ColumnInfo(name = "begin_date")
    val beginDate: String,

    @ColumnInfo(name = "end_date")
    val endDate: String,

    @ColumnInfo(name = "change_date")
    val changeDate: String,

    @ColumnInfo(name = "change_user")
    val changeUser: String,

    @ColumnInfo(name = "forum_id")
    val forumId: String,

    @ColumnInfo(name = "forum_image")
    val forumImage: String,

    @ColumnInfo(name = "forum_text")
    val forumText: String,

    @ColumnInfo(name = "forum_time")
    val forumTime: String,

    @ColumnInfo(name = "forum_title")
    val forumTitle: String,

    @PrimaryKey
    @NotNull
    @ColumnInfo(name = "object_identifier")
    val objectIdentifier: String,

    @ColumnInfo(name = "owner")
    val owner: String,

    )