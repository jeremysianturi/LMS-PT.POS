package com.pos.lms.core.data.repository

import com.pos.lms.core.data.NetworkBoundResource
import com.pos.lms.core.data.Resource
import com.pos.lms.core.data.source.local.room.LocalDataSource
import com.pos.lms.core.data.source.remote.RemoteDataSource
import com.pos.lms.core.data.source.remote.network.ApiResponse
import com.pos.lms.core.data.source.remote.response.student.StudentResponse
import com.pos.lms.core.domain.model.Student
import com.pos.lms.core.domain.repository.IStudentRepository
import com.pos.lms.core.utils.AppExecutors
import com.pos.lms.core.utils.dataMapper.DataMapperStudent
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

    override fun getStudent(): Flow<Resource<List<Student>>> =
        object : NetworkBoundResource<List<Student>, List<StudentResponse>>() {

            override fun loadFromDB(): Flow<List<Student>> {
                return localDataSource.getStudent().map {
                    DataMapperStudent.mapEntitiestoDomain(it)
                }
            }

            override fun shouldFetch(data: List<Student>?): Boolean =
                true

            override suspend fun createCall(): Flow<ApiResponse<List<StudentResponse>>> =
                remoteDataSource.getStudent()

            override suspend fun saveCallResult(data: List<StudentResponse>) {
                val list = DataMapperStudent.mapResponsetoEntities(data)
                localDataSource.insertStudent(list)
            }

        }.asFlow()


}