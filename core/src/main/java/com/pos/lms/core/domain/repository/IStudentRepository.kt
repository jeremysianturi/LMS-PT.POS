package com.pos.lms.core.domain.repository

import com.pos.lms.core.data.Resource
import com.pos.lms.core.data.source.remote.post.ForumCommnetPost
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

    fun getMateriSchedule(parentId :String , begda: String, endda: String) : Flow<Resource<List<MateriSchedule>>>
}