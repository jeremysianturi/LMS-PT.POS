package com.pos.lms.core.utils.dataMapper

import com.pos.lms.core.data.source.local.entity.student.SessionListEntity
import com.pos.lms.core.data.source.remote.response.student.session.SessionListResponse
import com.pos.lms.core.domain.model.SessionList

/**
 * Created by Muhammad Zaim Milzam on 08/02/21.
 * linkedin : Muhammad Zaim Milzam
 */
object DataMapperSessionList {

    fun mapResponsetoEntities(input: List<SessionListResponse>): List<SessionListEntity> {
        val curiculumList = ArrayList<SessionListEntity>()
        input.map {
            val curiculum = SessionListEntity(
                beginDate = it.beginDate,
                endDate = it.endDate,
                sessionName = it.sessionName,
                activityName = it.activityName,
                objectIdentifier = it.objectIdentifier,
                cycleId = it.cycleId,
                batchId = it.batchId,
                sessionId = it.sessionId,
                changedDate = it.changedDate,
                changedUser = it.changedUser,
                activityTypeId = it.activityTypeId,
                activityTypeName = it.activityTypeName,
                activityId = it.activityId,
                cycleName = it.cycleName,
            )
            curiculumList.add(curiculum)
        }

        return curiculumList
    }

    fun mapEntitiestoDomain(input: List<SessionListEntity>): List<SessionList> =
        input.map {
            SessionList(
                beginDate = it.beginDate,
                endDate = it.endDate,
                sessionName = it.sessionName,
                activityName = it.activityName,
                objectIdentifier = it.objectIdentifier,
                cycleId = it.cycleId,
                batchId = it.batchId,
                sessionId = it.sessionId,
                changedDate = it.changedDate,
                changedUser = it.changedUser,
                activityTypeId = it.activityTypeId,
                activityTypeName = it.activityTypeName,
                activityId = it.activityId,
                cycleName = it.cycleName,
            )
        }
}