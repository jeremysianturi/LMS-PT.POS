package com.pos.lms.core.data.source.local.entity.student

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "Pagination")
data class PaginationEntity(

    @ColumnInfo(name = "per_page")
    val perPage: Int,

    @PrimaryKey
    @NotNull
    @ColumnInfo(name = "total")
    val total: Int,

    @ColumnInfo(name = "count")
    val count: Int,

    @ColumnInfo(name = "total_pages")
    val totalPages: Int,

    @ColumnInfo(name = "current_page")
    val currentPage: Int
)