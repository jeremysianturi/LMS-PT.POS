package com.pos.lms.core.domain.usecase.student

import com.pos.lms.core.data.Resource
import com.pos.lms.core.data.repository.StudentRepository
import com.pos.lms.core.domain.model.*
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by Muhammad Zaim Milzam on 10/02/21.
 * linkedin : Muhammad Zaim Milzam
 */
class StudentInteractor @Inject constructor(private val studentRepository: StudentRepository) :
    StudentUsecase {

    override fun getStudent(parid: String): Flow<Resource<List<Student>>> =
        studentRepository.getStudent(parid)

    override fun getDetailSession(eventId: String): Flow<Resource<List<DetailSession>>> =
        studentRepository.getDetailSession(eventId)

    override fun getSessionList(
        batchId: String,
        begda: String,
        endda: String
    ): Flow<Resource<List<SessionList>>> =
        studentRepository.getSessionList(batchId, begda, endda)

    override fun getForumList(
        batchId: String,
        begda: String,
        endda: String
    ): Flow<Resource<List<ForumList>>> =
        studentRepository.getForumList(batchId, begda, endda)

    override fun getInsightList(
        batchId: String,
        begda: String,
        endda: String
    ): Flow<Resource<List<InsightList>>> =
        studentRepository.getInsightList(batchId, begda, endda)


}