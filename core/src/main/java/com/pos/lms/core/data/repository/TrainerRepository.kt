package com.pos.lms.core.data.repository

import com.pos.lms.core.data.NetworkBoundResourceWithDeleteLocalData
import com.pos.lms.core.data.Resource
import com.pos.lms.core.data.source.local.room.TrainerLocalDataSource
import com.pos.lms.core.data.source.remote.RemoteDataSource
import com.pos.lms.core.data.source.remote.network.ApiResponse
import com.pos.lms.core.data.source.remote.response.trainer.TrainerResponse
import com.pos.lms.core.domain.model.TrainerUser
import com.pos.lms.core.domain.repository.ITrainerRepository
import com.pos.lms.core.helper.dataMapper.DataMapperTrainerUser
import com.pos.lms.core.helper.dataMapper.DataMapperTrainerUser2
import com.pos.lms.core.helper.dataMapper.DataMapperTrainerUser3
import com.pos.lms.core.utils.AppExecutors
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TrainerRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: TrainerLocalDataSource,
    private val appExecutors: AppExecutors
) : ITrainerRepository {

    override fun getTrainerList(eventStatus: String): Flow<Resource<List<TrainerUser>>> =
        object :
            NetworkBoundResourceWithDeleteLocalData<List<TrainerUser>, List<TrainerResponse>>() {

            override fun loadFromDB(): Flow<List<TrainerUser>> {
                return localDataSource.getTrainer().map {
                    DataMapperTrainerUser.mapEntitiestoDomain(it)
                }
            }

            override fun shouldFetch(data: List<TrainerUser>?): Boolean =
                true

            override suspend fun createCall(): Flow<ApiResponse<List<TrainerResponse>>> =
                remoteDataSource.getTrainerList(eventStatus)

            override suspend fun saveCallResult(data: List<TrainerResponse>) {
                val list = DataMapperTrainerUser.mapResponsetoEntities(data)
                localDataSource.inserTrainer(list)

            }

            override suspend fun emptyDataBase() {
                localDataSource.deleteTrainer()
            }

        }.asFlow()

    override fun getUpcoming(eventStatus: String): Flow<Resource<List<TrainerUser>>> =
        object :
            NetworkBoundResourceWithDeleteLocalData<List<TrainerUser>, List<TrainerResponse>>() {

            override fun loadFromDB(): Flow<List<TrainerUser>> {
                return localDataSource.getUpcoming().map {
                    DataMapperTrainerUser2.mapEntitiestoDomain(it)
                }
            }

            override fun shouldFetch(data: List<TrainerUser>?): Boolean =
                true

            override suspend fun createCall(): Flow<ApiResponse<List<TrainerResponse>>> =
                remoteDataSource.getTrainerList(eventStatus)

            override suspend fun saveCallResult(data: List<TrainerResponse>) {
                val list = DataMapperTrainerUser2.mapResponsetoEntities(data)
                localDataSource.insertUpcoming(list)

            }

            override suspend fun emptyDataBase() {
                localDataSource.deletUpcoming()
            }

        }.asFlow()


    override fun getComplete(eventStatus: String): Flow<Resource<List<TrainerUser>>> =
        object :
            NetworkBoundResourceWithDeleteLocalData<List<TrainerUser>, List<TrainerResponse>>() {

            override fun loadFromDB(): Flow<List<TrainerUser>> {
                return localDataSource.getCompleted().map {
                    DataMapperTrainerUser3.mapEntitiestoDomain(it)
                }
            }

            override fun shouldFetch(data: List<TrainerUser>?): Boolean =
                true

            override suspend fun createCall(): Flow<ApiResponse<List<TrainerResponse>>> =
                remoteDataSource.getTrainerList(eventStatus)

            override suspend fun saveCallResult(data: List<TrainerResponse>) {
                val list = DataMapperTrainerUser3.mapResponsetoEntities(data)
                localDataSource.insertCompleted(list)

            }

            override suspend fun emptyDataBase() {
                localDataSource.deleteCompleted()
            }

        }.asFlow()


}