package com.pos.lms.core.utils.dataMapper

import com.pos.lms.core.data.source.local.entity.LoginEntity
import com.pos.lms.core.data.source.local.entity.SubmitEntity
import com.pos.lms.core.data.source.remote.response.SubmitResponse
import com.pos.lms.core.domain.model.Login
import com.pos.lms.core.domain.model.Submit

/**
 * Created by Muhammad Zaim Milzam on 26/01/21.
 * linkedin : Muhammad Zaim Milzam
 */
object DataMapperSubmit {
    fun mapResponsetoEntities(input: SubmitResponse): SubmitEntity {
        return SubmitEntity(
            status = input.status,
            message = input.message
        )
    }

    fun mapEntitiestoDomain(input: SubmitEntity?) =
        Submit(
            status = input?.status ?: false,
            message = input?.message ?: ""
        )

    fun mapDomaintoEntity(input: Login) = LoginEntity(
        accessToken = input.accessToken,
        pernr = input.pernr,
        activeSessions = input.activeSessions,
        tokenType = input.tokenType,
        expiresIn = input.expiresIn
    )
}