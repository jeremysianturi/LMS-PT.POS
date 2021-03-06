package com.pos.lms.core.data.source.remote

import com.pos.lms.core.data.source.remote.network.ApiITMS
import com.pos.lms.core.data.source.remote.network.ApiLogin
import com.pos.lms.core.data.source.remote.network.ApiResponse
import com.pos.lms.core.data.source.remote.network.ApiService
import com.pos.lms.core.data.source.remote.post.*
import com.pos.lms.core.data.source.remote.response.LoginResponse
import com.pos.lms.core.data.source.remote.response.SubmitResponse
import com.pos.lms.core.data.source.remote.response.curiculum.CuriculumResponse
import com.pos.lms.core.data.source.remote.response.dropdown.CompanyResponse
import com.pos.lms.core.data.source.remote.response.dropdown.CompetencyResponse
import com.pos.lms.core.data.source.remote.response.dropdown.PLResponse
import com.pos.lms.core.data.source.remote.response.dropdown.TypeResponse
import com.pos.lms.core.data.source.remote.response.materi.MateriResponse
import com.pos.lms.core.data.source.remote.response.mentor.MentorUserResponse
import com.pos.lms.core.data.source.remote.response.parId.ItemParId
import com.pos.lms.core.data.source.remote.response.profile.AvatarResponse
import com.pos.lms.core.data.source.remote.response.roadmap.ECPResponse
import com.pos.lms.core.data.source.remote.response.roadmap.EventRoadmapResponse
import com.pos.lms.core.data.source.remote.response.student.StudentResponse
import com.pos.lms.core.data.source.remote.response.student.forum.ForumCommentResponse
import com.pos.lms.core.data.source.remote.response.student.forum.ForumResponse
import com.pos.lms.core.data.source.remote.response.student.forum.ListForumLikeResponse
import com.pos.lms.core.data.source.remote.response.student.insight.InsightListResponse
import com.pos.lms.core.data.source.remote.response.student.session.DetailSessionResponse
import com.pos.lms.core.data.source.remote.response.student.session.SessionListResponse
import com.pos.lms.core.data.source.remote.response.student.session.absensi.AbsensiResponse
import com.pos.lms.core.data.source.remote.response.student.session.detailSchedule.*
import com.pos.lms.core.data.source.remote.response.student.session.mentoring.MentoringChatResponse
import com.pos.lms.core.data.source.remote.response.student.session.mentoring.MentoringDetailResponse
import com.pos.lms.core.data.source.remote.response.student.session.mentoring.MentoringResponse
import com.pos.lms.core.data.source.remote.response.student.session.schedule.ScheduleResponse
import com.pos.lms.core.data.source.remote.response.trainer.TrainerResponse
import com.pos.lms.core.utils.ApiException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import okhttp3.MultipartBody
import okhttp3.RequestBody
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class RemoteDataSource @Inject constructor(
    private val apiService: ApiService,
    private val apiLogin: ApiLogin,
    private val apiITMS: ApiITMS
) {

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
            } catch (e: ApiException) {
//                val errorCode = e.toString().replace(regex = Regex("[^0-9]"), replacement = "")
                emit(ApiResponse.Error(e.toString()))
            }
        }.flowOn(Dispatchers.IO)

    }

    suspend fun getParId(typeId: String): Flow<ApiResponse<List<ItemParId>>> {
        //get data from remote api
        return flow {
            try {
                val response = apiService.getParId(typeId)
                val dataArray = response[0].accessToken
                if (dataArray.isNotEmpty()) {
                    emit(ApiResponse.Success(response))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: ApiException) {
                emit(ApiResponse.Error(e.toString()))
//                Timber.e("RemoteDataSource", e.toString())
                Timber.tag("RemoteDataSource").e(e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }

    // --------------------------------------- change Password ----------------------------------------------
    suspend fun postChangePassword(
        username: String,
        password: String
    ): Flow<ApiResponse<SubmitResponse>> {
        return flow {
            try {
                val response = apiService.postChangePassword(username, password)
                val dataArray = response.status
                if (dataArray) {
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
    suspend fun getCuriculum(
        begda: String,
        enda: String
    ): Flow<ApiResponse<List<CuriculumResponse>>> {
        return flow {
            try {
                val response = apiService.getCuriculum(begda, enda)
                val dataArray = response.data
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

    // --------------------------------------- roadmap ----------------------------------------------

    suspend fun getEventRoadmap(
        begda: String,
        endda: String
    ): Flow<ApiResponse<List<EventRoadmapResponse>>> {
        return flow {
            try {
                val response = apiITMS.eventRoadmap(begda, endda)
                val dataArray = response.data
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

    suspend fun getECPRotasi(
        eventCode: String,
        personalNumber: String,
        begda: String,
        endda: String
    ): Flow<ApiResponse<List<ECPResponse>>> {
        return flow {
            try {
                val response = apiITMS.ecpRotasi(begda, endda, eventCode, personalNumber)
                val dataArray = response.data
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

    suspend fun getECPPromosi(
        eventCode: String,
        personalNumber: String,
        begda: String,
        endda: String
    ): Flow<ApiResponse<List<ECPResponse>>> {
        return flow {
            try {
                val response = apiITMS.ecpPromosi(begda, endda, eventCode, personalNumber)
                val dataArray = response.data
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

    suspend fun getMCPRotasi(
        eventCode: String,
        personalNumber: String,
        begda: String,
        endda: String
    ): Flow<ApiResponse<List<ECPResponse>>> {
        return flow {
            try {
                val response = apiITMS.mcpRotasi(begda, endda, eventCode, personalNumber)
                val dataArray = response.data
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

    suspend fun getMCPPromosi(
        eventCode: String,
        personalNumber: String,
        begda: String,
        endda: String
    ): Flow<ApiResponse<List<ECPResponse>>> {
        return flow {
            try {
                val response = apiITMS.mcpPromosi(begda, endda, eventCode, personalNumber)
                val dataArray = response.data
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

    suspend fun getSCPRotasi(
        eventCode: String,
        personalNumber: String,
        begda: String,
        endda: String
    ): Flow<ApiResponse<List<ECPResponse>>> {
        return flow {
            try {
                val response = apiITMS.scpRotasi(begda, endda, eventCode, personalNumber)
                val dataArray = response.data
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

    suspend fun getSCPPromosi(
        eventCode: String,
        personalNumber: String,
        begda: String,
        endda: String
    ): Flow<ApiResponse<List<ECPResponse>>> {
        return flow {
            try {
                val response = apiITMS.scpPromosi(begda, endda, eventCode, personalNumber)
                val dataArray = response.data
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

    // --------------------------------------- Student ----------------------------------------------
    suspend fun getStudent(parid: String): Flow<ApiResponse<List<StudentResponse>>> {
        return flow {
            try {
                val response = apiService.getStudent(parid)
                val dataArray = response.data
                if (dataArray.isNotEmpty()) {
                    emit(ApiResponse.Success(response.data))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: ApiException) {
                emit(ApiResponse.Error(e.toString()))
            }
        }.flowOn(Dispatchers.IO)
    }

    suspend fun getDetailSession(eventId: String): Flow<ApiResponse<List<DetailSessionResponse>>> {
        return flow {
            try {
                val response = apiService.getDetailSession(eventId)
                val dataArray = response.data
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

    suspend fun getSessionList(
        batchId: String,
        begda: String,
        endda: String
    ): Flow<ApiResponse<List<SessionListResponse>>> {
        return flow {
            try {
                val response = apiService.getSessionList(begda, endda, batchId)
                val dataArray = response.data
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

    suspend fun getForumList(
        batchId: String,
        begda: String,
        endda: String
    ): Flow<ApiResponse<List<ForumResponse>>> {
        return flow {
            try {
                val response = apiService.getListForum(begda, endda, batchId)
                val dataArray = response.data
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

    suspend fun createForum(
        businesCode: RequestBody,
        batch: RequestBody,
        owner: RequestBody,
        tittle: RequestBody,
        desc: RequestBody,
        type: RequestBody,
        image: MultipartBody.Part,
        time: RequestBody,
        begda: RequestBody,
        endda: RequestBody
    ): Flow<ApiResponse<SubmitResponse>> {
        return flow {
            try {
                val response = apiService.createForum(
                    businesCode,
                    batch,
                    owner,
                    tittle,
                    desc,
                    type,
                    image,
                    time,
                    begda,
                    endda
                )
                val dataArray = response.message
                if (dataArray.isNotEmpty()) {
                    emit(ApiResponse.Success(response))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
            }
        }.flowOn(Dispatchers.IO)
    }

    suspend fun deteleForum(oid: String): Flow<ApiResponse<SubmitResponse>> {
        //get data from remote APi
        return flow {
            try {
                val response = apiService.deleteForum(oid)
                val data = response.message
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

    suspend fun getForumComment(
        forumId: String,
        begda: String,
        endda: String
    ): Flow<ApiResponse<List<ForumCommentResponse>>> {
        return flow {
            try {
                val response = apiService.getForumComment(begda, endda, forumId)
                val dataArray = response.data
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

    suspend fun postForumComment(forumCommnetPost: ForumCommnetPost): Flow<ApiResponse<SubmitResponse>> {
        //get data from remote APi
        return flow {
            try {
                val response = apiService.postForumComment(forumCommnetPost)
                val data = response.message
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

    suspend fun getForumLike(
        forumId: String,
    ): Flow<ApiResponse<ListForumLikeResponse>> {
        return flow {
            try {
                val response = apiService.getForumLike(forumId)
                if (response.data.isNotEmpty()) {
                    emit(ApiResponse.Success(response))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
            }
        }.flowOn(Dispatchers.IO)
    }


    suspend fun postForumLike(forumLikePost: ForumLikePost): Flow<ApiResponse<SubmitResponse>> {
        //get data from remote APi
        return flow {
            try {
                val response = apiService.postForumLike(forumLikePost)
                val data = response.message
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


    suspend fun getInsightList(
        batchId: String,
        begda: String,
        endda: String
    ): Flow<ApiResponse<List<InsightListResponse>>> {
        return flow {
            try {
                val response = apiService.getListInsight(begda, endda, batchId)
                val dataArray = response.data
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

    suspend fun deteleInsight(oid: String): Flow<ApiResponse<SubmitResponse>> {
        //get data from remote APi
        return flow {
            try {
                val response = apiService.deleteInsight(oid)
                val data = response.message
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

    suspend fun getScheduleList(
        sessionId: String,
    ): Flow<ApiResponse<List<ScheduleResponse>>> {
        return flow {
            try {
                val response = apiService.getSchedule(sessionId)
                val dataArray = response.data
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

    suspend fun getMateriSchedule(
        parentId: String, begda: String, endda: String
    ): Flow<ApiResponse<List<MateriScheduleResponse>>> {
        return flow {
            try {
                val response = apiService.getMateriSchedule(begda, endda, parentId)
                val dataArray = response.data
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

    suspend fun getTestSchedule(
        scheduleId: String, begda: String, endda: String
    ): Flow<ApiResponse<List<TestScheduleResponse>>> {
        return flow {
            try {
                val response = apiService.getTestSchedule(begda, endda, scheduleId)
                val dataArray = response.data
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

    suspend fun getTestPertanyaan(
        begda: String, endda: String
    ): Flow<ApiResponse<List<TestPertanyaanResponse>>> {
        return flow {
            try {
                val response = apiService.getTestPertanyaan(begda, endda)
                val dataArray = response.data
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

    suspend fun getTestJawaban(
        quesionId: String, begda: String, endda: String
    ): Flow<ApiResponse<List<TestJawabanResponse>>> {
        return flow {
            try {
                val response = apiService.getTestJawaban(begda, endda, quesionId)
                val dataArray = response.data
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

    suspend fun postTestAnswer(
        testJawabanPost: TestJawabanPost
    ): Flow<ApiResponse<SubmitResponse>> {
        return flow {
            try {
                val response = apiService.postTestJawaban(testJawabanPost)
                val dataArray = response.message
                if (dataArray.isNotEmpty()) {
                    emit(ApiResponse.Success(response))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
            }
        }.flowOn(Dispatchers.IO)
    }


    suspend fun getQuisionerSchedule(
        scheduleId: String, begda: String, endda: String
    ): Flow<ApiResponse<List<QuisionerScheduleResponse>>> {
        return flow {
            try {
                val response = apiService.getQuisionerSchedule(begda, endda, scheduleId)
                val dataArray = response.data
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

    suspend fun getQuisionerAnswer(
        quisionerId: String, begda: String, endda: String
    ): Flow<ApiResponse<List<QuisionerAnswerResponse>>> {
        return flow {
            try {
                val response = apiService.getQuisionerAnswer(begda, endda, quisionerId)
                val dataArray = response.data
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

    suspend fun postQuisionerAnswer(
        quisionerAnswerPost: QuisionerAnswerPost
    ): Flow<ApiResponse<SubmitResponse>> {
        return flow {
            try {
                val response = apiService.postQuisionerAnswer(quisionerAnswerPost)
                val dataArray = response.message
                if (dataArray.isNotEmpty()) {
                    emit(ApiResponse.Success(response))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
            }
        }.flowOn(Dispatchers.IO)
    }

    suspend fun getQuisionerPertanyaan(
        objects: String,
        tableCode: String,
        relation: String,
        otype: String,
        begda: String,
        endda: String
    ): Flow<ApiResponse<List<QuisionerPertanyaanResponse>>> {
        return flow {
            try {
                val response = apiService.getQuisionerPertanyaan(
                    objects,
                    tableCode,
                    relation,
                    otype,
                    begda,
                    endda
                )
                val dataArray = response.data
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

    suspend fun getTrainerSchedule(
        parentId: String, begda: String, endda: String
    ): Flow<ApiResponse<List<TrainerScheduleResponse>>> {
        return flow {
            try {
                val response = apiService.getTrainerSchedule(begda, endda, parentId)
                val dataArray = response.data
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

    suspend fun getRoomSchedule(
        parentId: String, begda: String, endda: String
    ): Flow<ApiResponse<List<RoomScheduleResponse>>> {
        return flow {
            try {
                val response = apiService.getRoomSchedule(begda, endda, parentId)
                val dataArray = response.data
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

    // --------------------------------------- Mentoring ----------------------------------------------

    suspend fun getMentoring(
        sessionId: String, id: String, begda: String, endda: String
    ): Flow<ApiResponse<List<MentoringResponse>>> {
        return flow {
            try {
                val response = apiService.getMentoring(begda, endda, id, sessionId)
                val dataArray = response.data
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

    suspend fun getMentoringDetail(
        mentoringId: String, begda: String, endda: String
    ): Flow<ApiResponse<List<MentoringDetailResponse>>> {
        return flow {
            try {
                val response = apiService.getDetailMentoring(begda, endda, mentoringId)
                val dataArray = response.data
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

    suspend fun postMentoringChat(
        mentoringChatPost: MentoringChatPost
    ): Flow<ApiResponse<SubmitResponse>> {
        return flow {
            try {
                val response = apiService.postChatMentoring(mentoringChatPost)
                val dataArray = response.message
                if (dataArray.isNotEmpty()) {
                    emit(ApiResponse.Success(response))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
            }
        }.flowOn(Dispatchers.IO)
    }

    suspend fun getMentoringChat(
        mentoringId: String
    ): Flow<ApiResponse<List<MentoringChatResponse>>> {
        return flow {
            try {
                val response = apiService.getChatMentoring(mentoringId)
                val dataArray = response.data
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

    // --------------------------------------- Absensi ----------------------------------------------
    suspend fun getAbsensi(
        parid: String,
        sessionId: String
    ): Flow<ApiResponse<AbsensiResponse>> {
        return flow {
            try {
                val response = apiService.postAbsensi(parid, sessionId)
                val dataArray = response.data
                Timber.d("dataAbsensi : $response")
                Timber.d("dataAbsensi : ${response.data}")
                if (dataArray!!.isNotEmpty()) {
                    emit(ApiResponse.Success(response))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
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

    /**
     *  --------------------- Role Mentor ---------------------
     */

    suspend fun getMentor(
        id: String,
        begda: String,
        endda: String
    ): Flow<ApiResponse<List<MentorUserResponse>>> {
        return flow {
            try {
                val response = apiService.getMentorList(begda, endda, id)
                val dataArray = response.data
                Timber.d("dataAvatar : $dataArray")
                if (dataArray.isNotEmpty()) {
                    Timber.d("masuk sukses")
                    emit(ApiResponse.Success(response.data))
                } else {
                    Timber.d("masuk kosong")
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                Timber.d("masuk error")
                emit(ApiResponse.Error(e.toString()))
            }
        }.flowOn(Dispatchers.IO)
    }


    /**
     *  --------------------- Role Trainer ---------------------
     */

    suspend fun getTrainerList(
        eventStatus: String,
    ): Flow<ApiResponse<List<TrainerResponse>>> {
        return flow {
            try {
                val response = apiService.getTrainerList(eventStatus)
                val dataArray = response.data

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


    /**
     *  --------------------- Profile ---------------------
     */

    suspend fun getAvatar(
        username: String,
    ): Flow<ApiResponse<List<AvatarResponse>>> {
        return flow {
            try {
                val response = apiService.getAvatar(username)
                val dataArray = response.data
                Timber.d("dataAvatar : $dataArray")
                if (dataArray.isNotEmpty()) {
                    Timber.d("masuk sukses")
                    emit(ApiResponse.Success(response.data))
                } else {
                    Timber.d("masuk kosong")
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                Timber.d("masuk error")
                emit(ApiResponse.Error(e.toString()))
            }
        }.flowOn(Dispatchers.IO)
    }


}