package com.pos.lms.core.domain.usecase.mentor

import com.pos.lms.core.data.Resource
import com.pos.lms.core.domain.model.MentorUser
import kotlinx.coroutines.flow.Flow

interface MentorUseCase {

    fun getMentor(id: String, begda: String, endda: String): Flow<Resource<List<MentorUser>>>
}