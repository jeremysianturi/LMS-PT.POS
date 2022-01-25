package com.pos.lms.core.helper.dataMapper

import com.pos.lms.core.data.source.local.entity.student.QuisionerScheduleEntity
import com.pos.lms.core.data.source.remote.response.student.session.detailSchedule.QuisionerScheduleResponse
import com.pos.lms.core.domain.model.QuisionerSchedule

object DataMapperQuisionerSchedule {

    fun mapResponsesToEntities(input: List<QuisionerScheduleResponse>): List<QuisionerScheduleEntity> {
        val list = ArrayList<QuisionerScheduleEntity>()
        input.map {
            val entity = QuisionerScheduleEntity(
                endDate = it.endDate,
                templateCodeName = it.templateCodeName,
                objectIdentifier = it.objectIdentifier,
                relationTypeId = it.relationTypeId,
                beginDate = it.beginDate,
                endTime = it.endTime,
                sessionId = it.sessionId,
                beginTime = it.beginTime,
                businessCode = it.businessCode,
                changedDate = it.changedDate,
                scheduleDate = it.scheduleDate,
                scheduleName = it.scheduleName,
                changedUser = it.changedUser,
                relationTypeName= it.relationTypeName,
                relationQuesionerId = it.relationQuesionerId,
                reference = it.reference,
                templateCodeId = it.templateCodeId,
                companyName = it.companyName,
                templateTypeName = it.templateTypeName,
                templateTypeId = it.templateTypeId,
                topic = it.topic,
                dayNumber = it.dayNumber,
                id = it.id,
                scheduleId = it.scheduleId,
            )
            list.add(entity)
        }
        return list
    }

    fun mapEntitiesToDomain(input: List<QuisionerScheduleEntity>): List<QuisionerSchedule> =
        input.map {
            QuisionerSchedule(
                endDate = it.endDate,
                templateCodeName = it.templateCodeName,
                objectIdentifier = it.objectIdentifier,
                relationTypeId = it.relationTypeId,
                beginDate = it.beginDate,
                endTime = it.endTime,
                sessionId = it.sessionId,
                beginTime = it.beginTime,
                businessCode = it.businessCode,
                changedDate = it.changedDate,
                scheduleDate = it.scheduleDate,
                scheduleName = it.scheduleName,
                changedUser = it.changedUser,
                relationTypeName= it.relationTypeName,
                relationQuesionerId = it.relationQuesionerId,
                reference = it.reference,
                templateCodeId = it.templateCodeId,
                companyName = it.companyName,
                templateTypeName = it.templateTypeName,
                templateTypeId = it.templateTypeId,
                topic = it.topic,
                dayNumber = it.dayNumber,
                id = it.id,
                scheduleId = it.scheduleId,
            )
        }

}