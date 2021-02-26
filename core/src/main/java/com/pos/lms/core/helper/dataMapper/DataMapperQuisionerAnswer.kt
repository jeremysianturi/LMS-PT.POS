package com.pos.lms.core.helper.dataMapper

import com.pos.lms.core.data.source.local.entity.student.QuisionerAnswerEntity
import com.pos.lms.core.data.source.remote.response.student.session.detailSchedule.QuisionerAnswerResponse
import com.pos.lms.core.domain.model.QuisionerAnswer

/**
 * Created by Muhammad Zaim Milzam on 08/02/21.
 * linkedin : Muhammad Zaim Milzam
 */
object DataMapperQuisionerAnswer {

    fun mapResponsesToEntities(input: List<QuisionerAnswerResponse>): List<QuisionerAnswerEntity> {
        val list = ArrayList<QuisionerAnswerEntity>()
        input.map {
            val entity = QuisionerAnswerEntity(
                endDate = it.endDate,
                objectIdentifier = it.objectIdentifier,
                changeDate = it.changeDate,
                changeUser = it.changeUser,
                beginDate = it.beginDate,
                textChoice = it.textChoice,
                sequenceNo = it.sequenceNo,
            )
            list.add(entity)
        }
        return list
    }

    fun mapEntitiesToDomain(input: List<QuisionerAnswerEntity>): List<QuisionerAnswer> =
        input.map {
            QuisionerAnswer(
                endDate = it.endDate,
                objectIdentifier = it.objectIdentifier,
                changeDate = it.changeDate,
                changeUser = it.changeUser,
                beginDate = it.beginDate,
                textChoice = it.textChoice,
                sequenceNo = it.sequenceNo,
                isChecked = it.isChecked
            )
        }

    fun mapDomainToEntity(input: QuisionerAnswer) = QuisionerAnswerEntity(
        endDate = input.endDate,
        objectIdentifier = input.objectIdentifier,
        changeDate = input.changeDate,
        changeUser = input.changeUser,
        beginDate = input.beginDate,
        textChoice = input.textChoice,
        sequenceNo = input.sequenceNo,
        isChecked = input.isChecked

    )

}