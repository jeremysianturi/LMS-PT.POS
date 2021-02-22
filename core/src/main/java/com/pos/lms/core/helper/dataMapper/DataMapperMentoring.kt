package com.pos.lms.core.helper.dataMapper

import com.pos.lms.core.data.source.local.entity.student.MentoringEntity
import com.pos.lms.core.data.source.remote.response.student.session.mentoring.MentoringResponse
import com.pos.lms.core.domain.model.Mentoring

/**
 * Created by Muhammad Zaim Milzam on 08/02/21.
 * linkedin : Muhammad Zaim Milzam
 */
object DataMapperMentoring {

    fun mapResponsesToEntities(input: List<MentoringResponse>): List<MentoringEntity> {
        val list = ArrayList<MentoringEntity>()
        input.map {
            val entity = MentoringEntity(
                endDate = it.endDate,
                objectIdentifier = it.objectIdentifier,
                session = it.session,
                beginDate = it.beginDate,
                changeDate = it.changeDate,
                referenceMentoring = it.referenceMentoring,
                description = it.description,
                businessCode = it.businessCode,
                title = it.title,
                duration = it.duration,
                topic = it.topic,
                changeUser = it.changeUser,
                mentoringId = it.mentoringId,
            )
            list.add(entity)
        }
        return list
    }

    fun mapEntitiesToDomain(input: List<MentoringEntity>): List<Mentoring> =
        input.map {
            Mentoring(
                endDate = it.endDate,
                objectIdentifier = it.objectIdentifier,
                session = it.session,
                beginDate = it.beginDate,
                changeDate = it.changeDate,
                referenceMentoring = it.referenceMentoring,
                description = it.description,
                businessCode = it.businessCode,
                title = it.title,
                duration = it.duration,
                topic = it.topic,
                changeUser = it.changeUser,
                mentoringId = it.mentoringId,
            )
        }

}