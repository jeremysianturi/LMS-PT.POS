package com.pos.lms.core.data.source.local.entity.student

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "absensi")
data class AbsensiEntity(

    @PrimaryKey
    @NotNull
    @ColumnInfo(name = "data")
    val data: String
)