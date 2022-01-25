package com.pos.lms.core.helper.dataMapper

import com.pos.lms.core.data.source.local.entity.student.TestScheduleEntity
import com.pos.lms.core.data.source.remote.response.student.session.detailSchedule.TestScheduleResponse
import com.pos.lms.core.domain.model.TestSchedule

object DataMapperTestSchedule {

    fun mapResponsesToEntities(input: List<TestScheduleResponse>): List<TestScheduleEntity> {
        val list = ArrayList<TestScheduleEntity>()
        input.map {
            val entity = TestScheduleEntity(
                endDate = it.endDate,
                testCodeName = it.testCodeName,
                objectIdentifier = it.objectIdentifier,
                beginDate = it.beginDate,
                testTypeId = it.testTypeId,
                endTime = it.endTime,
                sessionId = it.sessionId,
                beginTime = it.beginTime,
                businessCode = it.businessCode,
                changedDate = it.changedDate,
                testCodeId = it.testCodeId,
                scheduleDate = it.scheduleDate,
                scheduleName = it.scheduleName,
                changedUser = it.changedUser,
                reference = it.reference,
                testTypeName = it.testTypeName,
                relationQuestionId = it.relationQuestionId,
                companyName = it.companyName,
                topic = it.topic,
                dayNumber = it.dayNumber,
                scheduleId = it.scheduleId,
            )
            list.add(entity)
        }
        return list
    }

    fun mapEntitiesToDomain(input: List<TestScheduleEntity>): List<TestSchedule> =
        input.map {
            TestSchedule(
                endDate = it.endDate,
                testCodeName = it.testCodeName,
                objectIdentifier = it.objectIdentifier,
                beginDate = it.beginDate,
                testTypeId = it.testTypeId,
                endTime = it.endTime,
                sessionId = it.sessionId,
                beginTime = it.beginTime,
                businessCode = it.businessCode,
                changedDate = it.changedDate,
                testCodeId = it.testCodeId,
                scheduleDate = it.scheduleDate,
                scheduleName = it.scheduleName,
                changedUser = it.changedUser,
                reference = it.reference,
                testTypeName = it.testTypeName,
                relationQuestionId = it.relationQuestionId,
                companyName = it.companyName,
                topic = it.topic,
                dayNumber = it.dayNumber,
                scheduleId = it.scheduleId,
            )
        }

}