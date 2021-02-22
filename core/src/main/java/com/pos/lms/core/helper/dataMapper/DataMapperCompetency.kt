package com.pos.lms.core.helper.dataMapper

import com.pos.lms.core.data.source.local.entity.dropdown.CompetencyEntity
import com.pos.lms.core.data.source.remote.response.dropdown.CompetencyResponse
import com.pos.lms.core.domain.model.Competency

/**
 * Created by Muhammad Zaim Milzam on 08/02/21.
 * linkedin : Muhammad Zaim Milzam
 */
object DataMapperCompetency {

    fun mapResponsesToEntities(input: List<CompetencyResponse>): List<CompetencyEntity> {
        val list = ArrayList<CompetencyEntity>()
        input.map {
            val entity = CompetencyEntity(
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

    fun mapEntitiesToDomain(input: List<CompetencyEntity>): List<Competency> =
        input.map {
            Competency(
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