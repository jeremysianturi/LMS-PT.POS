package com.pos.lms.core.utils.dataMapper

import com.pos.lms.core.data.source.local.entity.student.StudentEntity
import com.pos.lms.core.data.source.remote.response.student.StudentResponse
import com.pos.lms.core.domain.model.Student

/**
 * Created by Muhammad Zaim Milzam on 10/02/21.
 * linkedin : Muhammad Zaim Milzam
 */
object DataMapperStudent {

    fun mapResponsetoEntities(input: List<StudentResponse>): List<StudentEntity> {
        val materiList = ArrayList<StudentEntity>()
        input.map {
            val materi = StudentEntity(
                endDate = it.endDate,
                bussinesCode = it.bussinesCode,
                partiNicknm = it.partiNicknm,
                beginDate = it.beginDate,
                participantId = it.participantId,
                batch = it.batch,
                eventCurrStat = it.eventCurrStat,
                bUSCD = it.bUSCD,
                curriculum = it.curriculum,
                locationId = it.locationId,
                curriculumBuscd = it.curriculumBuscd,
                curId = it.curId,
                batchName = it.batchName,
                evntCurrStatid = it.evntCurrStatid,
                eventId = it.eventId,
                eventType = it.eventType,
                companyName = it.companyName,
                eventName = it.eventName,
                location = it.location,
                partcipantName = it.partcipantName,
                eventStatId = it.eventStatId,
                curiculum1Buscd = it.curiculum1Buscd.toString(),
                eventStatus = it.eventStatus
            )
            materiList.add(materi)
        }

        return materiList
    }

    fun mapEntitiestoDomain(input: List<StudentEntity>): List<Student> =
        input.map {
            Student(
                endDate = it.endDate,
                bussinesCode = it.bussinesCode,
                partiNicknm = it.partiNicknm,
                beginDate = it.beginDate,
                participantId = it.participantId,
                batch = it.batch,
                eventCurrStat = it.eventCurrStat,
                bUSCD = it.bUSCD,
                curriculum = it.curriculum,
                locationId = it.locationId,
                curriculumBuscd = it.curriculumBuscd,
                curId = it.curId,
                batchName = it.batchName,
                evntCurrStatid = it.evntCurrStatid,
                eventId = it.eventId,
                eventType = it.eventType,
                companyName = it.companyName,
                eventName = it.eventName,
                location = it.location,
                partcipantName = it.partcipantName,
                eventStatId = it.eventStatId,
                curiculum1Buscd = it.curiculum1Buscd,
                eventStatus = it.eventStatus
            )
        }

}