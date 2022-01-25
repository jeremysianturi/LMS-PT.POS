package com.pos.lms.core.domain.repository

import com.pos.lms.core.data.Resource
import com.pos.lms.core.domain.model.Avatar
import kotlinx.coroutines.flow.Flow

interface IProfileRepository {

    fun getAvatar(userName: String): Flow<Resource<List<Avatar>>>
}