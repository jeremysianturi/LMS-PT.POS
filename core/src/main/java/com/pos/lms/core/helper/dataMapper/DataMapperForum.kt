package com.pos.lms.core.helper.dataMapper

import com.pos.lms.core.data.source.local.entity.student.ForumListEntity
import com.pos.lms.core.data.source.remote.response.student.forum.ForumResponse
import com.pos.lms.core.domain.model.ForumList

/**
 * Created by Muhammad Zaim Milzam on 08/02/21.
 * linkedin : Muhammad Zaim Milzam
 */
object DataMapperForum {

    fun mapResponsetoEntities(input: List<ForumResponse>): List<ForumListEntity> {
        val curiculumList = ArrayList<ForumListEntity>()
        input.map {
            val curiculum = ForumListEntity(
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
            curiculumList.add(curiculum)
        }

        return curiculumList
    }

    fun mapEntitiestoDomain(input: List<ForumListEntity>): List<ForumList> =
        input.map {
            ForumList(
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