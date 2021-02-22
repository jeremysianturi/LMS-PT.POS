package com.pos.lms.core.helper.dataMapper

import com.pos.lms.core.data.source.local.entity.materi.MateriEntity
import com.pos.lms.core.data.source.remote.response.materi.MateriResponse
import com.pos.lms.core.domain.model.Materi

/**
 * Created by Muhammad Zaim Milzam on 08/02/21.
 * linkedin : Muhammad Zaim Milzam
 */
object DataMapperMateri {

    fun mapResponsetoEntities(input: List<MateriResponse>): List<MateriEntity> {
        val materiList = ArrayList<MateriEntity>()
        input.map {
            val materi = MateriEntity(
                endDate = it.endDate,
                materiName = it.materiName,
                sellingPrice = it.sellingPrice,
                objectIdentifier = it.objectIdentifier,
                address = it.address,
                materiTypeName = it.materiTypeName,
                beginDate = it.beginDate,
                materiId = it.materiId,
                businessCode = it.businessCode,
                changedDate = it.changedDate,
                changedUser = it.changedUser,
                methodName = it.methodName,
                methodId = it.methodId,
                fileType = it.fileType,
                companyName = it.companyName,
                materiTypeId = it.materiTypeId,
                purchasePrice = it.purchasePrice,
                plCodeId = it.plCodeId,
                competenceId = it.competenceId,
                competenceName = it.competenceName,
                plCodeName = it.plCodeName,
                description = it.description
            )
            materiList.add(materi)
        }

        return materiList
    }

    fun mapEntitiestoDomain(input: List<MateriEntity>): List<Materi> =
        input.map {
            Materi(
                endDate = it.endDate,
                materiName = it.materiName,
                sellingPrice = it.sellingPrice,
                objectIdentifier = it.objectIdentifier,
                address = it.address,
                materiTypeName = it.materiTypeName,
                beginDate = it.beginDate,
                materiId = it.materiId,
                businessCode = it.businessCode,
                changedDate = it.changedDate,
                changedUser = it.changedUser,
                methodName = it.methodName,
                methodId = it.methodId,
                fileType = it.fileType,
                companyName = it.companyName,
                materiTypeId = it.materiTypeId,
                purchasePrice = it.purchasePrice,
                plCodeId = it.plCodeId,
                competenceId = it.competenceId,
                competenceName = it.competenceName,
                plCodeName = it.plCodeName,
                description = it.description
            )
        }
}