package com.pos.lms.core.data.source.remote.network

import com.pos.lms.core.data.source.remote.post.CuriculumCreate
import com.pos.lms.core.data.source.remote.post.CuriculumUpdate
import com.pos.lms.core.data.source.remote.post.ForumCommnetPost
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
import com.pos.lms.core.data.source.remote.response.student.forum.ListForumCommentResponse
import com.pos.lms.core.data.source.remote.response.student.forum.ListForumResponse
import com.pos.lms.core.data.source.remote.response.student.insight.ListInsightResponse
import com.pos.lms.core.data.source.remote.response.student.session.ListDetailSessionResponse
import com.pos.lms.core.data.source.remote.response.student.session.ListSessionListResponse
import com.pos.lms.core.data.source.remote.response.student.session.detailSchedule.ListMateriScheduleResponse
import com.pos.lms.core.data.source.remote.response.student.session.schedule.ListScheduleResponse
import okhttp3.MultipartBody
import okhttp3.RequestBody
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
    @GET("lms/api/myevent/peserta?curr_stat=01")
    suspend fun getStudent(
        @Query("parid") parId: String,
    ): ListStudentResponse


    // -> insight
    @GET("lms/api/forum?order[BEGDA]=asc&forum_type[]=2")
    suspend fun getListInsight(
        @Query("begin_date_lte") begda: String,
        @Query("end_date_gte") endDa: String,
        @Query("batch[]") batchId: String,
    ): ListInsightResponse

    // -> forum
    @GET("lms/api/android/forum?order[object_identifier]=DESC&per_page=99&forum_type_id=1")
    suspend fun getListForum(
        @Query("begin_date_lte") begda: String,
        @Query("end_date_gte") endDa: String,
        @Query("batch_id") batchId: String,
    ): ListForumResponse

    @Multipart
    @POST("lms/api/forum")
    suspend fun createForum(
        @Part("business_code") businessode : RequestBody,
        @Part("batch") batchid : RequestBody,
        @Part("owner") owner : RequestBody,
        @Part("forum_title") forumTitle : RequestBody,
        @Part("forum_text") forumText : RequestBody,
        @Part("forum_type") forumType : RequestBody,
        @Part("forum_image") forumImage : MultipartBody.Part,
        @Part("forum_time") forumTime : RequestBody,
        @Part("begin_date") beginDate : RequestBody,
        @Part("end_date") endDate : RequestBody,
        ): SubmitResponse

    // -> forum -> forum Comment
    @GET("lms/api/forumcomment")
    suspend fun getForumComment(
        @Query("begin_date_lte") begda: String,
        @Query("end_date_gte") endDa: String,
        @Query("forum[]") forumId: String,
    ): ListForumCommentResponse

    @POST("lms/api/forumcomment")
    suspend fun postForumComment(
        @Body forumCommnetPost: ForumCommnetPost
    ): SubmitResponse


    // -> session
    @GET("lms/api/android/session?per_page=10")
    suspend fun getDetailSession(
        @Query("event_id") eventId: String,
    ): ListDetailSessionResponse

    // -> list session
    @GET("lms/api/android/session/learning-activity?order[begin_date]=ASC&limit&per_page=99")
    suspend fun getSessionList(
        @Query("begin_date_lte") begda: String,
        @Query("end_date_gte") endDa: String,
        @Query("batch_id") batchid: String,
    ): ListSessionListResponse

    // -> session -> schedule
    @GET("lms/api/schedule?order[BEGDA]=asc")
    suspend fun getSchedule(
        @Query("session[]") sessionId: String,
    ): ListScheduleResponse

    // -> session -> schedule -> detail schedule
    @GET("lms/api/android/lmsrelation/schdl-mater?order[object_identifier]=DESC&relation=S003")
    suspend fun getMateriSchedule(
        @Query("begin_date_lte") begda: String,
        @Query("end_date_gte") endda: String,
        @Query("parent_id") parentId: String,
    ): ListMateriScheduleResponse


}
