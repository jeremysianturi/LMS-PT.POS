package com.pos.lms.core.helper.dataMapper

import com.pos.lms.core.data.source.local.entity.student.ForumCommentEntity
import com.pos.lms.core.data.source.remote.response.student.forum.ForumCommentResponse
import com.pos.lms.core.domain.model.ForumComment

object DataMapperForumComment {

    fun mapResponsetoEntities(input: List<ForumCommentResponse>): List<ForumCommentEntity> {
        val curiculumList = ArrayList<ForumCommentEntity>()
        input.map {
            val curiculum = ForumCommentEntity(
                beginDate = it.beginDate,
                changeDate = it.changeDate,
                changeUser = it.changeUser,
                beginTime = it.beginTime,
                objectIdentifier = it.objectIdentifier,
                owner = it.owner,
                comment = it.comment,


            )
            curiculumList.add(curiculum)
        }

        return curiculumList
    }

    fun mapEntitiestoDomain(input: List<ForumCommentEntity>): List<ForumComment> =
        input.map {
            ForumComment(
                beginDate = it.beginDate,
                changeDate = it.changeDate,
                changeUser = it.changeUser,
                beginTime = it.beginTime,
                objectIdentifier = it.objectIdentifier,
                owner = it.owner,
                comment = it.comment,
            )
        }
}