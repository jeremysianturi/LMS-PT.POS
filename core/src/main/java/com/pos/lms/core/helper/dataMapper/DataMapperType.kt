package com.pos.lms.core.helper.dataMapper

import com.pos.lms.core.data.source.local.entity.dropdown.TypeEntity
import com.pos.lms.core.data.source.remote.response.dropdown.TypeResponse
import com.pos.lms.core.domain.model.Type

/**
 * Created by Muhammad Zaim Milzam on 08/02/21.
 * linkedin : Muhammad Zaim Milzam
 */
object DataMapperType {

    fun mapResponsesToEntities(input: List<TypeResponse>): List<TypeEntity> {
        val list = ArrayList<TypeEntity>()
        input.map {
            val entity = TypeEntity(
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

    fun mapEntitiesToDomain(input: List<TypeEntity>): List<Type> =
        input.map {
            Type(
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