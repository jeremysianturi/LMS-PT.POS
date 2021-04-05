package com.pos.lms.core.data.source.local.entity.student

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "TestJawaban")
data class TestJawabanEntity(

    @ColumnInfo(name ="end_date")
    val endDate: String? = "",

    @ColumnInfo(name ="score")
    val score: Int? = 0,

    @ColumnInfo(name ="flag_true")
    val flagTrue: Boolean? = false,

    @PrimaryKey
    @NotNull
    @ColumnInfo(name ="object_identifier")
    val objectIdentifier: Int? = 0,

    @ColumnInfo(name ="question")
    val question: Int? = 0,

    @ColumnInfo(name ="change_date")
    val changeDate: String? = "",

    @ColumnInfo(name ="begin_date")
    val beginDate: String? = "",

    @ColumnInfo(name ="text_choice")
    val textChoice: String? = "",

    @ColumnInfo(name ="change_user")
    val changeUser: String? = "",

    @ColumnInfo(name ="business_code")
    val businessCode: String? = "",

    @ColumnInfo(name ="sequence_no")
    val sequenceNo: Int? = 0,

    @ColumnInfo(name = "isChecked")
    var isChecked: Boolean? = false
)