package com.pos.lms.core.helper.dataMapper

import com.pos.lms.core.data.source.local.entity.student.StudentEntity
import com.pos.lms.core.data.source.remote.response.student.StudentResponse
import com.pos.lms.core.domain.model.Student

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
                endDate = it.endDate.toString(),
                bussinesCode = it.bussinesCode.toString(),
                partiNicknm = it.partiNicknm.toString(),
                beginDate = it.beginDate.toString(),
                participantId = it.participantId,
                batch = it.batch,
                eventCurrStat = it.eventCurrStat.toString(),
                bUSCD = it.bUSCD,
                curriculum = it.curriculum.toString(),
                locationId = it.locationId.toString(),
                curriculumBuscd = it.curriculumBuscd.toString(),
                curId = it.curId.toString(),
                batchName = it.batchName.toString(),
                evntCurrStatid = it.evntCurrStatid.toString(),
                eventId = it.eventId,
                eventType = it.eventType.toString(),
                companyName = it.companyName.toString(),
                eventName = it.eventName.toString(),
                location = it.location.toString(),
                partcipantName = it.partcipantName.toString(),
                eventStatId = it.eventStatId.toString(),
                curiculum1Buscd = it.curiculum1Buscd.toString(),
                eventStatus = it.eventStatus.toString()
            )
        }

}