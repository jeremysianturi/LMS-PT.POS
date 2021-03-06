package com.pos.lms.core.data.repository

import com.pos.lms.core.data.NetworkBoundResource
import com.pos.lms.core.data.NetworkBoundResourceWithDeleteLocalData
import com.pos.lms.core.data.Resource
import com.pos.lms.core.data.source.local.room.LocalDataSource
import com.pos.lms.core.data.source.remote.RemoteDataSource
import com.pos.lms.core.data.source.remote.network.ApiResponse
import com.pos.lms.core.data.source.remote.post.*
import com.pos.lms.core.data.source.remote.response.SubmitResponse
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
import com.pos.lms.core.domain.model.*
import com.pos.lms.core.domain.repository.IStudentRepository
import com.pos.lms.core.helper.dataMapper.*
import com.pos.lms.core.utils.AppExecutors
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import okhttp3.MultipartBody
import okhttp3.RequestBody
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class StudentRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : IStudentRepository {

    override fun getPagination(): Flow<Pagination> {
        return localDataSource.getPagintaion().map {
            DataMapperPagination.mapEntitiestoDomain(it)
        }
    }

    override fun getStudent(parId: String): Flow<Resource<List<Student>>> =
        object : NetworkBoundResourceWithDeleteLocalData<List<Student>, List<StudentResponse>>() {

            override fun loadFromDB(): Flow<List<Student>> {
                return localDataSource.getStudent().map {
                    DataMapperStudent.mapEntitiestoDomain(it)
                }
            }

            override fun shouldFetch(data: List<Student>?): Boolean =
                true

            override suspend fun createCall(): Flow<ApiResponse<List<StudentResponse>>> =
                remoteDataSource.getStudent(parId)

            override suspend fun saveCallResult(data: List<StudentResponse>) {
                val list = DataMapperStudent.mapResponsetoEntities(data)
                localDataSource.insertStudent(list)

            }

            override suspend fun emptyDataBase() {
                localDataSource.deleteStudent()
            }

        }.asFlow()

    override fun getDetailSession(eventId: String): Flow<Resource<List<DetailSession>>> =
        object : NetworkBoundResource<List<DetailSession>, List<DetailSessionResponse>>() {
            override fun loadFromDB(): Flow<List<DetailSession>> {
                return localDataSource.getDetailSession().map {
                    DataMapperDetailSession.mapEntitiestoDomain(it)
                }
            }

            override fun shouldFetch(data: List<DetailSession>?): Boolean =
                true

            override suspend fun createCall(): Flow<ApiResponse<List<DetailSessionResponse>>> =
                remoteDataSource.getDetailSession(eventId)

            override suspend fun saveCallResult(data: List<DetailSessionResponse>) {
                val list = DataMapperDetailSession.mapResponsetoEntities(data)
                localDataSource.insertDetailSession(list)
            }

        }.asFlow()

    override fun getSessionList(
        batchId: String,
        begda: String,
        endda: String
    ): Flow<Resource<List<SessionList>>> =
        object : NetworkBoundResource<List<SessionList>, List<SessionListResponse>>() {
            override fun loadFromDB(): Flow<List<SessionList>> {
                return localDataSource.getSessionList().map {
                    DataMapperSessionList.mapEntitiestoDomain(it)
                }
            }

            override fun shouldFetch(data: List<SessionList>?): Boolean =
                true

            override suspend fun createCall(): Flow<ApiResponse<List<SessionListResponse>>> =
                remoteDataSource.getSessionList(batchId, begda, endda)

            override suspend fun saveCallResult(data: List<SessionListResponse>) {
                val list = DataMapperSessionList.mapResponsetoEntities(data)
                localDataSource.insertSessionList(list)
            }

        }.asFlow()

    override fun getForumList(
        batchId: String,
        begda: String,
        endda: String
    ): Flow<Resource<List<ForumList>>> =
        object : NetworkBoundResourceWithDeleteLocalData<List<ForumList>, List<ForumResponse>>() {
            override fun loadFromDB(): Flow<List<ForumList>> {
                return localDataSource.getForumList().map {
                    DataMapperForum.mapEntitiestoDomain(it)
                }
            }

            override fun shouldFetch(data: List<ForumList>?): Boolean =
                true

            override suspend fun createCall(): Flow<ApiResponse<List<ForumResponse>>> =
                remoteDataSource.getForumList(batchId, begda, endda)

            override suspend fun saveCallResult(data: List<ForumResponse>) {
                val list = DataMapperForum.mapResponsetoEntities(data)
                localDataSource.insertForumList(list)
            }

            override suspend fun emptyDataBase() {
                localDataSource.deleteForumList()
            }

        }.asFlow()

    override fun getSearchForum(search: String): Flow<List<ForumList>> {
        return localDataSource.getSearchForum(search).map {
            DataMapperForum.mapEntitiestoDomain(it)
        }

    }

    override fun getOwnerForum(owner: String): Flow<List<ForumList>> {
        return localDataSource.getMyForum(owner).map {
            DataMapperForum.mapEntitiestoDomain(it)
        }

    }

    override fun createForum(
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
    ): Flow<Resource<Submit>> =
        object : NetworkBoundResource<Submit, SubmitResponse>() {

            override fun loadFromDB(): Flow<Submit> {
                return localDataSource.getSubmitResponse().map {
                    DataMapperSubmit.mapEntitiestoDomain(it)
                }
            }

            override fun shouldFetch(data: Submit?): Boolean =
                true

            override suspend fun createCall(): Flow<ApiResponse<SubmitResponse>> =
                remoteDataSource.createForum(
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

            override suspend fun saveCallResult(data: SubmitResponse) {
                val list = DataMapperSubmit.mapResponsetoEntities(data)
                localDataSource.insertSubmitResponse(list)
            }

        }.asFlow()

    override fun deteleForum(oid: String): Flow<Resource<Submit>> =
        object : NetworkBoundResource<Submit, SubmitResponse>() {

            override fun loadFromDB(): Flow<Submit> {
                return localDataSource.getSubmitResponse().map {
                    DataMapperSubmit.mapEntitiestoDomain(it)
                }
            }

            override fun shouldFetch(data: Submit?): Boolean =
                true

            override suspend fun createCall(): Flow<ApiResponse<SubmitResponse>> =
                remoteDataSource.deteleForum(oid)

            override suspend fun saveCallResult(data: SubmitResponse) {
                val list = DataMapperSubmit.mapResponsetoEntities(data)
                localDataSource.insertSubmitResponse(list)
            }

        }.asFlow()


    override fun getForumComment(
        forumId: String,
        begda: String,
        endda: String
    ): Flow<Resource<List<ForumComment>>> =
        object : NetworkBoundResource<List<ForumComment>, List<ForumCommentResponse>>() {
            override fun loadFromDB(): Flow<List<ForumComment>> {
                return localDataSource.getForumComment().map {
                    DataMapperForumComment.mapEntitiestoDomain(it)
                }
            }

            override fun shouldFetch(data: List<ForumComment>?): Boolean =
                true

            override suspend fun createCall(): Flow<ApiResponse<List<ForumCommentResponse>>> =
                remoteDataSource.getForumComment(forumId, begda, endda)

            override suspend fun saveCallResult(data: List<ForumCommentResponse>) {
                val list = DataMapperForumComment.mapResponsetoEntities(data)
                localDataSource.insertForumComment(list)
            }

        }.asFlow()

    override fun postForumComment(
        forumCommnetPost: ForumCommnetPost
    ): Flow<Resource<Submit>> =
        object : NetworkBoundResource<Submit, SubmitResponse>() {

            override fun loadFromDB(): Flow<Submit> {
                return localDataSource.getSubmitResponse().map {
                    DataMapperSubmit.mapEntitiestoDomain(it)
                }
            }

            override fun shouldFetch(data: Submit?): Boolean =
                true

            override suspend fun createCall(): Flow<ApiResponse<SubmitResponse>> =
                remoteDataSource.postForumComment(forumCommnetPost)

            override suspend fun saveCallResult(data: SubmitResponse) {
                val list = DataMapperSubmit.mapResponsetoEntities(data)
                localDataSource.insertSubmitResponse(list)
            }

        }.asFlow()

    override fun postForumLike(forumLikePost: ForumLikePost): Flow<Resource<Submit>> =
        object : NetworkBoundResource<Submit, SubmitResponse>() {
            override fun loadFromDB(): Flow<Submit> {
                return localDataSource.getSubmitResponse().map {
                    DataMapperSubmit.mapEntitiestoDomain(it)
                }
            }

            override fun shouldFetch(data: Submit?): Boolean =
                true

            override suspend fun createCall(): Flow<ApiResponse<SubmitResponse>> =
                remoteDataSource.postForumLike(forumLikePost)

            override suspend fun saveCallResult(data: SubmitResponse) {
                val list = DataMapperSubmit.mapResponsetoEntities(data)
                localDataSource.insertSubmitResponse(list)
            }

        }.asFlow()


    override fun getForumLike(forumId: String): Flow<Resource<List<ForumLike>>> =
        object :
            NetworkBoundResourceWithDeleteLocalData<List<ForumLike>, ListForumLikeResponse>() {
            override fun loadFromDB(): Flow<List<ForumLike>> {
                return localDataSource.getForumLike().map {
                    DataMapperForumLike.mapEntitiestoDomain(it)
                }
            }

            override fun shouldFetch(data: List<ForumLike>?): Boolean =
                true

            override suspend fun createCall(): Flow<ApiResponse<ListForumLikeResponse>> =
                remoteDataSource.getForumLike(forumId)

            override suspend fun saveCallResult(data: ListForumLikeResponse) {
                val list = DataMapperForumLike.mapResponsetoEntities(data.data)
                val listPagination =
                    DataMapperPagination.mapResponsetoEntities(data.metaResponse.paginationResponse)
                localDataSource.insertForumLike(list)
                localDataSource.insertPagination(listPagination)
            }

            override suspend fun emptyDataBase() {
                localDataSource.deleteForumLike()
                localDataSource
            }

        }.asFlow()


    override fun getInsightList(
        batchId: String,
        begda: String,
        endda: String
    ): Flow<Resource<List<InsightList>>> =
        object :
            NetworkBoundResourceWithDeleteLocalData<List<InsightList>, List<InsightListResponse>>() {
            override fun loadFromDB(): Flow<List<InsightList>> {
                return localDataSource.getInsightList().map {
                    DataMapperInsightList.mapEntitiestoDomain(it)
                }
            }

            override fun shouldFetch(data: List<InsightList>?): Boolean =
                true

            override suspend fun createCall(): Flow<ApiResponse<List<InsightListResponse>>> =
                remoteDataSource.getInsightList(batchId, begda, endda)

            override suspend fun saveCallResult(data: List<InsightListResponse>) {
                val list = DataMapperInsightList.mapResponsetoEntities(data)
                localDataSource.insertInsightList(list)
            }

            override suspend fun emptyDataBase() {
                localDataSource.deleteInsightList()
            }

        }.asFlow()

    override fun getSearchInsight(search: String): Flow<List<InsightList>> {
        return localDataSource.getSearchInsight(search).map {
            DataMapperInsightList.mapEntitiestoDomain(it)
        }

    }

    override fun getOwnerInsight(owner: String): Flow<List<InsightList>> {
        return localDataSource.getMyInsight(owner).map {
            DataMapperInsightList.mapEntitiestoDomain(it)
        }
    }

    override fun deteleInsight(oid: String): Flow<Resource<Submit>> =
        object : NetworkBoundResource<Submit, SubmitResponse>() {

            override fun loadFromDB(): Flow<Submit> {
                return localDataSource.getSubmitResponse().map {
                    DataMapperSubmit.mapEntitiestoDomain(it)
                }
            }

            override fun shouldFetch(data: Submit?): Boolean =
                true

            override suspend fun createCall(): Flow<ApiResponse<SubmitResponse>> =
                remoteDataSource.deteleInsight(oid)

            override suspend fun saveCallResult(data: SubmitResponse) {
                val list = DataMapperSubmit.mapResponsetoEntities(data)
                localDataSource.insertSubmitResponse(list)
            }

        }.asFlow()


    override fun getSchedule(sessionId: String): Flow<Resource<List<Schedule>>> =
        object : NetworkBoundResource<List<Schedule>, List<ScheduleResponse>>() {
            override fun loadFromDB(): Flow<List<Schedule>> {
                return localDataSource.getSchedule().map {
                    DataMapperSchedule.mapEntitiestoDomain(it)
                }
            }

            override fun shouldFetch(data: List<Schedule>?): Boolean =
                true

            override suspend fun createCall(): Flow<ApiResponse<List<ScheduleResponse>>> =
                remoteDataSource.getScheduleList(sessionId)

            override suspend fun saveCallResult(data: List<ScheduleResponse>) {
                val list = DataMapperSchedule.mapResponsetoEntities(data)
                localDataSource.insertSchedule(list)
            }

        }.asFlow()

    override fun getMateriSchedule(
        parentId: String,
        begda: String,
        endda: String
    ): Flow<Resource<List<MateriSchedule>>> =
        object : NetworkBoundResource<List<MateriSchedule>, List<MateriScheduleResponse>>() {
            override fun loadFromDB(): Flow<List<MateriSchedule>> {
                return localDataSource.getMateriSchedule().map {
                    DataMapperMateriSchedule.mapEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<MateriSchedule>?): Boolean =
                true

            override suspend fun createCall(): Flow<ApiResponse<List<MateriScheduleResponse>>> =
                remoteDataSource.getMateriSchedule(parentId, begda, endda)

            override suspend fun saveCallResult(data: List<MateriScheduleResponse>) {
                val list = DataMapperMateriSchedule.mapResponsesToEntities(data)
                localDataSource.insertMateriSchedule(list)
            }

        }.asFlow()

    override fun getTestSchedule(
        scheduleId: String,
        begda: String,
        endda: String
    ): Flow<Resource<List<TestSchedule>>> =
        object : NetworkBoundResource<List<TestSchedule>, List<TestScheduleResponse>>() {
            override fun loadFromDB(): Flow<List<TestSchedule>> {
                return localDataSource.getTestSchedule().map {
                    DataMapperTestSchedule.mapEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<TestSchedule>?): Boolean =
                true

            override suspend fun createCall(): Flow<ApiResponse<List<TestScheduleResponse>>> =
                remoteDataSource.getTestSchedule(scheduleId, begda, endda)

            override suspend fun saveCallResult(data: List<TestScheduleResponse>) {
                val list = DataMapperTestSchedule.mapResponsesToEntities(data)
                localDataSource.insertTestSchedule(list)
            }

        }.asFlow()

    override fun getTestPertanyaan(
        begda: String,
        endda: String
    ): Flow<Resource<List<TestPertanyaan>>> =
        object :
            NetworkBoundResourceWithDeleteLocalData<List<TestPertanyaan>, List<TestPertanyaanResponse>>() {
            override fun loadFromDB(): Flow<List<TestPertanyaan>> {
                return localDataSource.getTestPertanyaan().map {
                    DataMapperTestPertanyaan.mapEntitiesToDomain(it)
                }

            }

            override fun shouldFetch(data: List<TestPertanyaan>?): Boolean =
                true

            override suspend fun createCall(): Flow<ApiResponse<List<TestPertanyaanResponse>>> =
                remoteDataSource.getTestPertanyaan(begda, endda)

            override suspend fun saveCallResult(data: List<TestPertanyaanResponse>) {
                val list = DataMapperTestPertanyaan.mapResponsesToEntities(data)
                localDataSource.insertTestPertanyaan(list)
            }

            override suspend fun emptyDataBase() {
                localDataSource.deleteTestPertanyaan()
            }

        }.asFlow()

    override fun getTestPertanyaanWithId(id: Long): Flow<List<TestPertanyaan>> {
        return localDataSource.getTestPertanyaanWithId(id)
            .map { DataMapperTestPertanyaan.mapEntitiesToDomain(it) }

    }

    override fun getTestJawaban(
        questionId: String,
        begda: String,
        endda: String
    ): Flow<Resource<List<TestJawaban>>> =
        object :
            NetworkBoundResourceWithDeleteLocalData<List<TestJawaban>, List<TestJawabanResponse>>() {
            override fun loadFromDB(): Flow<List<TestJawaban>> {
                return localDataSource.getTestAnswer().map {
                    DataMapperTestJawaban.mapEntitiesToDomain(it)
                }

            }

            override fun shouldFetch(data: List<TestJawaban>?): Boolean =
                true

            override suspend fun createCall(): Flow<ApiResponse<List<TestJawabanResponse>>> =
                remoteDataSource.getTestJawaban(questionId, begda, endda)

            override suspend fun saveCallResult(data: List<TestJawabanResponse>) {
                val list = DataMapperTestJawaban.mapResponsesToEntities(data)
                localDataSource.insertTestAnswer(list)
            }

            override suspend fun emptyDataBase() {
                localDataSource.deleteTestnswer()
            }

        }.asFlow()


    override fun setCheckedTestJawaban(answer: TestJawaban, state: Boolean) {
        val answerEntity = DataMapperTestJawaban.mapDomainToEntity(answer)
        appExecutors.diskIO()
            .execute { localDataSource.setCheckedTestAnswer(answerEntity, state) }
    }

    override fun getCheckedTestJawaban(): Flow<List<TestJawaban>> {
        return localDataSource.getCheckedTestAnswer().map {
            DataMapperTestJawaban.mapEntitiesToDomain(it)
        }

    }

    override fun getOnlyCheckedTestJawaban(): Flow<List<String>> {
        return localDataSource.getOnlyTestCheckedAnswer()
    }

    override fun postTestJawaban(quisionerAnswerPost: QuisionerAnswerPost): Flow<Resource<Submit>> {
        TODO("Not yet implemented")
    }


    override fun getQuisionerSchedule(
        scheduleId: String,
        begda: String,
        endda: String
    ): Flow<Resource<List<QuisionerSchedule>>> =
        object : NetworkBoundResource<List<QuisionerSchedule>, List<QuisionerScheduleResponse>>() {
            override fun loadFromDB(): Flow<List<QuisionerSchedule>> {
                return localDataSource.getQuisionerSchedule().map {
                    DataMapperQuisionerSchedule.mapEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<QuisionerSchedule>?): Boolean =
                true

            override suspend fun createCall(): Flow<ApiResponse<List<QuisionerScheduleResponse>>> =
                remoteDataSource.getQuisionerSchedule(scheduleId, begda, endda)

            override suspend fun saveCallResult(data: List<QuisionerScheduleResponse>) {
                val list = DataMapperQuisionerSchedule.mapResponsesToEntities(data)
                localDataSource.insertQuisionerSchedule(list)
            }

        }.asFlow()

    override fun getQuisionerAnswer(
        quisionerId: String,
        begda: String,
        endda: String
    ): Flow<Resource<List<QuisionerAnswer>>> =
        object :
            NetworkBoundResourceWithDeleteLocalData<List<QuisionerAnswer>, List<QuisionerAnswerResponse>>() {
            override fun loadFromDB(): Flow<List<QuisionerAnswer>> {
                return localDataSource.getQuisionerAnswer().map {
                    DataMapperQuisionerAnswer.mapEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<QuisionerAnswer>?): Boolean =
                true

            override suspend fun createCall(): Flow<ApiResponse<List<QuisionerAnswerResponse>>> =
                remoteDataSource.getQuisionerAnswer(quisionerId, begda, endda)

            override suspend fun emptyDataBase() {
                localDataSource.deleteQuisionerAnswer()
            }

            override suspend fun saveCallResult(data: List<QuisionerAnswerResponse>) {
                val list = DataMapperQuisionerAnswer.mapResponsesToEntities(data)
                localDataSource.insertQuisionerAnswer(list)
            }

        }.asFlow()

    override fun getQuisionerPertanyaan(
        objects: String,
        tableCode: String,
        relation: String,
        otype: String,
        begda: String,
        endda: String
    ): Flow<Resource<List<QuisionerPertanyaan>>> =
        object :
            NetworkBoundResourceWithDeleteLocalData<List<QuisionerPertanyaan>, List<QuisionerPertanyaanResponse>>() {
            override fun loadFromDB(): Flow<List<QuisionerPertanyaan>> {
                return localDataSource.getQuisionerPertanyaan().map {
                    DataMapperQuisionerPertanyaan.mapEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<QuisionerPertanyaan>?): Boolean =
                data == null || data.isEmpty()

            override suspend fun createCall(): Flow<ApiResponse<List<QuisionerPertanyaanResponse>>> =
                remoteDataSource.getQuisionerPertanyaan(
                    objects,
                    tableCode,
                    relation,
                    otype,
                    begda,
                    endda
                )

            override suspend fun emptyDataBase() {
                localDataSource.deleteQuisionerPertanyaan()
            }

            override suspend fun saveCallResult(data: List<QuisionerPertanyaanResponse>) {
                val list = DataMapperQuisionerPertanyaan.mapResponsesToEntities(data)
                localDataSource.insertQuisionerPertanyaan(list)
            }

        }.asFlow()

    override fun getQuisionerPertanyaanWithId(id: Long): Flow<List<QuisionerPertanyaan>> {
        return localDataSource.getQuisionerWithId(id)
            .map { DataMapperQuisionerPertanyaan.mapEntitiesToDomain(it) }
    }

    override fun postTestAnswer(testJawabanPost: TestJawabanPost): Flow<Resource<Submit>> =
        object : NetworkBoundResourceWithDeleteLocalData<Submit, SubmitResponse>() {

            override fun loadFromDB(): Flow<Submit> {
                return localDataSource.getSubmitResponse().map {
                    DataMapperSubmit.mapEntitiestoDomain(it)
                }
            }

            override fun shouldFetch(data: Submit?): Boolean =
                true

            override suspend fun createCall(): Flow<ApiResponse<SubmitResponse>> =
                remoteDataSource.postTestAnswer(testJawabanPost)

            override suspend fun saveCallResult(data: SubmitResponse) {
                val list = DataMapperSubmit.mapResponsetoEntities(data)
                localDataSource.insertSubmitResponse(list)
            }

            override suspend fun emptyDataBase() {
                localDataSource.deleteSubmit()
            }

        }.asFlow()


    override fun deleteQuisionerPertanyaan() =
        appExecutors.diskIO().execute { localDataSource.deleteQuisionerPertanyaan() }


    override fun setCheckedQuisionerAnswer(answer: QuisionerAnswer, state: Boolean) {
        val answerEntity = DataMapperQuisionerAnswer.mapDomainToEntity(answer)
        appExecutors.diskIO()
            .execute { localDataSource.setCheckedQuisionerAnswer(answerEntity, state) }
    }

    override fun getCheckedQuisionerAnswer(): Flow<List<QuisionerAnswer>> {
        return localDataSource.getCheckedQuisionerAnswer().map {
            DataMapperQuisionerAnswer.mapEntitiesToDomain(it)
        }
    }

    override fun getOnlyCheckedQuisionerAnswer(): Flow<List<String>> {
        return localDataSource.getOnlyCheckedAnswer()
    }

    override fun postQuisionerAnswer(quisionerAnswerPost: QuisionerAnswerPost): Flow<Resource<Submit>> =
        object : NetworkBoundResourceWithDeleteLocalData<Submit, SubmitResponse>() {

            override fun loadFromDB(): Flow<Submit> {
                return localDataSource.getSubmitResponse().map {
                    DataMapperSubmit.mapEntitiestoDomain(it)
                }
            }

            override fun shouldFetch(data: Submit?): Boolean =
                true

            override suspend fun createCall(): Flow<ApiResponse<SubmitResponse>> =
                remoteDataSource.postQuisionerAnswer(quisionerAnswerPost)

            override suspend fun saveCallResult(data: SubmitResponse) {
                val list = DataMapperSubmit.mapResponsetoEntities(data)
                localDataSource.insertSubmitResponse(list)
            }

            override suspend fun emptyDataBase() {
                localDataSource.deleteSubmit()
            }

        }.asFlow()


    override fun getTrainerSchedule(
        parentId: String,
        begda: String,
        endda: String
    ): Flow<Resource<List<TrainerSchedule>>> =
        object : NetworkBoundResource<List<TrainerSchedule>, List<TrainerScheduleResponse>>() {
            override fun loadFromDB(): Flow<List<TrainerSchedule>> {
                return localDataSource.getTrainerSchedule().map {
                    DataMapperTrainerSchedule.mapEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<TrainerSchedule>?): Boolean =
                true

            override suspend fun createCall(): Flow<ApiResponse<List<TrainerScheduleResponse>>> =
                remoteDataSource.getTrainerSchedule(parentId, begda, endda)

            override suspend fun saveCallResult(data: List<TrainerScheduleResponse>) {
                val list = DataMapperTrainerSchedule.mapResponsesToEntities(data)
                localDataSource.insertTrainerSchedule(list)
            }

        }.asFlow()


    override fun getRoomSchedule(
        parentId: String,
        begda: String,
        endda: String
    ): Flow<Resource<List<RoomSchedule>>> =
        object : NetworkBoundResource<List<RoomSchedule>, List<RoomScheduleResponse>>() {
            override fun loadFromDB(): Flow<List<RoomSchedule>> {
                return localDataSource.getRoomSchedule().map {
                    DataMapperRoomSchedule.mapEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<RoomSchedule>?): Boolean =
                true

            override suspend fun createCall(): Flow<ApiResponse<List<RoomScheduleResponse>>> =
                remoteDataSource.getRoomSchedule(parentId, begda, endda)

            override suspend fun saveCallResult(data: List<RoomScheduleResponse>) {
                val list = DataMapperRoomSchedule.mapResponsesToEntities(data)
                localDataSource.insertRoomSchedule(list)
            }

        }.asFlow()

    override fun getMentoring(
        sessionId: String,
        id: String,
        begda: String,
        endda: String
    ): Flow<Resource<List<Mentoring>>> =
        object : NetworkBoundResource<List<Mentoring>, List<MentoringResponse>>() {
            override fun loadFromDB(): Flow<List<Mentoring>> {
                return localDataSource.getMentoringList().map {
                    DataMapperMentoring.mapEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<Mentoring>?): Boolean =
                true

            override suspend fun createCall(): Flow<ApiResponse<List<MentoringResponse>>> =
                remoteDataSource.getMentoring(sessionId, id, begda, endda)

            override suspend fun saveCallResult(data: List<MentoringResponse>) {
                val list = DataMapperMentoring.mapResponsesToEntities(data)
                localDataSource.insertMentoring(list)
            }

        }.asFlow()

    override fun getMentoringChat(mentoringId: String): Flow<Resource<List<MentoringChat>>> =
        object : NetworkBoundResource<List<MentoringChat>, List<MentoringChatResponse>>() {
            override fun loadFromDB(): Flow<List<MentoringChat>> {
                return localDataSource.getMentoringChat().map {
                    DataMapperMentoringChat.mapEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<MentoringChat>?): Boolean =
                true

            override suspend fun createCall(): Flow<ApiResponse<List<MentoringChatResponse>>> =
                remoteDataSource.getMentoringChat(mentoringId)


            override suspend fun saveCallResult(data: List<MentoringChatResponse>) {
                val list = DataMapperMentoringChat.mapResponsesToEntities(data)
                localDataSource.insertMentoringChat(list)
            }

        }.asFlow()

    override fun postMentoringChat(mentoringChatPost: MentoringChatPost): Flow<Resource<Submit>> =
        object : NetworkBoundResource<Submit, SubmitResponse>() {

            override fun loadFromDB(): Flow<Submit> {
                return localDataSource.postMentoringChat().map {
                    DataMapperSubmit.mapEntitiestoDomain(it)
                }
            }

            override fun shouldFetch(data: Submit?): Boolean =
                true

            override suspend fun createCall(): Flow<ApiResponse<SubmitResponse>> =
                remoteDataSource.postMentoringChat(mentoringChatPost)

            override suspend fun saveCallResult(data: SubmitResponse) {
                val list = DataMapperSubmit.mapResponsetoEntities(data)
                localDataSource.insertMentoringChat(list)
            }

        }.asFlow()

    override fun getAbsensi(parId: String, sessionId: String): Flow<Resource<Absensi>> =
        object : NetworkBoundResourceWithDeleteLocalData<Absensi, AbsensiResponse>() {
            override fun loadFromDB(): Flow<Absensi> {
                return localDataSource.getAbsensi().map {
                    DataMapperAbsensi.mapEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: Absensi?): Boolean =
                true

            override suspend fun createCall(): Flow<ApiResponse<AbsensiResponse>> =
                remoteDataSource.getAbsensi(parId, sessionId)

            override suspend fun saveCallResult(data: AbsensiResponse) {
                val list = DataMapperAbsensi.mapResponsesToEntities(data)
                localDataSource.insertAbsensi(list)
            }

            override suspend fun emptyDataBase() {
                localDataSource.deleteAbsensi()
            }

        }.asFlow()


    override fun getMentoringDetail(
        mentoringId: String,
        begda: String,
        endda: String
    ): Flow<Resource<List<MentoringDetail>>> =
        object : NetworkBoundResource<List<MentoringDetail>, List<MentoringDetailResponse>>() {
            override fun loadFromDB(): Flow<List<MentoringDetail>> {
                return localDataSource.getMentoringDetail().map {
                    DataMapperMentoringDetail.mapEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<MentoringDetail>?): Boolean =
                true

            override suspend fun createCall(): Flow<ApiResponse<List<MentoringDetailResponse>>> =
                remoteDataSource.getMentoringDetail(mentoringId, begda, endda)


            override suspend fun saveCallResult(data: List<MentoringDetailResponse>) {
                val list = DataMapperMentoringDetail.mapResponsesToEntities(data)
                localDataSource.insertMentoringDetail(list)
            }

        }.asFlow()


}