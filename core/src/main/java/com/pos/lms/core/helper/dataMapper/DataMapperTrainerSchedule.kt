package com.pos.lms.core.helper.dataMapper

import com.pos.lms.core.data.source.local.entity.student.TrainerScheduleEntity
import com.pos.lms.core.data.source.remote.response.student.session.detailSchedule.TrainerScheduleResponse
import com.pos.lms.core.domain.model.TrainerSchedule

object DataMapperTrainerSchedule {

    fun mapResponsesToEntities(input: List<TrainerScheduleResponse>): List<TrainerScheduleEntity> {
        val list = ArrayList<TrainerScheduleEntity>()
        input.map {
            val entity = TrainerScheduleEntity(
                endDate = it.endDate,
                objectIdentifier = it.objectIdentifier,
                beginDate = it.beginDate,
                endTime = it.endTime,
                sessionId = it.sessionId,
                beginTime = it.beginTime,
                businessCode = it.businessCode,
                changedDate = it.changedDate,
                parentType = it.parentType,
                scheduleDate = it.scheduleDate,
                scheduleName = it.scheduleName,
                changedUser = it.changedUser,
                relation = it.relation,
                reference = it.reference,
                childId = it.childId,
                parentId = it.parentId,
                companyName = it.companyName,
                topic = it.topic,
                dayNumber = it.dayNumber,
                childType = it.childType,
                trainerName = it.trainerName,
            )
            list.add(entity)
        }
        return list
    }

    fun mapEntitiesToDomain(input: List<TrainerScheduleEntity>): List<TrainerSchedule> =
        input.map {
            TrainerSchedule(
                endDate = it.endDate,
                objectIdentifier = it.objectIdentifier,
                beginDate = it.beginDate,
                endTime = it.endTime,
                sessionId = it.sessionId,
                beginTime = it.beginTime,
                businessCode = it.businessCode,
                changedDate = it.changedDate,
                parentType = it.parentType,
                scheduleDate = it.scheduleDate,
                scheduleName = it.scheduleName,
                changedUser = it.changedUser,
                relation = it.relation,
                reference = it.reference,
                childId = it.childId,
                parentId = it.parentId,
                companyName = it.companyName,
                topic = it.topic,
                dayNumber = it.dayNumber,
                childType = it.childType,
                trainerName = it.trainerName,
            )
        }

}