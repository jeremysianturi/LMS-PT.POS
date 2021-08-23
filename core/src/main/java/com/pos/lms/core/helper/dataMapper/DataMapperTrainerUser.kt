package com.pos.lms.core.helper.dataMapper

import com.pos.lms.core.data.source.local.entity.trainer.TrainerUserEntity
import com.pos.lms.core.data.source.remote.response.trainer.TrainerResponse
import com.pos.lms.core.domain.model.TrainerUser

/**
 * Created by Muhammad Zaim Milzam on 08/02/21.
 * linkedin : Muhammad Zaim Milzam
 */
object DataMapperTrainerUser {

    fun mapResponsetoEntities(input: List<TrainerResponse>): List<TrainerUserEntity> {
        val list = ArrayList<TrainerUserEntity>()
        input.map {
            val data = TrainerUserEntity(
                sessionName = it.sessionName,
                cHGDT = it.cHGDT,
                pERNR = it.pERNR,
                eNDDA = it.eNDDA,
                bUSCD = it.bUSCD,
                situationCode = it.situationCode,
                scheduleName = it.scheduleName,
                dayNumber = it.dayNumber,
                tRAID = it.tRAID,
                eventStatId = it.eventStatId,
                trainerName = it.trainerName,
                eventStatus = it.eventStatus,
                situationName = it.situationName,
                bEGDA = it.bEGDA,
                bUSC1 = it.bUSC1,
                endTime = it.endTime,
                batch = it.batch,
                sessionId = it.sessionId,
                beginTime = it.beginTime,
                batchName = it.batchName,
                eventId = it.eventId,
                topic = it.topic,
                eventName = it.eventName,
                tRNAM = it.tRNAM,
                sTTAR = it.sTTAR,
                cHUSR = it.cHUSR,
                scheduleId = it.scheduleId,

                )
            list.add(data)
        }

        return list
    }

    fun mapEntitiestoDomain(input: List<TrainerUserEntity>): List<TrainerUser> =
        input.map {
            TrainerUser(
                sessionName = it.sessionName,
                cHGDT = it.cHGDT,
                pERNR = it.pERNR,
                eNDDA = it.eNDDA,
                bUSCD = it.bUSCD,
                situationCode = it.situationCode,
                scheduleName = it.scheduleName,
                dayNumber = it.dayNumber,
                tRAID = it.tRAID,
                eventStatId = it.eventStatId,
                trainerName = it.trainerName,
                eventStatus = it.eventStatus,
                situationName = it.situationName,
                bEGDA = it.bEGDA,
                bUSC1 = it.bUSC1,
                endTime = it.endTime,
                batch = it.batch,
                sessionId = it.sessionId,
                beginTime = it.beginTime,
                batchName = it.batchName,
                eventId = it.eventId,
                topic = it.topic,
                eventName = it.eventName,
                tRNAM = it.tRNAM,
                sTTAR = it.sTTAR,
                cHUSR = it.cHUSR,
                scheduleId = it.scheduleId,
            )
        }
}