package com.pos.lms.core.data.repository

import com.pos.lms.core.data.NetworkBoundResource
import com.pos.lms.core.data.Resource
import com.pos.lms.core.data.source.local.room.LocalDataSource
import com.pos.lms.core.data.source.remote.RemoteDataSource
import com.pos.lms.core.data.source.remote.network.ApiResponse
import com.pos.lms.core.data.source.remote.response.student.StudentResponse
import com.pos.lms.core.data.source.remote.response.student.forum.ForumListResponse
import com.pos.lms.core.data.source.remote.response.student.insight.InsightListResponse
import com.pos.lms.core.data.source.remote.response.student.session.DetailSessionResponse
import com.pos.lms.core.data.source.remote.response.student.session.SessionListResponse
import com.pos.lms.core.domain.model.*
import com.pos.lms.core.domain.repository.IStudentRepository
import com.pos.lms.core.utils.AppExecutors
import com.pos.lms.core.utils.dataMapper.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Muhammad Zaim Milzam on 10/02/21.
 * linkedin : Muhammad Zaim Milzam
 */
@Singleton
class StudentRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : IStudentRepository {

    override fun getStudent(parId: String): Flow<Resource<List<Student>>> =
        object : NetworkBoundResource<List<Student>, List<StudentResponse>>() {

            override fun loadFromDB(): Flow<List<Student>> {
                return localDataSource.getStudent().map {
                    DataMapperStudent.mapEntitiestoDomain(it)
                }
            }

            override fun shouldFetch(data: List<Student>?): Boolean =
                true

            override suspend fun createCall(): Flow<ApiResponse<List<StudentResponse>>> =
                remoteDataSource.getStudent(parId)

            override suspend fun saveCallResult(data: List<StudentResponse>) {
                val list = DataMapperStudent.mapResponsetoEntities(data)
                localDataSource.insertStudent(list)
            }

        }.asFlow()

    override fun getDetailSession(eventId: String): Flow<Resource<List<DetailSession>>> =
        object : NetworkBoundResource<List<DetailSession>, List<DetailSessionResponse>>() {
            override fun loadFromDB(): Flow<List<DetailSession>> {
                return localDataSource.getDetailSession().map {
                    DataMapperDetailSession.mapEntitiestoDomain(it)
                }
            }

            override fun shouldFetch(data: List<DetailSession>?): Boolean =
                true

            override suspend fun createCall(): Flow<ApiResponse<List<DetailSessionResponse>>> =
                remoteDataSource.getDetailSession(eventId)

            override suspend fun saveCallResult(data: List<DetailSessionResponse>) {
                val list = DataMapperDetailSession.mapResponsetoEntities(data)
                localDataSource.insertDetailSession(list)
            }

        }.asFlow()

    override fun getSessionList(
        batchId: String,
        begda: String,
        endda: String
    ): Flow<Resource<List<SessionList>>> =
        object : NetworkBoundResource<List<SessionList>, List<SessionListResponse>>() {
            override fun loadFromDB(): Flow<List<SessionList>> {
                return localDataSource.getSessionList().map {
                    DataMapperSessionList.mapEntitiestoDomain(it)
                }
            }

            override fun shouldFetch(data: List<SessionList>?): Boolean =
                true

            override suspend fun createCall(): Flow<ApiResponse<List<SessionListResponse>>> =
                remoteDataSource.getSessionList(batchId, begda, endda)

            override suspend fun saveCallResult(data: List<SessionListResponse>) {
                val list = DataMapperSessionList.mapResponsetoEntities(data)
                localDataSource.insertSessionList(list)
            }

        }.asFlow()

    override fun getForumList(
        batchId: String,
        begda: String,
        endda: String
    ): Flow<Resource<List<ForumList>>> =
        object : NetworkBoundResource<List<ForumList>, List<ForumListResponse>>() {
            override fun loadFromDB(): Flow<List<ForumList>> {
                return localDataSource.getForumList().map {
                    DataMapperForum.mapEntitiestoDomain(it)
                }
            }

            override fun shouldFetch(data: List<ForumList>?): Boolean =
                true

            override suspend fun createCall(): Flow<ApiResponse<List<ForumListResponse>>> =
                remoteDataSource.getForumList(batchId, begda, endda)

            override suspend fun saveCallResult(data: List<ForumListResponse>) {
                val list = DataMapperForum.mapResponsetoEntities(data)
                localDataSource.insertForumList(list)
            }

        }.asFlow()

    override fun getInsightList(
        batchId: String,
        begda: String,
        endda: String
    ): Flow<Resource<List<InsightList>>> =
        object : NetworkBoundResource<List<InsightList>, List<InsightListResponse>>() {
            override fun loadFromDB(): Flow<List<InsightList>> {
                return localDataSource.getInsightList().map {
                    DataMapperInsightList.mapEntitiestoDomain(it)
                }
            }

            override fun shouldFetch(data: List<InsightList>?): Boolean =
                true

            override suspend fun createCall(): Flow<ApiResponse<List<InsightListResponse>>> =
                remoteDataSource.getInsightList(batchId, begda, endda)

            override suspend fun saveCallResult(data: List<InsightListResponse>) {
                val list = DataMapperInsightList.mapResponsetoEntities(data)
                localDataSource.insertInsightList(list)
            }

        }.asFlow()


}