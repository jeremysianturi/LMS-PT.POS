package com.pos.lms.core.helper.dataMapper

import com.pos.lms.core.data.source.local.entity.ItemParIdEntity
import com.pos.lms.core.data.source.local.entity.student.AbsensiEntity
import com.pos.lms.core.data.source.remote.response.student.session.absensi.AbsensiResponse
import com.pos.lms.core.domain.model.Absensi
import com.pos.lms.core.domain.model.ParId

object DataMapperAbsensi {
    fun mapResponsesToEntities(input: AbsensiResponse): AbsensiEntity {
        return AbsensiEntity(
            data = input.data.toString()
        )
    }

    fun mapEntitiesToDomain(input: AbsensiEntity) =
        Absensi(
            data = input.data
        )

    fun mapDomainToEntity(input: ParId) = ItemParIdEntity(
        accessToken = input.accessToken,
        username = input.username,
        type = input.type,
        id = input.id
    )
}