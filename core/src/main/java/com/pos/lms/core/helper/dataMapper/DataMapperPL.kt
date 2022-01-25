package com.pos.lms.core.helper.dataMapper

import com.pos.lms.core.data.source.local.entity.dropdown.PLEntity
import com.pos.lms.core.data.source.remote.response.dropdown.PLResponse
import com.pos.lms.core.domain.model.PL

object DataMapperPL {

    fun mapResponsesToEntities(input: List<PLResponse>): List<PLEntity> {
        val list = ArrayList<PLEntity>()
        input.map {
            val entity = PLEntity(
                endDate = it.endDate,
                objectIdentifier = it.objectIdentifier,
                objectType = it.objectType,
                changeDate = it.changeDate,
                shortText = it.shortText,
                beginDate = it.beginDate,
                businessCode = it.businessCode,
                longText = it.longText,
                planVersion = it.planVersion,
                objectDescription = it.objectDescription,
                changeUser = it.changeUser,
                id = it.id,
                value = it.value
            )
            list.add(entity)
        }
        return list
    }

    fun mapEntitiesToDomain(input: List<PLEntity>): List<PL> =
        input.map {
            PL(
                endDate = it.endDate,
                objectIdentifier = it.objectIdentifier,
                objectType = it.objectType,
                changeDate = it.changeDate,
                shortText = it.shortText,
                beginDate = it.beginDate,
                businessCode = it.businessCode,
                longText = it.longText,
                planVersion = it.planVersion,
                objectDescription = it.objectDescription,
                changeUser = it.changeUser,
                id = it.id,
                value = it.value
            )
        }

}