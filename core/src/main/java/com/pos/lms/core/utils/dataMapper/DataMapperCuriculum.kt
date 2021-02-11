package com.pos.lms.core.utils.dataMapper

import com.pos.lms.core.data.source.local.entity.curiculum.CuriculumEntity
import com.pos.lms.core.data.source.remote.response.curiculum.CuriculumResponse
import com.pos.lms.core.domain.model.Curiculum

/**
 * Created by Muhammad Zaim Milzam on 08/02/21.
 * linkedin : Muhammad Zaim Milzam
 */
object DataMapperCuriculum {

    fun mapResponsetoEntities(input: List<CuriculumResponse>): List<CuriculumEntity> {
        val curiculumList = ArrayList<CuriculumEntity>()
        input.map {
            val curiculum = CuriculumEntity(
                endDate = it.endDate,
                objectIdentifier = it.objectIdentifier,
                beginDate = it.beginDate,
                businessCode = it.businessCode,
                requestDescription = it.requestDescription,
                changedDate = it.changedDate,
                changedUser = it.changedUser,
                requestName = it.requestName,
                companyName = it.companyName,
                competenceId = it.competenceId,
                requestTypeName = it.requestTypeName,
                competenceName = it.competenceName,
                requestId = it.requestId,
                requestTypeId = it.requestTypeId,
                plName = it.plName,
                plCode = it.plCode
            )
            curiculumList.add(curiculum)
        }

        return curiculumList
    }

    fun mapEntitiestoDomain(input: List<CuriculumEntity>): List<Curiculum> =
        input.map {
            Curiculum(
                endDate = it.endDate,
                objectIdentifier = it.objectIdentifier,
                beginDate = it.beginDate,
                businessCode = it.businessCode,
                requestDescription = it.requestDescription,
                changedDate = it.changedDate,
                changedUser = it.changedUser,
                requestName = it.requestName,
                companyName = it.companyName,
                competenceId = it.competenceId,
                requestTypeName = it.requestTypeName,
                competenceName = it.competenceName,
                requestId = it.requestId,
                requestTypeId = it.requestTypeId,
                plName = it.plName,
                plCode = it.plCode
            )
        }
}