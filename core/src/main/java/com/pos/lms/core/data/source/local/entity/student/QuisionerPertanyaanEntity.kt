package com.pos.lms.core.data.source.local.entity.student

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "quisionerPertanyaan")
data class QuisionerPertanyaanEntity(

    @PrimaryKey(autoGenerate = true)
    @NotNull
    @ColumnInfo(name = "_id")
    val _id: Long,

    @ColumnInfo(name = "end_date")
    val endDate: String,

    @ColumnInfo(name = "object_identifier")
    val objectIdentifier: String,

    @ColumnInfo(name = "quesioner_purpose_name")
    val quesionerPurposeName: String,

    @ColumnInfo(name = "begin_date")
    val beginDate: String,

    @ColumnInfo(name = "quesioner_purpose_id")
    val quesionerPurposeId: String,

    @ColumnInfo(name = "business_code")
    val businessCode: String,

    @ColumnInfo(name = "changed_date")
    val changedDate: String,

    @ColumnInfo(name = "quesioner_title")
    val quesionerTitle: String,

    @ColumnInfo(name = "changed_user")
    val changedUser: String,

    @ColumnInfo(name = "quesioner_type_id")
    val quesionerTypeId: String,

    @ColumnInfo(name = "relation")
    val relation: String,

    @ColumnInfo(name = "table_code")
    val tableCode: String,

    @ColumnInfo(name = "company_name")
    val companyName: String,

    @ColumnInfo(name = "quesioner_id")
    val quesionerId: String,

    @ColumnInfo(name = "otype")
    val otype: String,

    @ColumnInfo(name = "quesioner_category_id")
    val quesionerCategoryId: String,

    @ColumnInfo(name = "questioner_type_name")
    val questionerTypeName: String,

    @ColumnInfo(name = "quesioner_category_name")
    val quesionerCategoryName: String,

    @ColumnInfo(name = "quesioner_text")
    val quesionerText: String,

    @ColumnInfo(name = "number_of_choice")
    val numberOfChoice: String,

    @ColumnInfo(name = "object")
    val objects: String
)