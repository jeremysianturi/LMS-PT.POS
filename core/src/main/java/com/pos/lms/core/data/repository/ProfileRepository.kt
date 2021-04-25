package com.pos.lms.core.data.repository

import com.pos.lms.core.data.NetworkBoundResourceWithDeleteLocalData
import com.pos.lms.core.data.Resource
import com.pos.lms.core.data.source.local.room.LocalDataSource
import com.pos.lms.core.data.source.remote.RemoteDataSource
import com.pos.lms.core.data.source.remote.network.ApiResponse
import com.pos.lms.core.data.source.remote.response.profile.AvatarResponse
import com.pos.lms.core.domain.model.Avatar
import com.pos.lms.core.domain.repository.IProfileRepository
import com.pos.lms.core.helper.dataMapper.DataMapperAvatar
import com.pos.lms.core.utils.AppExecutors
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Muhammad Zaim Milzam on 22/04/21.
 * linkedin : Muhammad Zaim Milzam
 */

@Singleton
class ProfileRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : IProfileRepository {

    override fun getAvatar(userName: String): Flow<Resource<List<Avatar>>> =
        object : NetworkBoundResourceWithDeleteLocalData<List<Avatar>, List<AvatarResponse>>() {

            override fun loadFromDB(): Flow<List<Avatar>> {
                return localDataSource.getAvatar().map {
                    DataMapperAvatar.mapEntitiestoDomain(it)
                }
            }

            override fun shouldFetch(data: List<Avatar>?): Boolean =
                true

            override suspend fun createCall(): Flow<ApiResponse<List<AvatarResponse>>> =
                remoteDataSource.getAvatar(userName)

            override suspend fun saveCallResult(data: List<AvatarResponse>) {
                val list = DataMapperAvatar.mapResponsetoEntities(data)
                localDataSource.insertAndDeleteAvatar(list)
            }

            override suspend fun emptyDataBase() =
                localDataSource.deleteAvatar()

        }.asFlow()


}