package com.pos.lms.core.domain.usecase.mentor

import com.pos.lms.core.data.Resource
import com.pos.lms.core.data.repository.MentorRepository
import com.pos.lms.core.domain.model.MentorUser
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MentorInteractor @Inject constructor(private val mentorRepository: MentorRepository) :
    MentorUseCase {

    override fun getMentor(
        id: String,
        begda: String,
        endda: String
    ): Flow<Resource<List<MentorUser>>> = mentorRepository.getMentor(id, begda, endda)
}