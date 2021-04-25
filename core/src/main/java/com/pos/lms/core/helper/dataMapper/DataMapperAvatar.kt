package com.pos.lms.core.helper.dataMapper

import com.pos.lms.core.data.source.local.entity.profile.AvatarEntity
import com.pos.lms.core.data.source.remote.response.profile.AvatarResponse
import com.pos.lms.core.domain.model.Avatar

/**
 * Created by Muhammad Zaim Milzam on 08/02/21.
 * linkedin : Muhammad Zaim Milzam
 */
object DataMapperAvatar {

    fun mapResponsetoEntities(input: List<AvatarResponse>): List<AvatarEntity> {
        val list = ArrayList<AvatarEntity>()
        input.map {
            val data = AvatarEntity(
                objectIdentifier = it.objectIdentifier,
                changeDate = it.changeDate,
                changeUser = it.changeUser,
                businessCode = it.businessCode,
                avatar = it.avatar,
                username = it.username,
            )
            list.add(data)
        }
        return list
    }

    fun mapEntitiestoDomain(input: List<AvatarEntity>): List<Avatar> =
        input.map {
            Avatar(
                objectIdentifier = it.objectIdentifier,
                changeDate = it.changeDate,
                changeUser = it.changeUser,
                businessCode = it.businessCode,
                avatar = it.avatar,
                username = it.username,
            )
        }
}