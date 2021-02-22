package com.pos.lms.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MentoringChat(
	val chatType: String,
	val objectIdentifier: String,
	val chatText: String,
	val senderType: String,
	val beginDate: String,
	val businessCode: String,
	val senderName: String,
	val mentoringId: String,
	val senderId: String
) : Parcelable