package com.pos.lms.core.data.source.local.entity.student

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "schedule")
data class ScheduleEntity(

    @ColumnInfo(name = "end_date")
    val endDate: String,

    @PrimaryKey
    @NotNull
    @ColumnInfo(name = "object_identifier")
    val objectIdentifier: Int,

    @ColumnInfo(name = "change_date")
    val changeDate: String,

    @ColumnInfo(name = "begin_date")
    val beginDate: String,

    @ColumnInfo(name = "end_time")
    val endTime: String,

    @ColumnInfo(name = "begin_time")
    val beginTime: String,

    @ColumnInfo(name = "change_user")
    val changeUser: String,

    @ColumnInfo(name = "day_number")
    val dayNumber: Int,

    @ColumnInfo(name = "topic")
    val topic: String,

    @ColumnInfo(name = "schedule_date")
    val scheduleDate: String,

    @ColumnInfo(name = "schedule_id")
    val scheduleId: Int,

    @ColumnInfo(name = "schedule_name")
    val scheduleName: String
)