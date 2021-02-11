package com.pos.lms.core.data.source.local.entity.dropdown

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "Competency")
data class CompetencyEntity(

    @ColumnInfo(name = "end_date")
    val endDate: String,

    @PrimaryKey
    @NotNull
    @ColumnInfo(name = "object_identifier")
    val objectIdentifier: Int,

    @ColumnInfo(name = "object_type")
    val objectType: String,

    @ColumnInfo(name = "change_date")
    val changeDate: String,

    @ColumnInfo(name = "short_text")
    val shortText: String,

    @ColumnInfo(name = "begin_date")
    val beginDate: String,

    @ColumnInfo(name = "business_code")
    val businessCode: String,

    @ColumnInfo(name = "long_text")
    val longText: String,

    @ColumnInfo(name = "plan_version")
    val planVersion: String,

    @ColumnInfo(name = "object_description")
    val objectDescription: String,

    @ColumnInfo(name = "change_user")
    val changeUser: String,

    @ColumnInfo(name = "id")
    val id: String,

    @ColumnInfo(name = "value")
    val value: String
)
