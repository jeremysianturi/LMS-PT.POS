package com.pos.lms.core.helper.dataMapper

import com.pos.lms.core.data.source.local.entity.student.InsightListEntity
import com.pos.lms.core.data.source.remote.response.student.insight.InsightListResponse
import com.pos.lms.core.domain.model.InsightList

object DataMapperInsightList {

    fun mapResponsetoEntities(input: List<InsightListResponse>): List<InsightListEntity> {
        val curiculumList = ArrayList<InsightListEntity>()
        input.map {
            val entity = InsightListEntity(
                beginDate = it.beginDate,
                endDate = it.endDate,
                changeDate = it.changeDate,
                changeUser = it.changeUser,
                forumId = it.forumId,
                forumImage = it.forumImage,
                forumText = it.forumText,
                forumTime = it.forumTime,
                forumTitle = it.forumTitle,
                objectIdentifier = it.objectIdentifier,
                owner = it.forumOwner,
                batchName = it.batchName,
                batchId = it.batchId
            )
            curiculumList.add(entity)
        }

        return curiculumList
    }

    fun mapEntitiestoDomain(input: List<InsightListEntity>): List<InsightList> =
        input.map {
            InsightList(
                beginDate = it.beginDate,
                endDate = it.endDate,
                changeDate = it.changeDate,
                changeUser = it.changeUser,
                forumId = it.forumId,
                forumImage = it.forumImage,
                forumText = it.forumText,
                forumTime = it.forumTime,
                forumTitle = it.forumTitle,
                objectIdentifier = it.objectIdentifier,
                owner = it.owner,
                batchName = it.batchName,
                batchId = it.batchId
            )
        }
}