package com.pos.lms.core.domain.repository

import com.pos.lms.core.data.Resource
import com.pos.lms.core.domain.model.MentorUser
import kotlinx.coroutines.flow.Flow

interface IMentorRepository {

    fun getMentor(id: String, begda: String, endda: String): Flow<Resource<List<MentorUser>>>
}