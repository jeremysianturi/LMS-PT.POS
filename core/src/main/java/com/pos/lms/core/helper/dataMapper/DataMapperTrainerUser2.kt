package com.pos.lms.core.helper.dataMapper

import com.pos.lms.core.data.source.local.entity.trainer.TrainerUserEntity2
import com.pos.lms.core.data.source.remote.response.trainer.TrainerResponse
import com.pos.lms.core.domain.model.TrainerUser

/**
 * Created by Muhammad Zaim Milzam on 08/02/21.
 * linkedin : Muhammad Zaim Milzam
 */
object DataMapperTrainerUser2 {

    fun mapResponsetoEntities(input: List<TrainerResponse>): List<TrainerUserEntity2> {
        val list = ArrayList<TrainerUserEntity2>()
        input.map {
            val data = TrainerUserEntity2(
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

    fun mapEntitiestoDomain(input: List<TrainerUserEntity2>): List<TrainerUser> =
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