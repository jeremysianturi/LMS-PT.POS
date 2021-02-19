package com.pos.lms.core.utils.dataMapper

import com.pos.lms.core.data.source.local.entity.student.MateriScheduleEntity
import com.pos.lms.core.data.source.remote.response.student.session.detailSchedule.MateriScheduleResponse
import com.pos.lms.core.domain.model.MateriSchedule

/**
 * Created by Muhammad Zaim Milzam on 08/02/21.
 * linkedin : Muhammad Zaim Milzam
 */
object DataMapperMateriSchedule {

    fun mapResponsesToEntities(input: List<MateriScheduleResponse>): List<MateriScheduleEntity> {
        val list = ArrayList<MateriScheduleEntity>()
        input.map {
            val entity = MateriScheduleEntity(
                endDate = it.endDate,
                materiName = it.materiName,
                sellingPrice = it.sellingPrice,
                objectIdentifier = it.objectIdentifier,
                beginDate = it.beginDate,
                description = it.description,
                businessCode = it.businessCode,
                changedDate = it.changedDate,
                scheduleName = it.scheduleName,
                relation = it.relation,
                reference = it.reference,
                methodName = it.methodName,
                fileType = it.fileType,
                dayNumber = it.dayNumber,
                plCodeId = it.plCodeId,
                competenceName = it.competenceName,
                plCodeName = it.plCodeName,
                address = it.address    ,
                materiTypeName = it.materiTypeName,
                endTime = it.endTime,
                sessionId = it.sessionId,
                beginTime = it.beginTime,
                parentType = it.parentType,
                scheduleDate = it.scheduleDate,
                changedUser = it.changedUser,
                childId = it.childId,
                parentId = it.parentId,
                methodId = it.methodId,
                companyName = it.companyName,
                materiTypeId = it.materiTypeId,
                purchasePrice = it.purchasePrice,
                topic = it.topic,
                competenceId = it.competenceId,
                childType = it.childType,
            )
            list.add(entity)
        }
        return list
    }

    fun mapEntitiesToDomain(input: List<MateriScheduleEntity>): List<MateriSchedule> =
        input.map {
            MateriSchedule(
                endDate = it.endDate,
                materiName = it.materiName,
                sellingPrice = it.sellingPrice,
                objectIdentifier = it.objectIdentifier,
                beginDate = it.beginDate,
                description = it.description,
                businessCode = it.businessCode,
                changedDate = it.changedDate,
                scheduleName = it.scheduleName,
                relation = it.relation,
                reference = it.reference,
                methodName = it.methodName,
                fileType = it.fileType,
                dayNumber = it.dayNumber,
                plCodeId = it.plCodeId,
                competenceName = it.competenceName,
                plCodeName = it.plCodeName,
                address = it.address    ,
                materiTypeName = it.materiTypeName,
                endTime = it.endTime,
                sessionId = it.sessionId,
                beginTime = it.beginTime,
                parentType = it.parentType,
                scheduleDate = it.scheduleDate,
                changedUser = it.changedUser,
                childId = it.childId,
                parentId = it.parentId,
                methodId = it.methodId,
                companyName = it.companyName,
                materiTypeId = it.materiTypeId,
                purchasePrice = it.purchasePrice,
                topic = it.topic,
                competenceId = it.competenceId,
                childType = it.childType,
            )
        }

}