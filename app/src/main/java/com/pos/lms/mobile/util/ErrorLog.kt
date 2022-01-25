package com.pos.lms.mobile.util

import com.androidnetworking.error.ANError
import timber.log.Timber

object ErrorLog {

    fun errorLog(TAG: String, anError: ANError?, desc: String) {
        Timber.tag(TAG).e( "$desc : Error : $anError")
        Timber.tag(TAG).e( "$desc : ErrorCode : ${anError?.errorCode}")
        Timber.tag(TAG).e( "$desc : Body : ${anError?.errorBody}")
        Timber.tag(TAG).e( "$desc : Response : ${anError?.response}")
        Timber.tag(TAG).e( "$desc : Detail : ${anError?.errorDetail}")
    }

}