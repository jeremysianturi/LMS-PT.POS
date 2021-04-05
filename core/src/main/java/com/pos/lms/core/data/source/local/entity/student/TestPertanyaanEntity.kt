package com.pos.lms.core.data.source.local.entity.student

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "TestPertanyaan")
data class TestPertanyaanEntity(

    @PrimaryKey(autoGenerate = true)
    @NotNull
    @ColumnInfo(name = "_id")
    val _id: Long,

    @ColumnInfo(name = "question_text")
    val questionText: String?,

    @ColumnInfo(name = "table_code")
    val tableCode: String?,

    @ColumnInfo(name = "object_identifier")
    val objectIdentifier: Int?,

    @ColumnInfo(name = "tqsid")
    val tqsid: Int?,

    @ColumnInfo(name = "company_name")
    val companyName: String?,

    @ColumnInfo(name = "question_name")
    val questionName: String?,

    @ColumnInfo(name = "question_image")
    val questionImage: String?,

    @ColumnInfo(name = "business_code")
    val businessCode: String?,

    @ColumnInfo(name = "otype")
    val otype: String?,

    @ColumnInfo(name = "relation")
    val relation: String?,

    @ColumnInfo(name = "object")
    val objects: String?
)