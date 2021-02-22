package com.pos.lms.core.helper.dataMapper

import com.pos.lms.core.data.source.local.entity.ItemParIdEntity
import com.pos.lms.core.data.source.remote.response.parId.ItemParId
import com.pos.lms.core.domain.model.ParId

/**
 * Created by Muhammad Zaim Milzam on 06/02/21.
 * linkedin : Muhammad Zaim Milzam
 */
object DataMapperParId {
    fun mapResponsesToEntities(input: List<ItemParId>): List<ItemParIdEntity> {
        val parIdList = ArrayList<ItemParIdEntity>()
        input.map {
            val parId = ItemParIdEntity(
               accessToken = it.accessToken,
                username = it.username,
                type = it.type,
                id = it.id
            )
            parIdList.add(parId)
        }
        return parIdList
    }

    fun mapEntitiesToDomain(input: List<ItemParIdEntity>): List<ParId> =
        input.map {
            ParId(
                accessToken = it.accessToken,
                username = it.username,
                type = it.type,
                id = it.id
            )
        }

    fun mapDomainToEntity(input: ParId) = ItemParIdEntity(
        accessToken = input.accessToken,
        username = input.username,
        type = input.type,
        id = input.id
    )
}