package com.pos.lms.core.data

import com.pos.lms.core.data.source.remote.network.ApiResponse
import kotlinx.coroutines.flow.*

abstract class NetworkBoundResourceRemoteOnly<RequestType> {

    private var result: Flow<Resource<RequestType>> = flow {
        emit(Resource.Loading())
        when (val apiResponse = createCall().first()) {
            is ApiResponse.Success -> {
                emitAll(loadFromDB().map { Resource.Success(it) })
            }
            is ApiResponse.Empty -> {
                emitAll(loadFromDB().map { Resource.Success(it) })
            }
            is ApiResponse.Error -> {
                onFetchFailed()
                emit(Resource.Error<RequestType>(apiResponse.errorMessage))
            }
        }

//        /// batas lama
//        val dbSource = loadFromDB().first()
//        if (shouldFetch(dbSource)) {
//            emit(Resource.Loading())
//            when (val apiResponse = createCall().first()) {
//                is ApiResponse.Success -> {
//                    saveCallResult(apiResponse.data)
//                    emitAll(loadFromDB().map { Resource.Success(it) })
//                }
//                is ApiResponse.Empty -> {
//                    emitAll(loadFromDB().map { Resource.Success(it) })
//                }
//                is ApiResponse.Error -> {
//                    onFetchFailed()
//                    emit(Resource.Error<ResultType>(apiResponse.errorMessage))
//                }
//            }
//        } else {
//            emitAll(loadFromDB().map { Resource.Success(it) })
//        }
    }

    protected open fun onFetchFailed() {}

    protected abstract fun loadFromDB(): Flow<RequestType>

//    protected abstract fun shouldFetch(data: ResultType?): Boolean

    protected abstract suspend fun createCall(): Flow<ApiResponse<RequestType>>

    protected abstract suspend fun saveCallResult(data: RequestType)

    fun asFlow(): Flow<Resource<RequestType>> = result

}