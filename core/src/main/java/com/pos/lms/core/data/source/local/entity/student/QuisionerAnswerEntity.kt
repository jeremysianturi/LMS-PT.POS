package com.pos.lms.core.data.source.local.entity.student

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "quisionerAnswer")
data class QuisionerAnswerEntity(

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

    @ColumnInfo(name = "text_choice")
    val textChoice: String,

    @ColumnInfo(name = "change_user")
    val changeUser: String,

    @ColumnInfo(name = "sequence_no")
    val sequenceNo: Int,

    @ColumnInfo(name = "isChecked")
    var isChecked: Boolean? = false
)