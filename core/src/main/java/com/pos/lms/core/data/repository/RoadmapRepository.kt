package com.pos.lms.core.data.repository

import com.pos.lms.core.data.NetworkBoundResource
import com.pos.lms.core.data.Resource
import com.pos.lms.core.data.source.local.room.LocalDataSource
import com.pos.lms.core.data.source.remote.RemoteDataSource
import com.pos.lms.core.data.source.remote.network.ApiResponse
import com.pos.lms.core.data.source.remote.response.roadmap.ECPResponse
import com.pos.lms.core.data.source.remote.response.roadmap.EventRoadmapResponse
import com.pos.lms.core.domain.model.*
import com.pos.lms.core.domain.repository.IRoadmapRepository
import com.pos.lms.core.helper.dataMapper.*
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
class RoadmapRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : IRoadmapRepository {

    override fun getEventRoadmap(begda: String, endda: String): Flow<Resource<List<EventRoadmap>>> =
        object : NetworkBoundResource<List<EventRoadmap>, List<EventRoadmapResponse>>() {

            override fun loadFromDB(): Flow<List<EventRoadmap>> {
                return localDataSource.getEventRoadmap().map {
                    DataMapperEventRoadMap.mapEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<EventRoadmap>?): Boolean =
                true

            override suspend fun createCall(): Flow<ApiResponse<List<EventRoadmapResponse>>> =
                remoteDataSource.getEventRoadmap(begda, endda)

            override suspend fun saveCallResult(data: List<EventRoadmapResponse>) {
                val list = DataMapperEventRoadMap.mapResponsesToEntities(data)
                localDataSource.insertAndDeleteEventRoadmap(list)

            }

        }.asFlow()


    override fun getECPRotasi(
        eventCode: String,
        personalNumber: String,
        begda: String,
        endda: String
    ): Flow<Resource<List<ECPRotasi>>> =
        object : NetworkBoundResource<List<ECPRotasi>, List<ECPResponse>>() {

            override fun loadFromDB(): Flow<List<ECPRotasi>> {
                return localDataSource.getECPRotasi().map {
                    DataMapperECPRotasi.mapEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<ECPRotasi>?): Boolean =
                true

            override suspend fun createCall(): Flow<ApiResponse<List<ECPResponse>>> =
                remoteDataSource.getECPRotasi(eventCode, personalNumber, begda, endda)

            override suspend fun saveCallResult(data: List<ECPResponse>) {
                val list = DataMapperECPRotasi.mapResponsesToEntities(data)
                localDataSource.insertAndDeleteECPRotasi(list)

            }

        }.asFlow()


    override fun getECPPromosi(
        eventCode: String,
        personalNumber: String,
        begda: String,
        endda: String
    ): Flow<Resource<List<ECPPromosi>>> =
        object : NetworkBoundResource<List<ECPPromosi>, List<ECPResponse>>() {

            override fun loadFromDB(): Flow<List<ECPPromosi>> {
                return localDataSource.getECPPromosi().map {
                    DataMapperECPPromosi.mapEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<ECPPromosi>?): Boolean =
                true

            override suspend fun createCall(): Flow<ApiResponse<List<ECPResponse>>> =
                remoteDataSource.getECPPromosi(eventCode, personalNumber, begda, endda)

            override suspend fun saveCallResult(data: List<ECPResponse>) {
                val list = DataMapperECPPromosi.mapResponsesToEntities(data)
                localDataSource.insertAndDeleteECPPromosi(list)

            }

        }.asFlow()


    override fun getMCPRotasi(
        eventCode: String,
        personalNumber: String,
        begda: String,
        endda: String
    ): Flow<Resource<List<MCPRotasi>>> =
        object : NetworkBoundResource<List<MCPRotasi>, List<ECPResponse>>() {

            override fun loadFromDB(): Flow<List<MCPRotasi>> {
                return localDataSource.getMCPRotasi().map {
                    DataMapperMCPRotasi.mapEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<MCPRotasi>?): Boolean =
                true

            override suspend fun createCall(): Flow<ApiResponse<List<ECPResponse>>> =
                remoteDataSource.getMCPRotasi(eventCode, personalNumber, begda, endda)

            override suspend fun saveCallResult(data: List<ECPResponse>) {
                val list = DataMapperMCPRotasi.mapResponsesToEntities(data)
                localDataSource.insertAndDeleteMCPRotasi(list)

            }

        }.asFlow()


    override fun getMCPPromosi(
        eventCode: String,
        personalNumber: String,
        begda: String,
        endda: String
    ): Flow<Resource<List<MCPPromosi>>> =
        object : NetworkBoundResource<List<MCPPromosi>, List<ECPResponse>>() {

            override fun loadFromDB(): Flow<List<MCPPromosi>> {
                return localDataSource.getMCPPromosi().map {
                    DataMapperMCPPromosi.mapEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<MCPPromosi>?): Boolean =
                true

            override suspend fun createCall(): Flow<ApiResponse<List<ECPResponse>>> =
                remoteDataSource.getMCPPromosi(eventCode, personalNumber, begda, endda)

            override suspend fun saveCallResult(data: List<ECPResponse>) {
                val list = DataMapperMCPPromosi.mapResponsesToEntities(data)
                localDataSource.insertAndDeleteMCPPromosi(list)

            }

        }.asFlow()


    override fun getSCPRotasi(
        eventCode: String,
        personalNumber: String,
        begda: String,
        endda: String
    ): Flow<Resource<List<SCPRotasi>>> =
        object : NetworkBoundResource<List<SCPRotasi>, List<ECPResponse>>() {

            override fun loadFromDB(): Flow<List<SCPRotasi>> {
                return localDataSource.getSCPRotasi().map {
                    DataMapperSCPRotasi.mapEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<SCPRotasi>?): Boolean =
                true

            override suspend fun createCall(): Flow<ApiResponse<List<ECPResponse>>> =
                remoteDataSource.getSCPRotasi(eventCode, personalNumber, begda, endda)

            override suspend fun saveCallResult(data: List<ECPResponse>) {
                val list = DataMapperSCPRotasi.mapResponsesToEntities(data)
                localDataSource.insertAndDeleteSCPRotasi(list)

            }

        }.asFlow()


    override fun getSCPPromosi(
        eventCode: String,
        personalNumber: String,
        begda: String,
        endda: String
    ): Flow<Resource<List<SCPPromosi>>> =
        object : NetworkBoundResource<List<SCPPromosi>, List<ECPResponse>>() {

            override fun loadFromDB(): Flow<List<SCPPromosi>> {
                return localDataSource.getSCPPromosi().map {
                    DataMapperSCPPromosi.mapEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<SCPPromosi>?): Boolean =
                true

            override suspend fun createCall(): Flow<ApiResponse<List<ECPResponse>>> =
                remoteDataSource.getSCPPromosi(eventCode, personalNumber, begda, endda)

            override suspend fun saveCallResult(data: List<ECPResponse>) {
                val list = DataMapperSCPPromosi.mapResponsesToEntities(data)
                localDataSource.insertAndDeleteSCPPromosi(list)

            }

        }.asFlow()


}