package com.pos.lms.core.data.source.local.entity.student

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "mentoringChat")
data class MentoringChatEntity(

	@ColumnInfo(name ="chat_type")
	val chatType: String,

	@PrimaryKey
	@NotNull
	@ColumnInfo(name ="object_identifier")
	val objectIdentifier: String,

	@ColumnInfo(name ="chat_text")
	val chatText: String,

	@ColumnInfo(name ="sender_type")
	val senderType: String,

	@ColumnInfo(name ="begin_date")
	val beginDate: String,

	@ColumnInfo(name ="business_code")
	val businessCode: String,

	@ColumnInfo(name ="sender_name")
	val senderName: String,

	@ColumnInfo(name ="mentoring_id")
	val mentoringId: String,

	@ColumnInfo(name ="sender_id")
	val senderId: String
)