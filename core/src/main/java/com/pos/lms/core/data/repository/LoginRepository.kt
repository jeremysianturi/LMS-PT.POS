package com.pos.lms.core.data.repository

import com.pos.lms.core.data.NetworkBoundResource
import com.pos.lms.core.data.Resource
import com.pos.lms.core.data.source.local.room.LocalDataSource
import com.pos.lms.core.data.source.remote.RemoteDataSource
import com.pos.lms.core.data.source.remote.network.ApiResponse
import com.pos.lms.core.data.source.remote.post.LoginPost
import com.pos.lms.core.data.source.remote.response.LoginResponse
import com.pos.lms.core.data.source.remote.response.parId.ItemParId
import com.pos.lms.core.domain.model.Login
import com.pos.lms.core.domain.model.ParId
import com.pos.lms.core.domain.repository.ILoginRepository
import com.pos.lms.core.helper.dataMapper.DataMapperLogin
import com.pos.lms.core.helper.dataMapper.DataMapperParId
import com.pos.lms.core.utils.AppExecutors
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Muhammad Zaim Milzam on 26/01/21.
 * linkedin : Muhammad Zaim Milzam
 */
@Singleton
class LoginRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : ILoginRepository {

    override fun login(loginPost: LoginPost): Flow<Resource<Login>> =
        object : NetworkBoundResource<Login, LoginResponse>() {
            override fun loadFromDB(): Flow<Login> {
                return localDataSource.getLogin().map {
                    DataMapperLogin.mapEntitiestoDomain(it)
                }
            }

            override fun shouldFetch(data: Login?): Boolean =
                true // ganti dengan true jika ingin selalu mengambil data dari internet

            override suspend fun createCall(): Flow<ApiResponse<LoginResponse>> =
                remoteDataSource.getLogin(loginPost)

            override suspend fun saveCallResult(data: LoginResponse) {
                val tourismList = DataMapperLogin.mapResponsetoEntities(data)
                localDataSource.insertLogin(tourismList)
            }
        }.asFlow()


    override fun getParId(token : String): Flow<Resource<List<ParId>>> =
        object : NetworkBoundResource<List<ParId>, List<ItemParId>>() {
            override fun loadFromDB(): Flow<List<ParId>> {
                return localDataSource.getParId().map {
                    DataMapperParId.mapEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<ParId>?): Boolean =
                true

            override suspend fun createCall(): Flow<ApiResponse<List<ItemParId>>> =
                remoteDataSource.getParId(token)


            override suspend fun saveCallResult(data: List<ItemParId>) {
                val list = DataMapperParId.mapResponsesToEntities(data)
                localDataSource.insertParId(list)
            }

        }.asFlow()


}