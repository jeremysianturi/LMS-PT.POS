package com.pos.lms.core.data.source.local.entity.student

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "ForumComment")
data class ForumCommentEntity(

	@ColumnInfo(name ="owner")
	val owner: String,

	@PrimaryKey
	@NotNull
	@ColumnInfo(name ="object_identifier")
	val objectIdentifier: Int,

	@ColumnInfo(name ="change_date")
	val changeDate: String,

	@ColumnInfo(name ="begin_date")
	val beginDate: String,

	@ColumnInfo(name ="begin_time")
	val beginTime: String,

	@ColumnInfo(name ="change_user")
	val changeUser: String,

	@ColumnInfo(name ="comment")
	val comment: String
)