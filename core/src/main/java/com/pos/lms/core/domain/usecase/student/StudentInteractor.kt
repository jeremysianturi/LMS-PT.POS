package com.pos.lms.core.domain.usecase.student

import com.pos.lms.core.data.Resource
import com.pos.lms.core.data.repository.StudentRepository
import com.pos.lms.core.data.source.remote.post.ForumCommnetPost
import com.pos.lms.core.data.source.remote.post.MentoringChatPost
import com.pos.lms.core.domain.model.*
import kotlinx.coroutines.flow.Flow
import okhttp3.MultipartBody
import okhttp3.RequestBody
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

    override fun createForum(
        businesCode: RequestBody,
        batch: RequestBody,
        owner: RequestBody,
        tittle: RequestBody,
        desc: RequestBody,
        type: RequestBody,
        image: MultipartBody.Part,
        time: RequestBody,
        begda: RequestBody,
        endda: RequestBody
    ): Flow<Resource<Submit>> =
        studentRepository.createForum(
            businesCode,
            batch,
            owner,
            tittle,
            desc,
            type,
            image,
            time,
            begda,
            endda
        )


    override fun getForumComment(
        forumId: String,
        begda: String,
        endda: String
    ): Flow<Resource<List<ForumComment>>> =
        studentRepository.getForumComment(forumId, begda, endda)


    override fun postForumComment(forumCommnetPost: ForumCommnetPost): Flow<Resource<Submit>> =
        studentRepository.postForumComment(forumCommnetPost)

    override fun getInsightList(
        batchId: String,
        begda: String,
        endda: String
    ): Flow<Resource<List<InsightList>>> =
        studentRepository.getInsightList(batchId, begda, endda)

    override fun getSchedule(sessionId: String): Flow<Resource<List<Schedule>>> =
        studentRepository.getSchedule(sessionId)

    override fun getMateriSchedule(
        parentId: String,
        begda: String,
        endda: String
    ): Flow<Resource<List<MateriSchedule>>> =
        studentRepository.getMateriSchedule(parentId, begda, endda)

    override fun getTestSchedule(
        scheduleId: String,
        begda: String,
        endda: String
    ): Flow<Resource<List<TestSchedule>>> =
        studentRepository.getTestSchedule(scheduleId, begda, endda)

    override fun getQuisionerSchedule(
        scheduleId: String,
        begda: String,
        endda: String
    ): Flow<Resource<List<QuisionerSchedule>>> =
        studentRepository.getQuisionerSchedule(scheduleId, begda, endda)

    override fun getTrainerSchedule(
        parentId: String,
        begda: String,
        endda: String
    ): Flow<Resource<List<TrainerSchedule>>> =
        studentRepository.getTrainerSchedule(parentId, begda, endda)

    override fun getRoomSchedule(
        parentId: String,
        begda: String,
        endda: String
    ): Flow<Resource<List<RoomSchedule>>> =
        studentRepository.getRoomSchedule(parentId, begda, endda)

    override fun getMentoring(
        sessionId: String,
        id: String,
        begda: String,
        endda: String
    ): Flow<Resource<List<Mentoring>>> =
        studentRepository.getMentoring(sessionId, id, begda, endda)

    override fun getMentoringChat(mentoringId: String): Flow<Resource<List<MentoringChat>>> =
        studentRepository.getMentoringChat(mentoringId)

    override fun postMentoringChat(mentoringChatPost: MentoringChatPost): Flow<Resource<Submit>> =
        studentRepository.postMentoringChat(mentoringChatPost)


}