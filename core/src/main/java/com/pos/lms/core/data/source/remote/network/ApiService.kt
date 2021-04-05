package com.pos.lms.core.data.source.remote.network

import com.pos.lms.core.data.source.remote.post.*
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
import com.pos.lms.core.data.source.remote.response.student.session.absensi.AbsensiResponse
import com.pos.lms.core.data.source.remote.response.student.session.detailSchedule.*
import com.pos.lms.core.data.source.remote.response.student.session.mentoring.ListMentoringChatResponse
import com.pos.lms.core.data.source.remote.response.student.session.mentoring.ListMentoringDetailResponse
import com.pos.lms.core.data.source.remote.response.student.session.mentoring.ListMentoringResponse
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
    @GET("lms/api/android/curriculum-request?order[object_identifier]=DESC&per_page=9000000")
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
    @GET("lms/api/android/materi?order[object_identifier]=DESC&per_page=9000000")
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
    @GET("lms/api/android/forum?order[object_identifier]=DESC&per_page=9000000&forum_type_id=2")
    suspend fun getListInsight(
        @Query("begin_date_lte") begda: String,
        @Query("end_date_gte") endDa: String,
        @Query("batch_id") batchId: String,
    ): ListInsightResponse

    @POST("lms/api/forum")
    suspend fun deleteInsight(
        @Query("object_identifier") oid: String
    ): SubmitResponse


    // -> forum
    @GET("lms/api/android/forum?order[object_identifier]=DESC&per_page=9000000&forum_type_id=1")
    suspend fun getListForum(
        @Query("begin_date_lte") begda: String,
        @Query("end_date_gte") endDa: String,
        @Query("batch_id") batchId: String,
    ): ListForumResponse

    @Multipart
    @POST("lms/api/forum")
    suspend fun createForum(
        @Part("business_code") businessode: RequestBody,
        @Part("batch") batchid: RequestBody,
        @Part("owner") owner: RequestBody,
        @Part("forum_title") forumTitle: RequestBody,
        @Part("forum_text") forumText: RequestBody,
        @Part("forum_type") forumType: RequestBody,
        @Part("forum_image") forumImage: MultipartBody.Part,
        @Part("forum_time") forumTime: RequestBody,
        @Part("begin_date") beginDate: RequestBody,
        @Part("end_date") endDate: RequestBody,
    ): SubmitResponse

    @POST("lms/api/forum")
    suspend fun deleteForum(
        @Query("object_identifier") oid: String
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
    @GET("lms/api/android/session/learning-activity?order[begin_date]=ASC&limit&per_page=9000000")
    suspend fun getSessionList(
        @Query("begin_date_lte") begda: String,
        @Query("end_date_gte") endDa: String,
        @Query("batch_id") batchid: String,
    ): ListSessionListResponse

    // -> session -> schedule
    @GET("lms/api/schedule?order[BEGDA]=asc&per_page=9000000")
    suspend fun getSchedule(
        @Query("session[]") sessionId: String,
    ): ListScheduleResponse

    // -> session -> schedule -> detailschedule -> Materi
    @GET("lms/api/android/lmsrelation/schdl-mater?order[object_identifier]=DESC&relation=S003&per_page=9000000")
    suspend fun getMateriSchedule(
        @Query("begin_date_lte") begda: String,
        @Query("end_date_gte") endda: String,
        @Query("parent_id") parentId: String,
    ): ListMateriScheduleResponse

    // -> session -> schedule -> detailschedule -> Test
    @GET("lms/api/android/relation-question?order[object_identifier]=DESC&per_page=9000000")
    suspend fun getTestSchedule(
        @Query("begin_date_lte") begda: String,
        @Query("end_date_gte") endda: String,
        @Query("schedule_id") scheduleId: String,
    ): ListTestScheduleResponse

    // -> session -> schedule -> detailschedule -> Test -> Pertanyaan
    @GET("lms/api/android/lmsrelation-object/to-question?table_code[]=TSQST&relation[]=T001&otype[]=TSTCD&object[]=POSTEST&per_page=99999999&random=true")
    suspend fun getTestPertanyaan(
        @Query("begin_date_lte") begda: String,
        @Query("end_date_gte") endda: String,
//        @Query("schedule_id") scheduleId: String,
    ): ListTestPertanyaanResponse

    // -> session -> schedule -> detailschedule -> Test -> jawaban
    @GET("lms/api/testquestionchoice?order[SEQNO]=asc&per_page=9999")
    suspend fun getTestJawaban(
        @Query("begin_date_lte") begda: String,
        @Query("end_date_gte") endda: String,
        @Query("question[]") questionId: String,
    ): ListTestJawabanResponse

    // -> session -> schedule -> detailschedule -> Test -> jawaban -> post
    @POST("lms/api/testquestionparticipantchoice")
    suspend fun postTestJawaban(
        @Body testJawabanPost: TestJawabanPost
    ): SubmitResponse


    // -> session -> schedule -> detailschedule -> Quisioner
    @GET("lms/api/android/relation-questioner?order[object_identifier]=DESC&per_page=9000000")
    suspend fun getQuisionerSchedule(
        @Query("begin_date_lte") begda: String,
        @Query("end_date_gte") endda: String,
        @Query("schedule_id") scheduleId: String,
    ): ListQuisionerScheduleResponse

    //    -> session -> schedule -> detailschedule -> Quisioner -> quisionerAnswer
    @GET("lms/api/quesionerchoice?per_page=999")
    suspend fun getQuisionerAnswer(
        @Query("begin_date_lte") begda: String,
        @Query("end_date_gte") endda: String,
        @Query("quesioner[]") quesionerId: String,
    ): ListQuisionerAnswerResponse

    @POST("lms/api/quesionerparticipantchoice")
    suspend fun postQuisionerAnswer(
        @Body quisionerAnswers: QuisionerAnswerPost
    ): SubmitResponse

    //    -> session -> schedule -> detailschedule -> Quisioner -> quisionerPertanyaan
    @GET("lms/api/android/lmsrelation-object/to-quesioner?per_page=999")
    suspend fun getQuisionerPertanyaan(
        @Query("object") objects: String,
        @Query("tableCode") tableCode: String,
        @Query("relation") relation: String,
        @Query("otype") otype: String,
        @Query("begin_date_lte") begda: String,
        @Query("end_date_gte") endda: String,
    ): ListQuisionerPertanyaanResponse

    // -> session -> schedule -> detailschedule -> Trainer
    @GET("lms/api/android/lmsrelation/schdl-trainr?order[object_identifier]=DESC&relation=ST02")
    suspend fun getTrainerSchedule(
        @Query("begin_date_lte") begda: String,
        @Query("end_date_gte") endda: String,
        @Query("parent_id") paerentId: String,
    ): ListTrainerScheduleResponse

    // -> session -> schedule -> detailschedule -> Room
    @GET("lms/api/android/lmsrelation/schdl-rooms?order[object_identifier]=DESC&relation=S001")
    suspend fun getRoomSchedule(
        @Query("begin_date_lte") begda: String,
        @Query("end_date_gte") endda: String,
        @Query("parent_id") paerentId: String,
    ): ListRoomScheduleResponse

    // session -> schedule -> mentoring
    @GET("lms/api/android/mentoring-participant/session?order[begin_date]=asc&fn_otype=PARTI")
    suspend fun getMentoring(
        @Query("fn_begin_date") begda: String,
        @Query("fn_end_date") endda: String,
        @Query("fn_id") id: String,
        @Query("fn_session") paerentId: String,
    ): ListMentoringResponse

    // session -> schedule -> Detail mentoring
    @GET("lms/api/android/mentoring-participant/to-mentor?order[begin_date]=asc")
    suspend fun getDetailMentoring(
        @Query("begin_date_lte") begda: String,
        @Query("end_date_gte") endda: String,
        @Query("mentoring_id") mentoringid: String,
    ): ListMentoringDetailResponse

    // session -> schedule -> mentoring -> chat
    @GET("lms/api/android/mentoring-chat?order[object_identifier]=desc&per_page=9000000")
    suspend fun getChatMentoring(
        @Query("fn_mentoring_id") mentoringId: String,
    ): ListMentoringChatResponse

    // session -> schedule -> mentoring -> Postchat
    @POST("lms/api/mentoringchat")
    suspend fun postChatMentoring(
        @Body mentoringChatPost: MentoringChatPost
    ): SubmitResponse

    // session -> schedule -> mentoring -> chat
    @FormUrlEncoded
    @POST("lms/api/attendance/qr")
    suspend fun postAbsensi(
        @Field("parid") parid: String,
        @Field("sesid") sesid: String
    ): AbsensiResponse

    @PUT("lms/api/account")
    suspend fun postChangePassword(
        @Query("username") username: String,
        @Query("password") password: String,
    ): SubmitResponse

    @POST("lms/api/account")
    suspend fun postMateriStream(
        @Query("materi_id") materiId: String,
        @Query("action") action: String,
        @Query("current_activity") currentActivity: String,
        @Query("file_type") fileType: String,
    ): SubmitResponse

}
