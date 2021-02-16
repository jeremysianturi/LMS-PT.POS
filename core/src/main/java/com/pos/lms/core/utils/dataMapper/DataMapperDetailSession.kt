package com.pos.lms.core.utils.dataMapper

import com.pos.lms.core.data.source.local.entity.student.DetailSessionEntity
import com.pos.lms.core.data.source.remote.response.student.session.DetailSessionResponse
import com.pos.lms.core.domain.model.DetailSession

/**
 * Created by Muhammad Zaim Milzam on 10/02/21.
 * linkedin : Muhammad Zaim Milzam
 */
object DataMapperDetailSession {

    fun mapResponsetoEntities(input: List<DetailSessionResponse>): List<DetailSessionEntity> {
        val materiList = ArrayList<DetailSessionEntity>()
        input.map {
            val entity = DetailSessionEntity(
                endDate = it.endDate,
                sessionName = it.sessionName,
                activityName = it.activityName,
                curriculumName = it.curriculumName,
                objectIdentifier = it.objectIdentifier,
                batchId = it.batchId,
                beginDate = it.beginDate,
                eventDescription = it.eventDescription,
                businessCode = it.businessCode,
                changedDate = it.changedDate,
                locationId = it.locationId,
                reference = it.reference,
                eventType = it.eventType,
                activityId = it.activityId,
                batchTypeName = it.batchTypeName,
                businessName = it.businessName,
                sessionId = it.sessionId,
                curriculumId = it.curriculumId,
                vendorName = it.vendorName,
                changedUser = it.changedUser,
                batchName = it.batchName,
                locationName = it.locationName,
                eventId = it.eventId,
                vendorId = it.vendorId,
                batchTypeId = it.batchTypeId,
                eventName = it.eventName,
            )
            materiList.add(entity)
        }

        return materiList
    }

    fun mapEntitiestoDomain(input: List<DetailSessionEntity>): List<DetailSession> =
        input.map {
            DetailSession(
                endDate = it.endDate,
                sessionName = it.sessionName,
                activityName = it.activityName,
                curriculumName = it.curriculumName,
                objectIdentifier = it.objectIdentifier,
                batchId = it.batchId,
                beginDate = it.beginDate,
                eventDescription = it.eventDescription,
                businessCode = it.businessCode,
                changedDate = it.changedDate,
                locationId = it.locationId,
                reference = it.reference,
                eventType = it.eventType,
                activityId = it.activityId,
                batchTypeName = it.batchTypeName,
                businessName = it.businessName,
                sessionId = it.sessionId,
                curriculumId = it.curriculumId,
                vendorName = it.vendorName,
                changedUser = it.changedUser,
                batchName = it.batchName,
                locationName = it.locationName,
                eventId = it.eventId,
                vendorId = it.vendorId,
                batchTypeId = it.batchTypeId,
                eventName = it.eventName,
            )
        }

}