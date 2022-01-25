package com.pos.lms.core.helper.dataMapper

import com.pos.lms.core.data.source.local.entity.roadmap.MCPRotasiEntity
import com.pos.lms.core.data.source.remote.response.roadmap.ECPResponse
import com.pos.lms.core.domain.model.MCPRotasi

object DataMapperMCPRotasi {
    fun mapResponsesToEntities(input: List<ECPResponse>): List<MCPRotasiEntity> {
        val list = ArrayList<MCPRotasiEntity>()
        input.map {
            val entity = MCPRotasiEntity(
                payrollArea = it.payrollArea.toString(),
                objectIdentifier = it.objectIdentifier,
                wilayahCode = it.wilayahCode.toString(),
                positionCode = it.positionCode.toString(),
                applicants = it.applicants.toString(),
                positionName = it.positionName.toString(),
                businessArea = it.businessArea.toString(),
                wilayahName = it.wilayahName.toString(),
                personnelNumber = it.personnelNumber.toString(),
                levelJabatan = it.levelJabatan.toString(),
                kantorCode = it.kantorCode.toString(),
                kantorName = it.kantorName.toString(),
                jobFamilyName = it.jobFamilyName.toString(),
                score = it.score.toString(),
                jobName = it.jobName.toString(),
                eventCode = it.eventCode.toString(),
                aspiration = it.aspiration.toString(),
                levelJabatanOrder = it.levelJabatanOrder.toString(),
                ranking = it.ranking.toString(),
                jobCode = it.jobCode.toString(),
                aspirationType = it.aspirationType.toString(),
                tipeJabatan = it.tipeJabatan.toString(),
                commiteeCode = it.commiteeCode.toString(),
                jobFamilyId = it.jobFamilyId.toString(),
            )
            list.add(entity)
        }
        return list
    }

    fun mapEntitiesToDomain(input: List<MCPRotasiEntity>): List<MCPRotasi> =
        input.map {
            MCPRotasi(
                payrollArea = it.payrollArea,
                objectIdentifier = it.objectIdentifier,
                wilayahCode = it.wilayahCode,
                positionCode = it.positionCode,
                applicants = it.applicants,
                positionName = it.positionName,
                businessArea = it.businessArea,
                wilayahName = it.wilayahName,
                personnelNumber = it.personnelNumber,
                levelJabatan = it.levelJabatan,
                kantorCode = it.kantorCode,
                kantorName = it.kantorName,
                jobFamilyName = it.jobFamilyName,
                score = it.score,
                jobName = it.jobName,
                eventCode = it.eventCode,
                aspiration = it.aspiration,
                levelJabatanOrder = it.levelJabatanOrder,
                ranking = it.ranking,
                jobCode = it.jobCode,
                aspirationType = it.aspirationType,
                tipeJabatan = it.tipeJabatan,
                commiteeCode = it.commiteeCode,
                jobFamilyId = it.jobFamilyId,
            )
        }
}