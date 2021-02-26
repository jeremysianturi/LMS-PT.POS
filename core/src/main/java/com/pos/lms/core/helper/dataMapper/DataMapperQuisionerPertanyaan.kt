package com.pos.lms.core.helper.dataMapper

import com.pos.lms.core.data.source.local.entity.student.QuisionerPertanyaanEntity
import com.pos.lms.core.data.source.remote.response.student.session.detailSchedule.QuisionerPertanyaanResponse
import com.pos.lms.core.domain.model.QuisionerPertanyaan

/**
 * Created by Muhammad Zaim Milzam on 08/02/21.
 * linkedin : Muhammad Zaim Milzam
 */
object DataMapperQuisionerPertanyaan {

    fun mapResponsesToEntities(input: List<QuisionerPertanyaanResponse>): List<QuisionerPertanyaanEntity> {
        val list = ArrayList<QuisionerPertanyaanEntity>()
        input.map {
            val entity = QuisionerPertanyaanEntity(
                endDate = it.endDate,
                objectIdentifier = it.objectIdentifier,
                quesionerPurposeName = it.quesionerPurposeName,
                beginDate = it.beginDate,
                quesionerPurposeId = it.quesionerPurposeId,
                businessCode = it.businessCode,
                changedDate = it.changedDate,
                quesionerTitle = it.quesionerTitle,
                changedUser = it.changedUser,
                quesionerTypeId = it.quesionerTypeId,
                relation = it.relation,
                tableCode = it.tableCode,
                companyName = it.companyName,
                quesionerId = it.quesionerId,
                otype = it.otype,
                quesionerCategoryId = it.quesionerCategoryId,
                questionerTypeName = it.questionerTypeName,
                quesionerCategoryName = it.quesionerCategoryName,
                quesionerText = it.quesionerText,
                numberOfChoice = it.numberOfChoice,
                objects = it.objects,
                _id = 0

            )
            list.add(entity)
        }
        return list
    }

    fun mapEntitiesToDomain(input: List<QuisionerPertanyaanEntity>): List<QuisionerPertanyaan> =
        input.map {
            QuisionerPertanyaan(
                endDate = it.endDate,
                objectIdentifier = it.objectIdentifier,
                quesionerPurposeName = it.quesionerPurposeName,
                beginDate = it.beginDate,
                quesionerPurposeId = it.quesionerPurposeId,
                businessCode = it.businessCode,
                changedDate = it.changedDate,
                quesionerTitle = it.quesionerTitle,
                changedUser = it.changedUser,
                quesionerTypeId = it.quesionerTypeId,
                relation = it.relation,
                tableCode = it.tableCode,
                companyName = it.companyName,
                quesionerId = it.quesionerId,
                otype = it.otype,
                quesionerCategoryId = it.quesionerCategoryId,
                questionerTypeName = it.questionerTypeName,
                quesionerCategoryName = it.quesionerCategoryName,
                quesionerText = it.quesionerText,
                numberOfChoice = it.numberOfChoice,
                objects = it.objects,
                _id = it._id
            )
        }

    fun mapDomainToEntity(input: QuisionerPertanyaan) = QuisionerPertanyaanEntity(
        endDate = input.endDate,
        objectIdentifier = input.objectIdentifier,
        quesionerPurposeName = input.quesionerPurposeName,
        beginDate = input.beginDate,
        quesionerPurposeId = input.quesionerPurposeId,
        businessCode = input.businessCode,
        changedDate = input.changedDate,
        quesionerTitle = input.quesionerTitle,
        changedUser = input.changedUser,
        quesionerTypeId = input.quesionerTypeId,
        relation = input.relation,
        tableCode = input.tableCode,
        companyName = input.companyName,
        quesionerId = input.quesionerId,
        otype = input.otype,
        quesionerCategoryId = input.quesionerCategoryId,
        questionerTypeName = input.questionerTypeName,
        quesionerCategoryName = input.quesionerCategoryName,
        quesionerText = input.quesionerText,
        numberOfChoice = input.numberOfChoice,
        objects = input.objects,
        _id = input._id

    )

}