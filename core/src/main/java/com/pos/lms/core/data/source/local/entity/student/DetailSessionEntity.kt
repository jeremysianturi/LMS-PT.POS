package com.pos.lms.core.data.source.local.entity.student

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "DetailSession")
data class DetailSessionEntity(

	@ColumnInfo(name ="end_date")
	val endDate: String,

	@ColumnInfo(name ="session_name")
	val sessionName: String,

	@ColumnInfo(name ="activity_name")
	val activityName: String,

	@ColumnInfo(name ="curriculum_name")
	val curriculumName: String,

	@PrimaryKey
	@NotNull
	@ColumnInfo(name ="object_identifier")
	val objectIdentifier: String,

	@ColumnInfo(name ="batch_id")
	val batchId: String,

	@ColumnInfo(name ="begin_date")
	val beginDate: String,

	@ColumnInfo(name ="event_description")
	val eventDescription: String,

	@ColumnInfo(name ="business_code")
	val businessCode: String,

	@ColumnInfo(name ="changed_date")
	val changedDate: String,

	@ColumnInfo(name ="location_id")
	val locationId: String,

	@ColumnInfo(name ="reference")
	val reference: String,

	@ColumnInfo(name ="event_type")
	val eventType: String,

	@ColumnInfo(name ="activity_id")
	val activityId: String,

	@ColumnInfo(name ="batch_type_name")
	val batchTypeName: String,

	@ColumnInfo(name ="business_name")
	val businessName: String,

	@ColumnInfo(name ="session_id")
	val sessionId: String,

	@ColumnInfo(name ="curriculum_id")
	val curriculumId: String,

	@ColumnInfo(name ="vendor_name")
	val vendorName: String,

	@ColumnInfo(name ="changed_user")
	val changedUser: String,

	@ColumnInfo(name ="batch_name")
	val batchName: String,

	@ColumnInfo(name ="location_name")
	val locationName: String,

	@ColumnInfo(name ="event_id")
	val eventId: String,

	@ColumnInfo(name ="vendor_id")
	val vendorId: String,

	@ColumnInfo(name ="batch_type_id")
	val batchTypeId: String,

	@ColumnInfo(name ="event_name")
	val eventName: String
)