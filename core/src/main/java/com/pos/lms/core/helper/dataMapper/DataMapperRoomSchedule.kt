package com.pos.lms.core.helper.dataMapper

import com.pos.lms.core.data.source.local.entity.student.RoomScheduleEntity
import com.pos.lms.core.data.source.remote.response.student.session.detailSchedule.RoomScheduleResponse
import com.pos.lms.core.domain.model.RoomSchedule

/**
 * Created by Muhammad Zaim Milzam on 08/02/21.
 * linkedin : Muhammad Zaim Milzam
 */
object DataMapperRoomSchedule {

    fun mapResponsesToEntities(input: List<RoomScheduleResponse>): List<RoomScheduleEntity> {
        val list = ArrayList<RoomScheduleEntity>()
        input.map {
            val entity = RoomScheduleEntity(
                endDate = it.endDate,
                buildingName = it.buildingName,
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
                floorName = it.floorName,
                roomName = it.roomName,
                buildingLocation = it.buildingLocation,
                childId = it.childId,
                parentId = it.parentId,
                companyName = it.companyName,
                topic = it.topic,
                dayNumber = it.dayNumber,
                childType = it.childType,
            )
            list.add(entity)
        }
        return list
    }

    fun mapEntitiesToDomain(input: List<RoomScheduleEntity>): List<RoomSchedule> =
        input.map {
            RoomSchedule(
                endDate = it.endDate,
                buildingName = it.buildingName,
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
                floorName = it.floorName,
                roomName = it.roomName,
                buildingLocation = it.buildingLocation,
                childId = it.childId,
                parentId = it.parentId,
                companyName = it.companyName,
                topic = it.topic,
                dayNumber = it.dayNumber,
                childType = it.childType,
            )
        }

}