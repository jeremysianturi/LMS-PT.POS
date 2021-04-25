package com.pos.lms.core.helper.dataMapper

import com.pos.lms.core.data.source.local.entity.mentor.MentorUserEntity
import com.pos.lms.core.data.source.remote.response.mentor.MentorUserResponse
import com.pos.lms.core.domain.model.MentorUser

/**
 * Created by Muhammad Zaim Milzam on 08/02/21.
 * linkedin : Muhammad Zaim Milzam
 */
object DataMapperMentor {

    fun mapResponsetoEntities(input: List<MentorUserResponse>): List<MentorUserEntity> {
        val list = ArrayList<MentorUserEntity>()
        input.map {
            val data = MentorUserEntity(
                endDate = it.endDate,
                mentoringTitle = it.mentoringTitle,
                objectIdentifier = it.objectIdentifier,
                mentoringDuration = it.mentoringDuration,
                mentoringChangeUser = it.mentoringChangeUser,
                changeDate = it.changeDate,
                beginDate = it.beginDate,
                businessCode = it.businessCode,
                mentoring = it.mentoring,
                personnelNumber = it.personnelNumber,
                mentoringChangeDate = it.mentoringChangeDate,
                mentoringTopic = it.mentoringTopic,
                mentoringSession = it.mentoringSession,
                mentoringMentoringId = it.mentoringMentoringId,
                mentoringBusinessCode = it.mentoringBusinessCode,
                mentorId = it.mentorId,
                mentoringEndDate = it.mentoringEndDate,
                mentoringDescription = it.mentoringDescription,
                mentoringReferenceMentoring = it.mentoringReferenceMentoring,
                changeUser = it.changeUser,
                otype = it.otype,
                id = it.id,
                mentorName = it.mentorName,
                mentoringBeginDate = it.mentoringBeginDate,
            )
            list.add(data)
        }
        return list
    }

    fun mapEntitiestoDomain(input: List<MentorUserEntity>): List<MentorUser> =
        input.map {
            MentorUser(
                endDate = it.endDate,
                mentoringTitle = it.mentoringTitle,
                objectIdentifier = it.objectIdentifier,
                mentoringDuration = it.mentoringDuration,
                mentoringChangeUser = it.mentoringChangeUser,
                changeDate = it.changeDate,
                beginDate = it.beginDate,
                businessCode = it.businessCode,
                mentoring = it.mentoring,
                personnelNumber = it.personnelNumber,
                mentoringChangeDate = it.mentoringChangeDate,
                mentoringTopic = it.mentoringTopic,
                mentoringSession = it.mentoringSession,
                mentoringMentoringId = it.mentoringMentoringId,
                mentoringBusinessCode = it.mentoringBusinessCode,
                mentorId = it.mentorId,
                mentoringEndDate = it.mentoringEndDate,
                mentoringDescription = it.mentoringDescription,
                mentoringReferenceMentoring = it.mentoringReferenceMentoring,
                changeUser = it.changeUser,
                otype = it.otype,
                id = it.id,
                mentorName = it.mentorName,
                mentoringBeginDate = it.mentoringBeginDate,
            )
        }
}