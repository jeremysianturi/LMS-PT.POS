package com.pos.lms.core.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "ParId")
data class ItemParIdEntity(
    @ColumnInfo(name = "access_token")
    val accessToken: String,

    @ColumnInfo(name = "username")
    val username: String,

    @ColumnInfo(name = "type")
    val type: String,

    @PrimaryKey
    @NotNull
    @ColumnInfo(name = "id")
    val id: Int
)
