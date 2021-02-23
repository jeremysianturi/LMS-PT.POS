package com.pos.lms.core.helper.dataMapper

import com.pos.lms.core.data.source.local.entity.ItemParIdEntity
import com.pos.lms.core.data.source.local.entity.student.AbsensiEntity
import com.pos.lms.core.data.source.remote.response.student.session.absensi.AbsensiResponse
import com.pos.lms.core.domain.model.Absensi
import com.pos.lms.core.domain.model.ParId

/**
 * Created by Muhammad Zaim Milzam on 06/02/21.
 * linkedin : Muhammad Zaim Milzam
 */
object DataMapperAbsensi {
    fun mapResponsesToEntities(input: List<AbsensiResponse>): List<AbsensiEntity> {
        val parIdList = ArrayList<AbsensiEntity>()
        input.map {
            val parId = AbsensiEntity(
              data = it.data
            )
            parIdList.add(parId)
        }
        return parIdList
    }

    fun mapEntitiesToDomain(input: List<AbsensiEntity>): List<Absensi> =
        input.map {
            Absensi(
                data = it.data
            )
        }

    fun mapDomainToEntity(input: ParId) = ItemParIdEntity(
        accessToken = input.accessToken,
        username = input.username,
        type = input.type,
        id = input.id
    )
}