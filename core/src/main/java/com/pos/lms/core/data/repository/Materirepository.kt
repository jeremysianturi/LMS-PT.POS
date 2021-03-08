package com.pos.lms.core.data.repository

import com.pos.lms.core.data.NetworkBoundResourceWithDeleteLocalData
import com.pos.lms.core.data.Resource
import com.pos.lms.core.data.source.local.room.LocalDataSource
import com.pos.lms.core.data.source.remote.RemoteDataSource
import com.pos.lms.core.data.source.remote.network.ApiResponse
import com.pos.lms.core.data.source.remote.response.materi.MateriResponse
import com.pos.lms.core.domain.model.Materi
import com.pos.lms.core.domain.repository.IMateriRepository
import com.pos.lms.core.helper.dataMapper.DataMapperMateri
import com.pos.lms.core.utils.AppExecutors
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Muhammad Zaim Milzam on 10/02/21.
 * linkedin : Muhammad Zaim Milzam
 */

@Singleton
class Materirepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : IMateriRepository {
    override fun getMateri(begda: String, endda: String): Flow<Resource<List<Materi>>> =
        object : NetworkBoundResourceWithDeleteLocalData<List<Materi>, List<MateriResponse>>() {

            override fun loadFromDB(): Flow<List<Materi>> {
                return localDataSource.getMateri().map {
                    DataMapperMateri.mapEntitiestoDomain(it)
                }
            }

            override fun shouldFetch(data: List<Materi>?): Boolean =
                true

            override suspend fun createCall(): Flow<ApiResponse<List<MateriResponse>>> =
                remoteDataSource.getMateri(begda, endda)

            override suspend fun saveCallResult(data: List<MateriResponse>) {
                val list = DataMapperMateri.mapResponsetoEntities(data)
                localDataSource.insertMateri(list)
            }

            override suspend fun emptyDataBase() =
                localDataSource.deleteMateri()


        }.asFlow()

}