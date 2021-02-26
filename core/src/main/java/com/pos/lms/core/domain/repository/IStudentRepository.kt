package com.pos.lms.core.domain.repository

import com.pos.lms.core.data.Resource
import com.pos.lms.core.data.source.remote.post.ForumCommnetPost
import com.pos.lms.core.data.source.remote.post.MentoringChatPost
import com.pos.lms.core.domain.model.*
import kotlinx.coroutines.flow.Flow
import okhttp3.MultipartBody
import okhttp3.RequestBody

/**
 * Created by Muhammad Zaim Milzam on 10/02/21.
 * linkedin : Muhammad Zaim Milzam
 */
interface IStudentRepository {
    fun getStudent(parId: String): Flow<Resource<List<Student>>>
    fun getDetailSession(eventId: String): Flow<Resource<List<DetailSession>>>
    fun getSessionList(
        batchId: String,
        begda: String,
        endda: String
    ): Flow<Resource<List<SessionList>>>

    fun getForumList(batchId: String, begda: String, endda: String): Flow<Resource<List<ForumList>>>

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

    fun getInsightList(
        batchId: String,
        begda: String,
        endda: String
    ): Flow<Resource<List<InsightList>>>

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

    fun setCheckedQuisionerAnswer(answer: QuisionerAnswer, state : Boolean)

    fun getCheckedQuisionerAnswer(): Flow<List<QuisionerAnswer>>

    fun getQuisionerPertanyaan(
        objects: String,
        tableCode: String,
        relation: String,
        otype: String,
        begda: String,
        endda: String
    ): Flow<Resource<List<QuisionerPertanyaan>>>

    fun getQuisionerPertanyaanWithId(id : Long) : Flow<List<QuisionerPertanyaan>>

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
        mentoringChatPost: MentoringChatPost,
    ): Flow<Resource<Submit>>

    fun getMentoringDetail(
        mentoringId: String,
        begda: String,
        endda: String
    ): Flow<Resource<List<MentoringDetail>>>
}