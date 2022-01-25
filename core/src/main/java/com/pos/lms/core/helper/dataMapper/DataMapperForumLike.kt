package com.pos.lms.core.helper.dataMapper

import com.pos.lms.core.data.source.local.entity.student.ForumLikeEntity
import com.pos.lms.core.data.source.remote.response.student.forum.ForumLikeResponse
import com.pos.lms.core.domain.model.ForumLike


object DataMapperForumLike {

    fun mapResponsetoEntities(input: List<ForumLikeResponse>): List<ForumLikeEntity> {
        val dataList = ArrayList<ForumLikeEntity>()
        input.map {
            val data = ForumLikeEntity(
                beginDate = it.beginDate,
                like = it.like,
                changeDate = it.changeDate,
                changeUser = it.changeUser,
                beginTime = it.beginTime,
                objectIdentifier = it.objectIdentifier,
                owner = it.owner,

                )
            dataList.add(data)
        }

        return dataList
    }

    fun mapEntitiestoDomain(input: List<ForumLikeEntity>): List<ForumLike> =
        input.map {
            ForumLike(
                beginDate = it.beginDate,
                like = it.like,
                changeDate = it.changeDate,
                changeUser = it.changeUser,
                beginTime = it.beginTime,
                objectIdentifier = it.objectIdentifier,
                owner = it.owner,
            )
        }
}