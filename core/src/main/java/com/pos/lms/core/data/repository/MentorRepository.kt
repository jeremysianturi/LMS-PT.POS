package com.pos.lms.core.data.repository

import com.pos.lms.core.data.NetworkBoundResourceWithDeleteLocalData
import com.pos.lms.core.data.Resource
import com.pos.lms.core.data.source.local.room.LocalDataSource
import com.pos.lms.core.data.source.remote.RemoteDataSource
import com.pos.lms.core.data.source.remote.network.ApiResponse
import com.pos.lms.core.data.source.remote.response.mentor.MentorUserResponse
import com.pos.lms.core.domain.model.MentorUser
import com.pos.lms.core.domain.repository.IMentorRepository
import com.pos.lms.core.helper.dataMapper.DataMapperMentor
import com.pos.lms.core.utils.AppExecutors
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton



@Singleton
class MentorRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : IMentorRepository {

    override fun getMentor(
        id: String,
        begda: String,
        endda: String
    ): Flow<Resource<List<MentorUser>>> =
        object :
            NetworkBoundResourceWithDeleteLocalData<List<MentorUser>, List<MentorUserResponse>>() {

            override fun loadFromDB(): Flow<List<MentorUser>> {
                return localDataSource.getMentor().map {
                    DataMapperMentor.mapEntitiestoDomain(it)
                }
            }

            override fun shouldFetch(data: List<MentorUser>?): Boolean =
                true

            override suspend fun createCall(): Flow<ApiResponse<List<MentorUserResponse>>> =
                remoteDataSource.getMentor(id, begda, endda)

            override suspend fun saveCallResult(data: List<MentorUserResponse>) {
                val list = DataMapperMentor.mapResponsetoEntities(data)
                localDataSource.insertAndDeleteMentor(list)

            }

            override suspend fun emptyDataBase() {
                localDataSource.deleteMentor()
            }

        }.asFlow()


}