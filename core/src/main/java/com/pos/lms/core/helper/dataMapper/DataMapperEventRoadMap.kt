package com.pos.lms.core.helper.dataMapper

import com.pos.lms.core.data.source.local.entity.roadmap.EventRoadmapEntity
import com.pos.lms.core.data.source.remote.response.roadmap.EventRoadmapResponse
import com.pos.lms.core.domain.model.EventRoadmap

/**
 * Created by Muhammad Zaim Milzam on 06/02/21.
 * linkedin : Muhammad Zaim Milzam
 */
object DataMapperEventRoadMap {
    fun mapResponsesToEntities(input: List<EventRoadmapResponse>): List<EventRoadmapEntity> {
        val list = ArrayList<EventRoadmapEntity>()
        input.map {
            val entity = EventRoadmapEntity(
                endDate = it.endDate,
                objectIdentifier = it.objectIdentifier,
                questionGroup = it.questionGroup,
                changeDate = it.changeDate,
                beginDate = it.beginDate,
                description = it.description,
                businessCode = it.businessCode,
                eventEmployeeDateline = it.eventEmployeeDateline.toString(),
                eventType = it.eventType,
                eventTalentUnitDateline = it.eventTalentUnitDateline.toString(),
                eventCode = it.eventCode,
                startHour = it.startHour,
                quota = it.quota.toString(),
                eventName = it.eventName,
                changeUser = it.changeUser,
                endHour = it.endHour,
                eventStatus = it.eventStatus,
            )
            list.add(entity)
        }
        return list
    }

    fun mapEntitiesToDomain(input: List<EventRoadmapEntity>): List<EventRoadmap> =
        input.map {
            EventRoadmap(
                endDate = it.endDate,
                objectIdentifier = it.objectIdentifier,
                questionGroup = it.questionGroup,
                changeDate = it.changeDate,
                beginDate = it.beginDate,
                description = it.description,
                businessCode = it.businessCode,
                eventEmployeeDateline = it.eventEmployeeDateline,
                eventType = it.eventType,
                eventTalentUnitDateline = it.eventTalentUnitDateline,
                eventCode = it.eventCode,
                startHour = it.startHour,
                quota = it.quota,
                eventName = it.eventName,
                changeUser = it.changeUser,
                endHour = it.endHour,
                eventStatus = it.eventStatus,
            )
        }
}