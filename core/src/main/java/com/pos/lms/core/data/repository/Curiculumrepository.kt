package com.pos.lms.core.data.repository

import com.pos.lms.core.data.NetworkBoundResource
import com.pos.lms.core.data.Resource
import com.pos.lms.core.data.source.local.room.LocalDataSource
import com.pos.lms.core.data.source.remote.RemoteDataSource
import com.pos.lms.core.data.source.remote.network.ApiResponse
import com.pos.lms.core.data.source.remote.post.CuriculumCreate
import com.pos.lms.core.data.source.remote.post.CuriculumUpdate
import com.pos.lms.core.data.source.remote.response.SubmitResponse
import com.pos.lms.core.data.source.remote.response.curiculum.CuriculumResponse
import com.pos.lms.core.domain.model.Curiculum
import com.pos.lms.core.domain.model.Submit
import com.pos.lms.core.domain.repository.ICuriculumRepository
import com.pos.lms.core.helper.dataMapper.DataMapperCuriculum
import com.pos.lms.core.helper.dataMapper.DataMapperSubmit
import com.pos.lms.core.utils.AppExecutors
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Muhammad Zaim Milzam on 08/02/21.
 * linkedin : Muhammad Zaim Milzam
 */

@Singleton
class Curiculumrepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : ICuriculumRepository {

    override fun getCuriculum(begda: String, enda: String): Flow<Resource<List<Curiculum>>> =
        object : NetworkBoundResource<List<Curiculum>, List<CuriculumResponse>>() {

            override fun loadFromDB(): Flow<List<Curiculum>> {
                return localDataSource.getCuriculum().map {
                    DataMapperCuriculum.mapEntitiestoDomain(it)
                }
            }

            override fun shouldFetch(data: List<Curiculum>?): Boolean =
                true

            override suspend fun createCall(): Flow<ApiResponse<List<CuriculumResponse>>> =
                remoteDataSource.getCuriculum(begda, enda)

            override suspend fun saveCallResult(data: List<CuriculumResponse>) {
                val list = DataMapperCuriculum.mapResponsetoEntities(data)
                localDataSource.insertCuriculum(list)
            }

        }.asFlow()

    override fun updateCuriculum(curiculumUpdate: CuriculumUpdate): Flow<Resource<Submit>> =
        object : NetworkBoundResource<Submit, SubmitResponse>() {

            override fun loadFromDB(): Flow<Submit> {
                return localDataSource.getSubmitResponse().map {
                    DataMapperSubmit.mapEntitiestoDomain(it)
                }
            }

            override fun shouldFetch(data: Submit?): Boolean =
                true

            override suspend fun createCall(): Flow<ApiResponse<SubmitResponse>> =
                remoteDataSource.updateCuriculum(curiculumUpdate)

            override suspend fun saveCallResult(data: SubmitResponse) {
                val list = DataMapperSubmit.mapResponsetoEntities(data)
                localDataSource.insertSubmitResponse(list)
            }

        }.asFlow()

    override fun createCuriculum(curiculumCreate: CuriculumCreate): Flow<Resource<Submit>> =
        object : NetworkBoundResource<Submit, SubmitResponse>() {

            override fun loadFromDB(): Flow<Submit> {
                return localDataSource.getSubmitResponse().map {
                    DataMapperSubmit.mapEntitiestoDomain(it)
                }
            }

            override fun shouldFetch(data: Submit?): Boolean =
                true

            override suspend fun createCall(): Flow<ApiResponse<SubmitResponse>> =
                remoteDataSource.createCuriculum(curiculumCreate)

            override suspend fun saveCallResult(data: SubmitResponse) {
                val list = DataMapperSubmit.mapResponsetoEntities(data)
                localDataSource.insertSubmitResponse(list)
            }

        }.asFlow()




}