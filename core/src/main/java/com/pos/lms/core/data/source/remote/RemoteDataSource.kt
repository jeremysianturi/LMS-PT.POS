package com.pos.lms.core.data.source.remote

import com.pos.lms.core.data.source.remote.network.ApiResponse
import com.pos.lms.core.data.source.remote.network.ApiService
import com.pos.lms.core.data.source.remote.post.CuriculumCreate
import com.pos.lms.core.data.source.remote.post.CuriculumUpdate
import com.pos.lms.core.data.source.remote.post.LoginPost
import com.pos.lms.core.data.source.remote.response.LoginResponse
import com.pos.lms.core.data.source.remote.response.SubmitResponse
import com.pos.lms.core.data.source.remote.response.curiculum.CuriculumResponse
import com.pos.lms.core.data.source.remote.response.dropdown.CompanyResponse
import com.pos.lms.core.data.source.remote.response.dropdown.CompetencyResponse
import com.pos.lms.core.data.source.remote.response.dropdown.PLResponse
import com.pos.lms.core.data.source.remote.response.dropdown.TypeResponse
import com.pos.lms.core.data.source.remote.response.materi.MateriResponse
import com.pos.lms.core.data.source.remote.response.parId.ItemParId
import com.pos.lms.core.data.source.remote.response.student.StudentResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Muhammad Zaim Milzam on 26/01/21.
 * linkedin : Muhammad Zaim Milzam
 */

@Singleton
class RemoteDataSource @Inject constructor(private val apiService: ApiService) {

    private val tag = RemoteDataSource::class.java.simpleName.toString()

    // --------------------------------------- login ----------------------------------------------
    suspend fun getLogin(loginPost: LoginPost): Flow<ApiResponse<LoginResponse>> {
        //get data from remote APi
        return flow {
            try {
                val response = apiService.login(loginPost)
                val data = response.accessToken
                if (data.isEmpty()) {
                    emit(ApiResponse.Empty)
                } else {
                    emit(ApiResponse.Success(response))
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
            }
        }.flowOn(Dispatchers.IO)

    }

    suspend fun getParId(token: String): Flow<ApiResponse<List<ItemParId>>> {
        //get data from remote api
        return flow {
            try {
                val response = apiService.getParId()
                val dataArray = response[0].accessToken
                if (dataArray.isNotEmpty()) {
                    emit(ApiResponse.Success(response))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
//                Timber.e("RemoteDataSource", e.toString())
                Timber.tag("RemoteDataSource").e(e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }

    // --------------------------------------- curiculum ----------------------------------------------
    suspend fun getCuriculum(
        begda: String,
        enda: String
    ): Flow<ApiResponse<List<CuriculumResponse>>> {
        return flow {
            try {
                val response = apiService.getCuriculum(begda, enda)
                val dataArray = response.data
                Timber.tag(tag).d("dataArray : $dataArray")
                if (dataArray.isNotEmpty()) {
                    Timber.tag(tag).d("Curiculumn success")
                    emit(ApiResponse.Success(response.data))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
            }
        }.flowOn(Dispatchers.IO)
    }

    suspend fun updateCuriculum(
        curiculumUpdate: CuriculumUpdate
    ): Flow<ApiResponse<SubmitResponse>> {
        return flow {
            try {
                val response = apiService.updateCuriculum(curiculumUpdate)
                val status = response.status
                if (status) {
                    emit(ApiResponse.Success(response))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
            }
        }.flowOn(Dispatchers.IO)
    }

    suspend fun createCuriculum(
        curiculumCreate: CuriculumCreate
    ): Flow<ApiResponse<SubmitResponse>> {
        return flow {
            try {
                val response = apiService.createCuriculum(curiculumCreate)
                val status = response.status
                if (status) {
                    emit(ApiResponse.Success(response))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
            }
        }.flowOn(Dispatchers.IO)
    }

    // --------------------------------------- curiculum ----------------------------------------------
    suspend fun getMateri(begda: String, endda: String): Flow<ApiResponse<List<MateriResponse>>> {
        return flow {
            try {
                val response = apiService.getMateri(begda, endda)
                val dataArray = response.data
                if (dataArray.isNotEmpty()){
                    emit(ApiResponse.Success(response.data))
                }else{
                    emit(ApiResponse.Empty)
                }
            }catch (e : Exception) {
                emit(ApiResponse.Error(e.toString()))
            }
        }.flowOn(Dispatchers.IO)
    }

 // --------------------------------------- Student ----------------------------------------------
    suspend fun getStudent(): Flow<ApiResponse<List<StudentResponse>>> {
        return flow {
            try {
                val response = apiService.getStudent()
                val dataArray = response.data
                if (dataArray.isNotEmpty()){
                    emit(ApiResponse.Success(response.data))
                }else{
                    emit(ApiResponse.Empty)
                }
            }catch (e : Exception) {
                emit(ApiResponse.Error(e.toString()))
            }
        }.flowOn(Dispatchers.IO)
    }

    // --------------------------------------- Dropdown ----------------------------------------------
    suspend fun getCompetency(
        begda: String,
        endda: String
    ): Flow<ApiResponse<List<CompetencyResponse>>> {
        return flow {
            try {
                val response = apiService.getcompetency(begda, endda)
                val dataArray = response.data
                Timber.tag(tag).d("competency : $dataArray")
                if (dataArray.isNotEmpty()) {
                    emit(ApiResponse.Success(response.data))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
            }
        }.flowOn(Dispatchers.IO)
    }

    suspend fun getPL(
        begda: String,
        endda: String
    ): Flow<ApiResponse<List<PLResponse>>> {
        return flow {
            try {
                val response = apiService.getPL(begda, endda)
                Timber.tag(tag).d("proficienciLevel : $response")
                val dataArray = response.data
                Timber.tag(tag).d(dataArray.toString())
                if (dataArray.isNotEmpty()) {
                    emit(ApiResponse.Success(response.data))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
            }
        }.flowOn(Dispatchers.IO)
    }

    suspend fun getType(
        begda: String,
        endda: String
    ): Flow<ApiResponse<List<TypeResponse>>> {
        return flow {
            try {
                val response = apiService.getType(begda, endda)
                val dataArray = response.data
                Timber.tag(tag).d(dataArray.toString())
                if (dataArray.isNotEmpty()) {
                    emit(ApiResponse.Success(response.data))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
            }
        }.flowOn(Dispatchers.IO)
    }

    suspend fun getCompany(
        begda: String,
        endda: String
    ): Flow<ApiResponse<List<CompanyResponse>>> {
        return flow {
            try {
                val response = apiService.getCompany(begda, endda)
                val dataArray = response.data
                Timber.tag(tag).d(dataArray.toString())
                if (dataArray.isNotEmpty()) {
                    emit(ApiResponse.Success(response.data))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
            }
        }.flowOn(Dispatchers.IO)
    }
}