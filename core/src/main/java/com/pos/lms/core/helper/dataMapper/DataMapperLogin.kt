package com.pos.lms.core.helper.dataMapper

import com.pos.lms.core.data.source.local.entity.LoginEntity
import com.pos.lms.core.data.source.remote.response.LoginResponse
import com.pos.lms.core.domain.model.Login

/**
 * Created by Muhammad Zaim Milzam on 26/01/21.
 * linkedin : Muhammad Zaim Milzam
 */
object DataMapperLogin {
    fun mapResponsetoEntities(input: LoginResponse): LoginEntity {
        return LoginEntity(
            accessToken = input.accessToken,
            pernr = input.pernr,
            activeSessions = input.activeSessions,
            tokenType = input.tokenType,
            expiresIn = input.expiresIn

        )
    }

    fun mapEntitiestoDomain(input: LoginEntity?) =
        Login(
            accessToken = input?.accessToken ?: "",
            pernr = input?.pernr ?: "",
            activeSessions = input?.activeSessions ?: 0,
            tokenType = input?.tokenType ?: "",
            expiresIn = input?.expiresIn ?: 0
        )

    fun mapDomaintoEntity(input: Login) = LoginEntity(
        accessToken = input.accessToken,
        pernr = input.pernr,
        activeSessions = input.activeSessions,
        tokenType = input.tokenType,
        expiresIn = input.expiresIn
    )
}