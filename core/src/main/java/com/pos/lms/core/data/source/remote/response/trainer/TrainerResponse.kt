package com.pos.lms.core.data.source.remote.response.trainer

import com.google.gson.annotations.SerializedName

data class TrainerResponse(

	@field:SerializedName("session_name")
	val sessionName: String,

	@field:SerializedName("CHGDT")
	val cHGDT: String,

	@field:SerializedName("PERNR")
	val pERNR: String,

	@field:SerializedName("ENDDA")
	val eNDDA: String,

	@field:SerializedName("BUSCD")
	val bUSCD: String,

	@field:SerializedName("situation_code")
	val situationCode: String,

	@field:SerializedName("schedule_name")
	val scheduleName: String,

	@field:SerializedName("day_number")
	val dayNumber: Int,

	@field:SerializedName("TRAID")
	val tRAID: Int,

	@field:SerializedName("event_stat_id")
	val eventStatId: String,

	@field:SerializedName("trainer_name")
	val trainerName: String,

	@field:SerializedName("event_status")
	val eventStatus: String,

	@field:SerializedName("situation_name")
	val situationName: String,

	@field:SerializedName("BEGDA")
	val bEGDA: String,

	@field:SerializedName("BUSC1")
	val bUSC1: String,

	@field:SerializedName("end_time")
	val endTime: String,

	@field:SerializedName("batch")
	val batch: Int,

	@field:SerializedName("session_id")
	val sessionId: Int,

	@field:SerializedName("begin_time")
	val beginTime: String,

	@field:SerializedName("batch_name")
	val batchName: String,

	@field:SerializedName("event_id")
	val eventId: Int,

	@field:SerializedName("topic")
	val topic: String,

	@field:SerializedName("event_name")
	val eventName: String,

	@field:SerializedName("TRNAM")
	val tRNAM: String,

	@field:SerializedName("STTAR")
	val sTTAR: String,

	@field:SerializedName("CHUSR")
	val cHUSR: String,

	@field:SerializedName("schedule_id")
	val scheduleId: Int
)