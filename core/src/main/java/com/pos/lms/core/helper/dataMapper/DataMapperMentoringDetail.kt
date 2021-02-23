package com.pos.lms.core.helper.dataMapper

import com.pos.lms.core.data.source.local.entity.student.MentoringDetailEntity
import com.pos.lms.core.data.source.remote.response.student.session.mentoring.MentoringDetailResponse
import com.pos.lms.core.domain.model.MentoringDetail

/**
 * Created by Muhammad Zaim Milzam on 08/02/21.
 * linkedin : Muhammad Zaim Milzam
 */
object DataMapperMentoringDetail {

    fun mapResponsesToEntities(input: List<MentoringDetailResponse>): List<MentoringDetailEntity> {
        val list = ArrayList<MentoringDetailEntity>()
        input.map {
            val entity = MentoringDetailEntity(
                endDate = it.endDate,
                mentoringTitle = it.mentoringTitle,
                objectIdentifier = it.objectIdentifier,
                mentoringDuration = it.mentoringDuration,
                mentoringReference = it.mentoringReference,
                beginDate = it.beginDate,
                businessCode = it.businessCode,
                changedDate = it.changedDate,
                changedUser = it.changedUser,
                mentoringTopic = it.mentoringTopic,
                mentoringSession = it.mentoringSession,
                mentorId = it.mentorId,
                mentoringDescription = it.mentoringDescription,
                companyName = it.companyName,
                mentorTypeName = it.mentorTypeName,
                mentoringId = it.mentoringId,
                mentorTypeId = it.mentorTypeId,
                mentorName = it.mentorName
            )
            list.add(entity)
        }
        return list
    }

    fun mapEntitiesToDomain(input: List<MentoringDetailEntity>): List<MentoringDetail> =
        input.map {
            MentoringDetail(
                endDate = it.endDate,
                mentoringTitle = it.mentoringTitle,
                objectIdentifier = it.objectIdentifier,
                mentoringDuration = it.mentoringDuration,
                mentoringReference = it.mentoringReference,
                beginDate = it.beginDate,
                businessCode = it.businessCode,
                changedDate = it.changedDate,
                changedUser = it.changedUser,
                mentoringTopic = it.mentoringTopic,
                mentoringSession = it.mentoringSession,
                mentorId = it.mentorId,
                mentoringDescription = it.mentoringDescription,
                companyName = it.companyName,
                mentorTypeName = it.mentorTypeName,
                mentoringId = it.mentoringId,
                mentorTypeId = it.mentorTypeId,
                mentorName = it.mentorName
            )
        }

}