package com.pos.lms.core.data.source.local.room

import com.pos.lms.core.data.source.local.entity.ItemParIdEntity
import com.pos.lms.core.data.source.local.entity.LoginEntity
import com.pos.lms.core.data.source.local.entity.SubmitEntity
import com.pos.lms.core.data.source.local.entity.curiculum.CuriculumEntity
import com.pos.lms.core.data.source.local.entity.dropdown.CompanyEnitity
import com.pos.lms.core.data.source.local.entity.dropdown.CompetencyEntity
import com.pos.lms.core.data.source.local.entity.dropdown.PLEntity
import com.pos.lms.core.data.source.local.entity.dropdown.TypeEntity
import com.pos.lms.core.data.source.local.entity.materi.MateriEntity
import com.pos.lms.core.data.source.local.entity.mentor.MentorUserEntity
import com.pos.lms.core.data.source.local.entity.profile.AvatarEntity
import com.pos.lms.core.data.source.local.entity.roadmap.*
import com.pos.lms.core.data.source.local.entity.student.*
import com.pos.lms.core.data.source.local.room.dao.*
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalDataSource @Inject constructor(
    private val mLoginDao: LoginDao,
    private val mSubmitDao: SubmitDao,
    private val mCuriculumDao: CuriculumnDao,
    private val mDropDownDao: DropDownDao,
    private val mMateriDao: MateriDao,
    private val mStudentDao: StudentDao,
    private val mRoadmapDao: RoadmapDao,
    private val mProfileDao: ProfileDao,
    private val mMentorDao: MentorDao
) {

    fun getLogin(): Flow<LoginEntity> = mLoginDao.getLogin()
    suspend fun insertLogin(login: LoginEntity) = mLoginDao.insetLogin(login)

    fun getParId(): Flow<List<ItemParIdEntity>> = mLoginDao.getParId()
    suspend fun insertParId(parId: List<ItemParIdEntity>) = mLoginDao.insertAndDeleteStudent(parId)

    fun deleteSubmit() = mSubmitDao.deleteSubmit()

    // pagination
    fun getPagintaion(): Flow<PaginationEntity> = mStudentDao.getPagination()
    suspend fun insertPagination(data: PaginationEntity) =
        mStudentDao.insertAndDeletePagination(data)

    suspend fun deletePagination() = mStudentDao.deletePagination()

    // dropdown
    fun getCompetency(): Flow<List<CompetencyEntity>> = mDropDownDao.getCompetency()
    suspend fun insertCompetency(competency: List<CompetencyEntity>) =
        mDropDownDao.insertCompetency(competency)

    fun getPL(): Flow<List<PLEntity>> = mDropDownDao.getPL()
    suspend fun insertPL(pl: List<PLEntity>) =
        mDropDownDao.insertPL(pl)

    fun getType(): Flow<List<TypeEntity>> = mDropDownDao.getType()
    suspend fun insertType(type: List<TypeEntity>) =
        mDropDownDao.insertType(type)

    fun getCompany(): Flow<List<CompanyEnitity>> = mDropDownDao.getCompany()
    suspend fun insertCompany(company: List<CompanyEnitity>) =
        mDropDownDao.insertCompany(company)

    // curiculum
    fun getCuriculum(): Flow<List<CuriculumEntity>> = mCuriculumDao.getCuriculum()
    suspend fun insertCuriculum(curiculum: List<CuriculumEntity>) =
        mCuriculumDao.insertAndDeleteCuriculum(curiculum)

    suspend fun deleteCuriculum() = mCuriculumDao.deleteCuriculum()

    fun getSearchCuriculum(search: String): Flow<List<CuriculumEntity>> =
        mCuriculumDao.getSearchCuriculum(search)


    fun getSubmitResponse(): Flow<SubmitEntity> = mSubmitDao.getSubmit()
    suspend fun insertSubmitResponse(submitEntity: SubmitEntity) =
        mSubmitDao.insertAndDeleteMentoringChat(submitEntity)

    // materi
    fun getMateri(): Flow<List<MateriEntity>> = mMateriDao.getMateri()
    suspend fun insertMateri(materi: List<MateriEntity>) =
        mMateriDao.insertAndDeleteMateri(materi)

    suspend fun deleteMateri() = mMateriDao.deleteMateri()

    fun getSearchMateri(search: String): Flow<List<MateriEntity>> =
        mMateriDao.getSearchMateri(search)


    // student
    fun getStudent(): Flow<List<StudentEntity>> = mStudentDao.getStudent()
    suspend fun insertStudent(student: List<StudentEntity>) =
        mStudentDao.insertAndDeleteStudent(student)

    suspend fun deleteStudent() = mStudentDao.deleteStudent()

    //    -> Detail session
    fun getDetailSession(): Flow<List<DetailSessionEntity>> = mStudentDao.getDetailSessiont()
    suspend fun insertDetailSession(student: List<DetailSessionEntity>) =
        mStudentDao.insertDetailSession(student)

    //    -> sessionList
    fun getSessionList(): Flow<List<SessionListEntity>> = mStudentDao.getSessionList()
    suspend fun insertSessionList(student: List<SessionListEntity>) =
        mStudentDao.insertAndDeleteSessionList(student)

    //    -> forumList
    fun getForumList(): Flow<List<ForumListEntity>> = mStudentDao.getForumList()
    suspend fun insertForumList(student: List<ForumListEntity>) =
        mStudentDao.insertAndDeleteForumList(student)

    suspend fun deleteForumList() = mStudentDao.deleteForumList()

    fun getSearchForum(search: String): Flow<List<ForumListEntity>> =
        mStudentDao.getSearchForumList(search)

    fun getMyForum(owner: String): Flow<List<ForumListEntity>> = mStudentDao.getMyForumList(owner)

    // -> forumList -> ForumComment
    fun getForumComment(): Flow<List<ForumCommentEntity>> = mStudentDao.getForumComment()
    suspend fun insertForumComment(student: List<ForumCommentEntity>) =
        mStudentDao.insertAndDeleteForumComment(student)

    // -> forum like
    fun getForumLike(): Flow<List<ForumLikeEntity>> = mStudentDao.getForumLike()
    suspend fun insertForumLike(data: List<ForumLikeEntity>) =
        mStudentDao.insertAndDeleteForumLike(data)

    suspend fun deleteForumLike() = mStudentDao.deleteForumLike()

    //    -> InsightList
    fun getInsightList(): Flow<List<InsightListEntity>> = mStudentDao.getInsightList()
    suspend fun insertInsightList(student: List<InsightListEntity>) =
        mStudentDao.insertAndDeleteInsightList(student)

    fun getSearchInsight(search: String): Flow<List<InsightListEntity>> =
        mStudentDao.getSearchInsight(search)

    fun getMyInsight(owner: String): Flow<List<InsightListEntity>> = mStudentDao.getMyInsight(owner)

    suspend fun deleteInsightList() = mStudentDao.deleteInsightList()

    // -> ScheduleList
    fun getSchedule(): Flow<List<ScheduleEntity>> = mStudentDao.getSchedule()
    suspend fun insertSchedule(student: List<ScheduleEntity>) =
        mStudentDao.insertAndDeleteSchedule(student)

    // -> ScheduleList -> DetailSchedule -> Materi
    fun getMateriSchedule(): Flow<List<MateriScheduleEntity>> = mStudentDao.getMateriSchedule()
    suspend fun insertMateriSchedule(student: List<MateriScheduleEntity>) =
        mStudentDao.insertAndDeleteScheduleMateri(student)

    // -> ScheduleList -> DetailSchedule -> Test
    fun getTestSchedule(): Flow<List<TestScheduleEntity>> = mStudentDao.getTestchedule()
    suspend fun insertTestSchedule(student: List<TestScheduleEntity>) =
        mStudentDao.insertAndDeleteTestSchedule(student)

    // -> ScheduleList -> DetailSchedule -> Room
    fun getRoomSchedule(): Flow<List<RoomScheduleEntity>> = mStudentDao.getRoomShedule()
    suspend fun insertRoomSchedule(student: List<RoomScheduleEntity>) =
        mStudentDao.insertAndDeleteRoomSchedule(student)

    // -> ScheduleList -> DetailSchedule -> Trainer
    fun getTrainerSchedule(): Flow<List<TrainerScheduleEntity>> = mStudentDao.getTrainerShedule()
    suspend fun insertTrainerSchedule(student: List<TrainerScheduleEntity>) =
        mStudentDao.insertAndDeleteTrainerSchedule(student)

    // -> ScheduleList -> DetailSchedule -> Quisioner
    fun getQuisionerSchedule(): Flow<List<QuisionerScheduleEntity>> =
        mStudentDao.getQuisionerchedule()

    suspend fun insertQuisionerSchedule(student: List<QuisionerScheduleEntity>) =
        mStudentDao.insertAndDeleteQuisionerSchedule(student)

    //    Quisioner Answer
    fun getQuisionerAnswer(): Flow<List<QuisionerAnswerEntity>> =
        mStudentDao.getQuisionerAnswer()

    fun getOnlyCheckedAnswer(): Flow<List<String>> =
        mStudentDao.getOnlyCheckedAnswer()

    fun setCheckedQuisionerAnswer(data: QuisionerAnswerEntity, newState: Boolean) {
        data.isChecked = newState
        mStudentDao.updateAnswer(data)
    }

    fun getCheckedQuisionerAnswer(): Flow<List<QuisionerAnswerEntity>> =
        mStudentDao.getCheckedAnswer()

    suspend fun insertQuisionerAnswer(student: List<QuisionerAnswerEntity>) =
        mStudentDao.insertAndDeleteQuisionerAnswer(student)

    suspend fun deleteQuisionerAnswer() = mStudentDao.deleteQuisionerAnswer()

    //    Quisioner Pertanyaan
    fun getQuisionerPertanyaan(): Flow<List<QuisionerPertanyaanEntity>> =
        mStudentDao.getQuisionerPertanyaan()

    suspend fun insertQuisionerPertanyaan(student: List<QuisionerPertanyaanEntity>) =
        mStudentDao.insertAndDeleteQuisionerPertanyaan(student)

    fun getQuisionerWithId(id: Long): Flow<List<QuisionerPertanyaanEntity>> =
        mStudentDao.getQuisionerPertanyaanWithId(id)

    fun deleteQuisionerPertanyaan() =
        mStudentDao.deleteQuisionerPertanyaan()

    //   test  Pertanyaan
    fun getTestPertanyaan(): Flow<List<TestPertanyaanEntity>> =
        mStudentDao.getTestPertanyaan()

    suspend fun insertTestPertanyaan(student: List<TestPertanyaanEntity>) =
        mStudentDao.insertAndDeleteTestPertanyaan(student)

    fun getTestPertanyaanWithId(id: Long): Flow<List<TestPertanyaanEntity>> =
        mStudentDao.getTestPertanyaanWithId(id)

    suspend fun deleteTestPertanyaan() =
        mStudentDao.deleteTestPertanyaan()

    //    Test Answer
    fun getTestAnswer(): Flow<List<TestJawabanEntity>> =
        mStudentDao.getTestAnswer()

    fun getOnlyTestCheckedAnswer(): Flow<List<String>> =
        mStudentDao.getOnlyTestCheckedAnswer()

    fun setCheckedTestAnswer(data: TestJawabanEntity, newState: Boolean) {
        data.isChecked = newState
        mStudentDao.updatetestAnswer(data)
    }

    fun getCheckedTestAnswer(): Flow<List<TestJawabanEntity>> =
        mStudentDao.getCheckedTestAnswer()

    suspend fun insertTestAnswer(student: List<TestJawabanEntity>) =
        mStudentDao.insertAndDeleteTestAnswer(student)

    suspend fun deleteTestnswer() = mStudentDao.deleteTestAnswer()

    // -> Session -> Mentoring
    fun getMentoringList(): Flow<List<MentoringEntity>> =
        mStudentDao.getMentoring()

    suspend fun insertMentoring(student: List<MentoringEntity>) =
        mStudentDao.insertAndDeleteMentoring(student)

    // -> Session -> Mentoring -> Detail
    fun getMentoringDetail(): Flow<List<MentoringDetailEntity>> =
        mStudentDao.getMentoringDetail()

    suspend fun insertMentoringDetail(student: List<MentoringDetailEntity>) =
        mStudentDao.insertAndDeleteMentoringDetail(student)

    // -> Session -> Mentoring -> Chat
    fun getMentoringChat(): Flow<List<MentoringChatEntity>> =
        mStudentDao.getMentoringChat()

    suspend fun insertMentoringChat(student: List<MentoringChatEntity>) =
        mStudentDao.insertAndDeleteMentoringChat(student)

    // -> Session -> Mentoring -> Post Chat
    fun postMentoringChat(): Flow<SubmitEntity> =
        mSubmitDao.getSubmit()

    suspend fun insertMentoringChat(student: SubmitEntity) =
        mSubmitDao.insertAndDeleteMentoringChat(student)

    // -> Absensi
    fun getAbsensi(): Flow<AbsensiEntity> =
        mStudentDao.getAbsensi()

    suspend fun insertAbsensi(student: AbsensiEntity) =
        mStudentDao.insertAndDeletAbsensi(student)

    suspend fun deleteAbsensi() = mStudentDao.deleteAbsensi()

    //    --------- ROADMAP ------------
    // eventRoadmap
    fun getEventRoadmap(): Flow<List<EventRoadmapEntity>> = mRoadmapDao.getEventRoadmap()
    suspend fun insertAndDeleteEventRoadmap(data: List<EventRoadmapEntity>) =
        mRoadmapDao.insertAndDeleteEventRoadmap(data)

    // ECP Rotasi
    fun getECPRotasi(): Flow<List<ECPRotasiEntity>> = mRoadmapDao.getECPRotasi()
    suspend fun insertAndDeleteECPRotasi(data: List<ECPRotasiEntity>) =
        mRoadmapDao.insertAndDeleteECPRotasi(data)

    suspend fun deleteECPRotasi() = mRoadmapDao.deleteECPRotasi()

    // ECP Promosi
    fun getECPPromosi(): Flow<List<ECPPromosiEntity>> = mRoadmapDao.getECPPromosi()
    suspend fun insertAndDeleteECPPromosi(data: List<ECPPromosiEntity>) =
        mRoadmapDao.insertAndDeleteECPPromosi(data)

    suspend fun deleteECPromosi() = mRoadmapDao.deleteECPPromosi()

    // MCP Rotasi
    fun getMCPRotasi(): Flow<List<MCPRotasiEntity>> = mRoadmapDao.getMCPRotasi()
    suspend fun insertAndDeleteMCPRotasi(data: List<MCPRotasiEntity>) =
        mRoadmapDao.insertAndDeleteMCPRotasi(data)

    suspend fun deleteMCRotasi() = mRoadmapDao.deleteMCPRotasi()

    // MCP Promosi
    fun getMCPPromosi(): Flow<List<MCPPromosiEntity>> = mRoadmapDao.getMCPPromosi()
    suspend fun insertAndDeleteMCPPromosi(data: List<MCPPromosiEntity>) =
        mRoadmapDao.insertAndDeleteMCPPromosi(data)

    suspend fun deleteMCPPromosi() = mRoadmapDao.deleteMCPPromosi()

    // SCP Rotasi
    fun getSCPRotasi(): Flow<List<SCPRotasiEntity>> = mRoadmapDao.getSCPRotasi()
    suspend fun insertAndDeleteSCPRotasi(data: List<SCPRotasiEntity>) =
        mRoadmapDao.insertAndDeleteSCPRotasi(data)

    suspend fun deleteSCPRotasi() = mRoadmapDao.deleteSCPRotasi()

    // SCP Promosi
    fun getSCPPromosi(): Flow<List<SCPPromosiEntity>> = mRoadmapDao.getSCPPromosi()
    suspend fun insertAndDeleteSCPPromosi(data: List<SCPPromosiEntity>) =
        mRoadmapDao.insertAndDeleteSCPPromosi(data)

    suspend fun deleteSCPPromosi() = mRoadmapDao.deleteSCPPromosi()

    // avatar
    fun getAvatar(): Flow<List<AvatarEntity>> = mProfileDao.getAvatar()
    suspend fun insertAndDeleteAvatar(data: List<AvatarEntity>) =
        mProfileDao.insertAndDeleteAvatar(data)

    suspend fun deleteAvatar() = mProfileDao.deleteAvatar()

    // mentor user

    fun getMentor(): Flow<List<MentorUserEntity>> = mMentorDao.getMentor()
    suspend fun insertAndDeleteMentor(data: List<MentorUserEntity>) =
        mMentorDao.insertAndDeleteMentorUser(data)

    suspend fun deleteMentor() = mMentorDao.deleteMentorUser()


}