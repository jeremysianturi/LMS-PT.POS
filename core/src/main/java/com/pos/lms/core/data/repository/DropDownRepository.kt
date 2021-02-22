package com.pos.lms.core.data.repository

import com.pos.lms.core.data.NetworkBoundResource
import com.pos.lms.core.data.Resource
import com.pos.lms.core.data.source.local.room.LocalDataSource
import com.pos.lms.core.data.source.remote.RemoteDataSource
import com.pos.lms.core.data.source.remote.network.ApiResponse
import com.pos.lms.core.data.source.remote.response.dropdown.CompanyResponse
import com.pos.lms.core.data.source.remote.response.dropdown.CompetencyResponse
import com.pos.lms.core.data.source.remote.response.dropdown.PLResponse
import com.pos.lms.core.data.source.remote.response.dropdown.TypeResponse
import com.pos.lms.core.domain.model.Company
import com.pos.lms.core.domain.model.Competency
import com.pos.lms.core.domain.model.PL
import com.pos.lms.core.domain.model.Type
import com.pos.lms.core.domain.repository.IDropDownRepository
import com.pos.lms.core.utils.AppExecutors
import com.pos.lms.core.helper.dataMapper.DataMapperCompany
import com.pos.lms.core.helper.dataMapper.DataMapperCompetency
import com.pos.lms.core.helper.dataMapper.DataMapperPL
import com.pos.lms.core.helper.dataMapper.DataMapperType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Muhammad Zaim Milzam on 08/02/21.
 * linkedin : Muhammad Zaim Milzam
 */

@Singleton
class DropDownRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : IDropDownRepository {

    override fun getCompetency(begda: String, enda: String): Flow<Resource<List<Competency>>> =

        object : NetworkBoundResource<List<Competency>, List<CompetencyResponse>>() {
            override fun loadFromDB(): Flow<List<Competency>> {
                return localDataSource.getCompetency().map {
                    DataMapperCompetency.mapEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<Competency>?): Boolean =
                true

            override suspend fun createCall(): Flow<ApiResponse<List<CompetencyResponse>>> =
                remoteDataSource.getCompetency(begda, enda)


            override suspend fun saveCallResult(data: List<CompetencyResponse>) {
                val competencyList = DataMapperCompetency.mapResponsesToEntities(data)
                localDataSource.insertCompetency(competencyList)
            }

        }.asFlow()

    override fun getPL(begda: String, enda: String): Flow<Resource<List<PL>>> =

        object : NetworkBoundResource<List<PL>, List<PLResponse>>() {
            override fun loadFromDB(): Flow<List<PL>> {
                return localDataSource.getPL().map {
                    DataMapperPL.mapEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<PL>?): Boolean =
                true

            override suspend fun createCall(): Flow<ApiResponse<List<PLResponse>>> =
                remoteDataSource.getPL(begda, enda)


            override suspend fun saveCallResult(data: List<PLResponse>) {
                val list = DataMapperPL.mapResponsesToEntities(data)
                localDataSource.insertPL(list)
            }

        }.asFlow()


    override fun getType(begda: String, enda: String): Flow<Resource<List<Type>>> =

        object : NetworkBoundResource<List<Type>, List<TypeResponse>>() {
            override fun loadFromDB(): Flow<List<Type>> {
                return localDataSource.getType().map {
                    DataMapperType.mapEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<Type>?): Boolean =
                true

            override suspend fun createCall(): Flow<ApiResponse<List<TypeResponse>>> =
                remoteDataSource.getType(begda, enda)

            override suspend fun saveCallResult(data: List<TypeResponse>) {
                val list = DataMapperType.mapResponsesToEntities(data)
                localDataSource.insertType(list)
            }

        }.asFlow()

    override fun getCompany(begda: String, enda: String): Flow<Resource<List<Company>>> =
        object : NetworkBoundResource<List<Company>, List<CompanyResponse>>() {
            override fun loadFromDB(): Flow<List<Company>> {
                return localDataSource.getCompany().map {
                    DataMapperCompany.mapEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<Company>?): Boolean =
                true

            override suspend fun createCall(): Flow<ApiResponse<List<CompanyResponse>>> =
                remoteDataSource.getCompany(begda, enda)

            override suspend fun saveCallResult(data: List<CompanyResponse>) {
                val list = DataMapperCompany.mapResponsesToEntities(data)
                localDataSource.insertCompany(list)
            }

        }.asFlow()


}