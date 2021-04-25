package com.pos.lms.core.data.source.local.entity.account

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "Account")
data class AccountEntity(

    @ColumnInfo(name = "end_date")
    val endDate: String? = null,

    @ColumnInfo(name = "business_name")
    val businessName: String? = null,

    @NotNull
    @PrimaryKey
    @ColumnInfo(name = "object_identifier")
    val objectIdentifier: Int? = null,

//    @ColumnInfo(name = "role")
//    @TypeConverters(Converter::class)
//    val role: List<String?>? = null,

    @ColumnInfo(name = "business_address")
    val businessAddress: String? = null,

    @ColumnInfo(name = "change_date")
    val changeDate: String? = null,

    @ColumnInfo(name = "begin_date")
    val beginDate: String? = null,

    @ColumnInfo(name = "change_user")
    val changeUser: String? = null,

    @ColumnInfo(name = "company")
    val company: String? = null,

    @ColumnInfo(name = "email")
    val email: String? = null,

    @ColumnInfo(name = "company_address")
    val companyAddress: String? = null,

    @ColumnInfo(name = "username")
    val username: String? = null
)