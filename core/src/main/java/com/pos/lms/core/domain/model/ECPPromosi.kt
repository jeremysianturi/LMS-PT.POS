package com.pos.lms.core.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

data class ECPPromosi(
	val payrollArea: String,
	val objectIdentifier: Int,
	val wilayahCode: String,
	val positionCode: String,
	val applicants: String,
	val positionName: String,
	val businessArea: String,
	val wilayahName: String,
	val personnelNumber: String,
	val levelJabatan: String,
	val kantorCode: String,
	val kantorName: String,
	val jobFamilyName: String,
	val score: String,
	val jobName: String,
	val eventCode: String,
	val aspiration: String,
	val levelJabatanOrder: String,
	val ranking: String,
	val jobCode: String,
	val aspirationType: String,
	val tipeJabatan: String,
	val commiteeCode: String,
	val jobFamilyId: String
)