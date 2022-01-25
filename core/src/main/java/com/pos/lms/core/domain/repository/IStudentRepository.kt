package com.pos.lms.core.domain.repository

import com.pos.lms.core.data.Resource
import com.pos.lms.core.data.source.remote.post.*
import com.pos.lms.core.domain.model.*
import kotlinx.coroutines.flow.Flow
import okhttp3.MultipartBody
import okhttp3.RequestBody

interface IStudentRepository {

    fun getPagination() : Flow<Pagination>
    fun getStudent(parId: String): Flow<Resource<List<Student>>>
    fun getDetailSession(eventId: String): Flow<Resource<List<DetailSession>>>
    fun getSessionList(
        batchId: String,
        begda: String,
        endda: String
    ): Flow<Resource<List<SessionList>>>

    fun getForumList(batchId: String, begda: String, endda: String): Flow<Resource<List<ForumList>>>

    fun getSearchForum(search: String): Flow<List<ForumList>>

    fun getOwnerForum(owner: String): Flow<List<ForumList>>

    fun createForum(
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
    ): Flow<Resource<Submit>>

    fun deteleForum(
        oid: String
    ): Flow<Resource<Submit>>

    fun getForumComment(
        forumId: String,
        begda: String,
        endda: String
    ): Flow<Resource<List<ForumComment>>>

    fun postForumComment(forumCommnetPost: ForumCommnetPost): Flow<Resource<Submit>>

    fun getForumLike(
        forumId: String,
    ): Flow<Resource<List<ForumLike>>>

    fun postForumLike(forumLikePost: ForumLikePost): Flow<Resource<Submit>>

    fun getInsightList(
        batchId: String,
        begda: String,
        endda: String
    ): Flow<Resource<List<InsightList>>>

    fun getSearchInsight(search: String): Flow<List<InsightList>>

    fun getOwnerInsight(owner: String): Flow<List<InsightList>>

    fun deteleInsight(
        oid: String
    ): Flow<Resource<Submit>>


    fun getSchedule(sessionId: String): Flow<Resource<List<Schedule>>>

    fun getMateriSchedule(
        parentId: String,
        begda: String,
        endda: String
    ): Flow<Resource<List<MateriSchedule>>>

    fun getTestSchedule(
        scheduleId: String,
        begda: String,
        endda: String
    ): Flow<Resource<List<TestSchedule>>>

    fun getTestPertanyaan(
        begda: String,
        endda: String
    ): Flow<Resource<List<TestPertanyaan>>>

    fun getTestPertanyaanWithId(id: Long): Flow<List<TestPertanyaan>>

    fun getTestJawaban(
        questionId: String,
        begda: String,
        endda: String
    ): Flow<Resource<List<TestJawaban>>>

    fun setCheckedTestJawaban(answer: TestJawaban, state: Boolean)

    fun getCheckedTestJawaban(): Flow<List<TestJawaban>>

    fun getOnlyCheckedTestJawaban(): Flow<List<String>>

    fun postTestJawaban(
        quisionerAnswerPost: QuisionerAnswerPost,
    ): Flow<Resource<Submit>>

    fun getQuisionerSchedule(
        scheduleId: String,
        begda: String,
        endda: String
    ): Flow<Resource<List<QuisionerSchedule>>>

    fun getQuisionerAnswer(
        quisionerId: String,
        begda: String,
        endda: String
    ): Flow<Resource<List<QuisionerAnswer>>>

    fun setCheckedQuisionerAnswer(answer: QuisionerAnswer, state: Boolean)

    fun getCheckedQuisionerAnswer(): Flow<List<QuisionerAnswer>>

    fun getOnlyCheckedQuisionerAnswer(): Flow<List<String>>

    fun postQuisionerAnswer(
        quisionerAnswerPost: QuisionerAnswerPost,
    ): Flow<Resource<Submit>>


    fun getQuisionerPertanyaan(
        objects: String,
        tableCode: String,
        relation: String,
        otype: String,
        begda: String,
        endda: String
    ): Flow<Resource<List<QuisionerPertanyaan>>>

    fun getQuisionerPertanyaanWithId(id: Long): Flow<List<QuisionerPertanyaan>>

    fun postTestAnswer(testJawabanPost: TestJawabanPost): Flow<Resource<Submit>>

    fun deleteQuisionerPertanyaan()

    fun getTrainerSchedule(
        parentId: String,
        begda: String,
        endda: String
    ): Flow<Resource<List<TrainerSchedule>>>

    fun getRoomSchedule(
        parentId: String,
        begda: String,
        endda: String
    ): Flow<Resource<List<RoomSchedule>>>

    // mentoring
    fun getMentoring(
        sessionId: String,
        id: String,
        begda: String,
        endda: String
    ): Flow<Resource<List<Mentoring>>>

    fun getMentoringChat(
        mentoringId: String,
    ): Flow<Resource<List<MentoringChat>>>

    fun postMentoringChat(
        mentoringChatPost: MentoringChatPost,
    ): Flow<Resource<Submit>>

    fun getAbsensi(
       parId: String,
       sessionId: String
    ): Flow<Resource<Absensi>>

    fun getMentoringDetail(
        mentoringId: String,
        begda: String,
        endda: String
    ): Flow<Resource<List<MentoringDetail>>>
}