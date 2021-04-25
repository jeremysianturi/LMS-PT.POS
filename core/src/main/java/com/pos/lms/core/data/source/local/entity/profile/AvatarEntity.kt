package com.pos.lms.core.data.source.local.entity.profile

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "avatar")
data class AvatarEntity(

    @NotNull
    @PrimaryKey
    @ColumnInfo(name = "object_identifier")
    val objectIdentifier: Int?,

    @ColumnInfo(name = "change_date")
    val changeDate: String?,

    @ColumnInfo(name = "change_user")
    val changeUser: String?,

    @ColumnInfo(name = "business_code")
    val businessCode: String?,

    @ColumnInfo(name = "avatar")
    val avatar: String?,

    @ColumnInfo(name = "username")
    val username: String?
)