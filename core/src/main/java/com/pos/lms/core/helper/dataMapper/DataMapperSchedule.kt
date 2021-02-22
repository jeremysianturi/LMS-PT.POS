package com.pos.lms.core.helper.dataMapper

import com.pos.lms.core.data.source.local.entity.student.ScheduleEntity
import com.pos.lms.core.data.source.remote.response.student.session.schedule.ScheduleResponse
import com.pos.lms.core.domain.model.Schedule

/**
 * Created by Muhammad Zaim Milzam on 10/02/21.
 * linkedin : Muhammad Zaim Milzam
 */
object DataMapperSchedule {

    fun mapResponsetoEntities(input: List<ScheduleResponse>): List<ScheduleEntity> {
        val materiList = ArrayList<ScheduleEntity>()
        input.map {
            val materi = ScheduleEntity(
                endDate = it.endDate,
                objectIdentifier = it.objectIdentifier,
                changeDate = it.changeDate,
                beginDate = it.beginDate,
                endTime = it.endTime,
                beginTime = it.beginTime,
                changeUser = it.changeUser,
                dayNumber = it.dayNumber,
                topic = it.topic,
                scheduleDate = it.scheduleDate,
                scheduleId = it.scheduleId,
                scheduleName = it.scheduleName,
            )
            materiList.add(materi)
        }

        return materiList
    }

    fun mapEntitiestoDomain(input: List<ScheduleEntity>): List<Schedule> =
        input.map {
            Schedule(
                endDate = it.endDate,
                objectIdentifier = it.objectIdentifier,
                changeDate = it.changeDate,
                beginDate = it.beginDate,
                endTime = it.endTime,
                beginTime = it.beginTime,
                changeUser = it.changeUser,
                dayNumber = it.dayNumber,
                topic = it.topic,
                scheduleDate = it.scheduleDate,
                scheduleId = it.scheduleId,
                scheduleName = it.scheduleName,
            )
        }

}