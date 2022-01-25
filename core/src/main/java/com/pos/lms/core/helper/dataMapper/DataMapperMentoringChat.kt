package com.pos.lms.core.helper.dataMapper

import com.pos.lms.core.data.source.local.entity.student.MentoringChatEntity
import com.pos.lms.core.data.source.remote.response.student.session.mentoring.MentoringChatResponse
import com.pos.lms.core.domain.model.MentoringChat

object DataMapperMentoringChat {

    fun mapResponsesToEntities(input: List<MentoringChatResponse>): List<MentoringChatEntity> {
        val list = ArrayList<MentoringChatEntity>()
        input.map {
            val entity = MentoringChatEntity(
                chatType = it.chatType,
                objectIdentifier = it.objectIdentifier,
                chatText = it.chatText,
                senderType = it.senderType,
                beginDate = it.beginDate,
                businessCode = it.businessCode,
                senderName = it.senderName,
                mentoringId = it.mentoringId,
                senderId = it.senderId,
            )
            list.add(entity)
        }
        return list
    }

    fun mapEntitiesToDomain(input: List<MentoringChatEntity>): List<MentoringChat> =
        input.map {
            MentoringChat(
                chatType = it.chatType,
                objectIdentifier = it.objectIdentifier,
                chatText = it.chatText,
                senderType = it.senderType,
                beginDate = it.beginDate,
                businessCode = it.businessCode,
                senderName = it.senderName,
                mentoringId = it.mentoringId,
                senderId = it.senderId,
            )
        }

}