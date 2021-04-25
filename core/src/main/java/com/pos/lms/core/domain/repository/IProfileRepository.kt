package com.pos.lms.core.domain.repository

import com.pos.lms.core.data.Resource
import com.pos.lms.core.domain.model.Avatar
import kotlinx.coroutines.flow.Flow

/**
 * Created by Muhammad Zaim Milzam on 22/04/21.
 * linkedin : Muhammad Zaim Milzam
 */
interface IProfileRepository {

    fun getAvatar(userName: String): Flow<Resource<List<Avatar>>>
}