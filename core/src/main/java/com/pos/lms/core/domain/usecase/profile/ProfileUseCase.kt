package com.pos.lms.core.domain.usecase.profile

import com.pos.lms.core.data.Resource
import com.pos.lms.core.domain.model.Avatar
import kotlinx.coroutines.flow.Flow

interface ProfileUseCase {

    fun getAvatar(userName: String): Flow<Resource<List<Avatar>>>
}