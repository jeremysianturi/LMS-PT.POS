package com.pos.lms.core.domain.usecase.student

import com.pos.lms.core.data.Resource
import com.pos.lms.core.data.repository.StudentRepository
import com.pos.lms.core.data.source.remote.post.*
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
    override fun getPagination(): Flow<Pagination> = studentRepository.getPagination()

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

    override fun getSearchForum(search: String): Flow<List<ForumList>> =
        studentRepository.getSearchForum(search)

    override fun getOwnerForum(owner: String): Flow<List<ForumList>> =
        studentRepository.getOwnerForum(owner)

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

    override fun deteleForum(oid: String): Flow<Resource<Submit>> =
        studentRepository.deteleForum(oid)


    override fun getForumComment(
        forumId: String,
        begda: String,
        endda: String
    ): Flow<Resource<List<ForumComment>>> =
        studentRepository.getForumComment(forumId, begda, endda)

    override fun postForumComment(forumCommnetPost: ForumCommnetPost): Flow<Resource<Submit>> =
        studentRepository.postForumComment(forumCommnetPost)

    override fun postForumLike(forumLikePost: ForumLikePost): Flow<Resource<Submit>> =
        studentRepository.postForumLike(forumLikePost)

    override fun getForumLike(forumId: String): Flow<Resource<List<ForumLike>>> =
        studentRepository.getForumLike(forumId)

    override fun getInsightList(
        batchId: String,
        begda: String,
        endda: String
    ): Flow<Resource<List<InsightList>>> =
        studentRepository.getInsightList(batchId, begda, endda)

    override fun deteleInsight(oid: String): Flow<Resource<Submit>> =
        studentRepository.deteleInsight(oid)

    override fun getSearchInsight(search: String): Flow<List<InsightList>> =
        studentRepository.getSearchInsight(search)

    override fun getOwnerInsight(owner: String): Flow<List<InsightList>> =
        studentRepository.getOwnerInsight(owner)

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

    override fun getTestPertanyaan(
        begda: String,
        endda: String
    ): Flow<Resource<List<TestPertanyaan>>> =
        studentRepository.getTestPertanyaan(begda, endda)

    override fun getTestPertanyaanWithId(id: Long): Flow<List<TestPertanyaan>> =
        studentRepository.getTestPertanyaanWithId(id)

    override fun getTestJawaban(
        questionId: String,
        begda: String,
        endda: String
    ): Flow<Resource<List<TestJawaban>>> =
        studentRepository.getTestJawaban(questionId, begda, endda)

    override fun setCheckedTestJawaban(answer: TestJawaban, state: Boolean) =
        studentRepository.setCheckedTestJawaban(answer, state)

    override fun getCheckedTestJawaban(): Flow<List<TestJawaban>> =
        studentRepository.getCheckedTestJawaban()

    override fun getOnlyCheckedTestJawaban(): Flow<List<String>> =
        studentRepository.getOnlyCheckedTestJawaban()

    override fun postTestAnswer(testJawabanPost: TestJawabanPost): Flow<Resource<Submit>> =
        studentRepository.postTestAnswer(testJawabanPost)

    override fun getQuisionerSchedule(
        scheduleId: String,
        begda: String,
        endda: String
    ): Flow<Resource<List<QuisionerSchedule>>> =
        studentRepository.getQuisionerSchedule(scheduleId, begda, endda)

    override fun getQuisionerAnswer(
        quisionerId: String,
        begda: String,
        endda: String
    ): Flow<Resource<List<QuisionerAnswer>>> =
        studentRepository.getQuisionerAnswer(quisionerId, begda, endda)

    override fun setCheckedQuisionerAnswer(answer: QuisionerAnswer, state: Boolean) =
        studentRepository.setCheckedQuisionerAnswer(answer, state)

    override fun getCheckedQuisionerAnswer(): Flow<List<QuisionerAnswer>> =
        studentRepository.getCheckedQuisionerAnswer()

    override fun getOnlyCheckedAnswer(): Flow<List<String>> =
        studentRepository.getOnlyCheckedQuisionerAnswer()

    override fun postQuisionerAnswer(quisionerAnswerPost: QuisionerAnswerPost): Flow<Resource<Submit>> =
        studentRepository.postQuisionerAnswer(quisionerAnswerPost)

    override fun getQuisionerPertanyaan(
        objects: String,
        tableCode: String,
        relation: String,
        otype: String,
        begda: String,
        endda: String
    ): Flow<Resource<List<QuisionerPertanyaan>>> =
        studentRepository.getQuisionerPertanyaan(objects, tableCode, relation, otype, begda, endda)

    override fun getQuisionerPertanyaanWithId(id: Long): Flow<List<QuisionerPertanyaan>> =
        studentRepository.getQuisionerPertanyaanWithId(id)

    override fun deleteQuisionerPertanyaan() = studentRepository.deleteQuisionerPertanyaan()

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

    override fun getMentoringDetail(
        mentoringId: String,
        begda: String,
        endda: String
    ): Flow<Resource<List<MentoringDetail>>> =
        studentRepository.getMentoringDetail(mentoringId, begda, endda)

    override fun getAbsensi(parentId: String, sessionId: String): Flow<Resource<Absensi>> =
        studentRepository.getAbsensi(parentId, sessionId)
}