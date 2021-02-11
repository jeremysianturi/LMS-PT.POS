package com.pos.lms.core.data.source.remote.network

import com.pos.lms.core.data.source.remote.post.CuriculumCreate
import com.pos.lms.core.data.source.remote.post.CuriculumUpdate
import com.pos.lms.core.data.source.remote.post.LoginPost
import com.pos.lms.core.data.source.remote.response.LoginResponse
import com.pos.lms.core.data.source.remote.response.SubmitResponse
import com.pos.lms.core.data.source.remote.response.curiculum.ListCuriculumResponse
import com.pos.lms.core.data.source.remote.response.dropdown.ListCompanyResponse
import com.pos.lms.core.data.source.remote.response.dropdown.ListCompetencyResponse
import com.pos.lms.core.data.source.remote.response.dropdown.ListPLResponse
import com.pos.lms.core.data.source.remote.response.dropdown.ListTypeResponse
import com.pos.lms.core.data.source.remote.response.materi.ListMateriResponse
import com.pos.lms.core.data.source.remote.response.parId.ItemParId
import com.pos.lms.core.data.source.remote.response.student.ListStudentResponse
import retrofit2.http.*

interface ApiService {

    @POST("ldap/api/auth/login")
    @Headers("Content-Type: application/json;charset=UTF-8")
    suspend fun login(
        @Body loginPost: LoginPost
    ): LoginResponse

    @GET("lms/api/account?type[]=PARID")
    suspend fun getParId(): List<ItemParId>


    //dropdown
    @GET("ldap/api/objects?object_type[]=CMPTY&per_page=999&business_code[]=*&business_code[]=POS")
    suspend fun getcompetency(
        @Query("begin_date_lte") begda: String,
        @Query("end_date_gte") endDa: String
    ): ListCompetencyResponse

    @GET("ldap/api/objects?object_type[]=PLCOD&per_page=999&business_code[]=*&business_code[]=POS")
    suspend fun getPL(
        @Query("begin_date_lte") begda: String,
        @Query("end_date_gte") endDa: String
    ): ListPLResponse

    @GET("ldap/api/objects?object_type[]=REQTY&per_page=999&business_code[]=*&business_code[]=POS")
    suspend fun getType(
        @Query("begin_date_lte") begda: String,
        @Query("end_date_gte") endDa: String
    ): ListTypeResponse

    @GET("hcis/api/company?")
    suspend fun getCompany(
        @Query("begin_date_lte") begda: String,
        @Query("end_date_gte") endDa: String
    ): ListCompanyResponse


    // curiculum
    @GET("lms/api/android/curriculum-request?order[object_identifier]=DESC")
    suspend fun getCuriculum(
        @Query("begin_date_lte") begda: String,
        @Query("end_date_gte") endDa: String,
    ): ListCuriculumResponse

    @PUT("lms/api/curriculumrequest")
    suspend fun updateCuriculum(
        @Body curiculumUpdate: CuriculumUpdate
    ): SubmitResponse

    @POST("lms/api/curriculumrequest")
    suspend fun createCuriculum(
        @Body curiculumCreate: CuriculumCreate
    ): SubmitResponse


    // materi
    @GET("lms/api/android/materi?order[object_identifier]=DESC")
    suspend fun getMateri(
        @Query("begin_date_lte") begda: String,
        @Query("end_date_gte") endDa: String,
    ): ListMateriResponse

    //student
    @GET("lms/api/myevent/peserta?curr_stat=01&parid=19777")
    suspend fun getStudent() : ListStudentResponse
}
