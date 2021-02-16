package com.pos.lms.core.data.source.remote.network

import com.pos.lms.core.data.source.remote.post.LoginPost
import com.pos.lms.core.data.source.remote.response.LoginResponse
import com.pos.lms.core.data.source.remote.response.parId.ItemParId
import retrofit2.http.*

/**
 * Created by Muhammad Zaim Milzam on 15/02/21.
 * linkedin : Muhammad Zaim Milzam
 */
interface ApiLogin {

    @POST("ldap/api/auth/login")
    @Headers("Content-Type: application/json;charset=UTF-8")
    suspend fun login(
        @Body loginPost: LoginPost
    ): LoginResponse

    @GET("lms/api/account?type[]=PARID")
    suspend fun getParId(@Header("Authorization") token: String): List<ItemParId>
}