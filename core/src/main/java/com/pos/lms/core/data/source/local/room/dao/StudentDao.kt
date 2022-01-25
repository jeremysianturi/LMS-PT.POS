package com.pos.lms.core.data.source.local.room.dao

import androidx.room.*
import com.pos.lms.core.data.source.local.entity.student.*
import kotlinx.coroutines.flow.Flow

@Dao
interface StudentDao {

    // ---------------- pagination ---------------
    @Query("SELECT * FROM pagination")
    fun getPagination(): Flow<PaginationEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPaginatiom(student: PaginationEntity)

    @Query("DELETE FROM pagination")
    suspend fun deletePagination()

    @Transaction
    suspend fun insertAndDeletePagination(student: PaginationEntity) {
        deletePagination()
        insertPaginatiom(student)
    }

    //    --------------- student -------------------
    @Query("SELECT * FROM student")
    fun getStudent(): Flow<List<StudentEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStudent(student: List<StudentEntity>)

    @Query("DELETE FROM student")
    suspend fun deleteStudent()

    @Transaction
    suspend fun insertAndDeleteStudent(student: List<StudentEntity>) {
        deleteStudent()
        insertStudent(student)
    }

    //    --------------- session -------------------
    @Query("SELECT * FROM detailsession")
    fun getDetailSessiont(): Flow<List<DetailSessionEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDetailSession(student: List<DetailSessionEntity>)

    @Query("SELECT * FROM sessionlist")
    fun getSessionList(): Flow<List<SessionListEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSessionList(student: List<SessionListEntity>)

    @Query("DELETE FROM sessionlist")
    suspend fun deleteSessionList()

    @Transaction
    suspend fun insertAndDeleteSessionList(student: List<SessionListEntity>) {
        deleteSessionList()
        insertSessionList(student)
    }

    //    --------------- forum -------------------

    @Query("SELECT * FROM forumlist ORDER By forum_id DESC")
    fun getForumList(): Flow<List<ForumListEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertForumList(student: List<ForumListEntity>)

    @Query("DELETE FROM ForumList")
    suspend fun deleteForumList()

    @Transaction
    suspend fun insertAndDeleteForumList(student: List<ForumListEntity>) {
        deleteForumList()
        insertForumList(student)
    }

    @Transaction
    @Query("SELECT * FROM ForumList where forum_title LIKE '%'|| :search || '%'")
    fun getSearchForumList(search: String): Flow<List<ForumListEntity>>

    @Transaction
    @Query("SELECT * FROM ForumList where owner LIKE '%'|| :search || '%'")
    fun getMyForumList(search: String): Flow<List<ForumListEntity>>

    @Query("SELECT * FROM forumcomment")
    fun getForumComment(): Flow<List<ForumCommentEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertForumComment(student: List<ForumCommentEntity>)

    @Query("DELETE FROM ForumComment")
    suspend fun deleteForumComment()

    @Transaction
    suspend fun insertAndDeleteForumComment(student: List<ForumCommentEntity>) {
        deleteForumComment()
        insertForumComment(student)
    }

    @Query("SELECT * FROM ForumLike")
    fun getForumLike(): Flow<List<ForumLikeEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertForumLike(student: List<ForumLikeEntity>)

    @Query("DELETE FROM ForumLike")
    suspend fun deleteForumLike()

    @Transaction
    suspend fun insertAndDeleteForumLike(student: List<ForumLikeEntity>) {
        deleteForumLike()
        insertForumLike(student)
    }

    //    --------------- insight -------------------
    @Query("SELECT * FROM insightlist")
    fun getInsightList(): Flow<List<InsightListEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertInsightList(student: List<InsightListEntity>)

    @Query("DELETE FROM InsightList")
    suspend fun deleteInsightList()

    @Transaction
    suspend fun insertAndDeleteInsightList(student: List<InsightListEntity>) {
        deleteInsightList()
        insertInsightList(student)
    }

    @Transaction
    @Query("SELECT * FROM InsightList where forum_title LIKE '%'|| :search || '%'")
    fun getSearchInsight(search: String): Flow<List<InsightListEntity>>

    @Transaction
    @Query("SELECT * FROM InsightList where owner LIKE '%'|| :search || '%'")
    fun getMyInsight(search: String): Flow<List<InsightListEntity>>


    //    --------------- schedule -------------------
    @Query("SELECT * FROM schedule")
    fun getSchedule(): Flow<List<ScheduleEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSchedule(student: List<ScheduleEntity>)

    @Query("DELETE FROM schedule")
    suspend fun deleteSchedule()

    @Transaction
    suspend fun insertAndDeleteSchedule(student: List<ScheduleEntity>) {
        deleteSchedule()
        insertSchedule(student)
    }

    //    --------------- schedule Materi -------------------
    @Query("SELECT * FROM materischedule")
    fun getMateriSchedule(): Flow<List<MateriScheduleEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMateriSchedule(student: List<MateriScheduleEntity>)

    @Query("DELETE FROM materischedule")
    suspend fun deleteScheduleMateri()

    @Transaction
    suspend fun insertAndDeleteScheduleMateri(student: List<MateriScheduleEntity>) {
        deleteScheduleMateri()
        insertMateriSchedule(student)
    }

    //    --------------- schedule Test -------------------
    @Query("SELECT * FROM testschedule")
    fun getTestchedule(): Flow<List<TestScheduleEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTestSchedule(student: List<TestScheduleEntity>)

    @Query("DELETE FROM testschedule")
    suspend fun deleteTestSchedule()

    @Transaction
    suspend fun insertAndDeleteTestSchedule(student: List<TestScheduleEntity>) {
        deleteTestSchedule()
        insertTestSchedule(student)
    }

    //    --------------------------- schedule Quisioner ---------------------------
    @Query("SELECT * FROM quisionerSchedule")
    fun getQuisionerchedule(): Flow<List<QuisionerScheduleEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertQuisionerSchedule(student: List<QuisionerScheduleEntity>)

    @Query("DELETE FROM quisionerSchedule")
    suspend fun deleteQuisionerSchedule()

    @Transaction
    suspend fun insertAndDeleteQuisionerSchedule(student: List<QuisionerScheduleEntity>) {
        deleteQuisionerSchedule()
        insertQuisionerSchedule(student)
    }

    // --------------------------- quesioner answer ---------------------------

    @Query("SELECT * FROM quisionerAnswer")
    fun getQuisionerAnswer(): Flow<List<QuisionerAnswerEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertQuisionerAnswer(student: List<QuisionerAnswerEntity>)

    @Query("DELETE FROM quisionerAnswer")
    suspend fun deleteQuisionerAnswer()

    @Transaction
    suspend fun insertAndDeleteQuisionerAnswer(student: List<QuisionerAnswerEntity>) {
        deleteQuisionerAnswer()
        insertQuisionerAnswer(student)
    }

    @Update
    fun updateAnswer(answer: QuisionerAnswerEntity)

    @Transaction
    @Query("SELECT * FROM quisionerAnswer")
    fun getCheckedAnswer(): Flow<List<QuisionerAnswerEntity>>

    @Transaction
    @Query("SELECT text_choice FROM quisionerAnswer WHERE isChecked = 1")
    fun getOnlyCheckedAnswer(): Flow<List<String>>

    // --------------------------- quesioner Pertanyaan ---------------------------
    @Query("SELECT * FROM quisionerPertanyaan")
    fun getQuisionerPertanyaan(): Flow<List<QuisionerPertanyaanEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertQuisionerPertanyaan(student: List<QuisionerPertanyaanEntity>)

    @Query("DELETE FROM quisionerPertanyaan")
    fun deleteQuisionerPertanyaan()

    @Transaction
    suspend fun insertAndDeleteQuisionerPertanyaan(student: List<QuisionerPertanyaanEntity>) {
        deleteQuisionerPertanyaan()
        insertQuisionerPertanyaan(student)
    }

    @Transaction
    @Query("SELECT * FROM quisionerPertanyaan WHERE _id LIKE '%'|| :id || '%'")
    fun getQuisionerPertanyaanWithId(id: Long): Flow<List<QuisionerPertanyaanEntity>>

    // --------------------------- Test Pertanyaan ---------------------------
    @Query("SELECT * FROM TestPertanyaan")
    fun getTestPertanyaan(): Flow<List<TestPertanyaanEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTestPertanyaan(student: List<TestPertanyaanEntity>)

    @Query("DELETE FROM TestPertanyaan")
    suspend fun deleteTestPertanyaan()

    @Transaction
    suspend fun insertAndDeleteTestPertanyaan(student: List<TestPertanyaanEntity>) {
        deleteTestPertanyaan()
        insertTestPertanyaan(student)
    }

    @Transaction
//    @Query("SELECT * FROM TestPertanyaan WHERE _id LIKE '%'|| :id || '%'")
    @Query("SELECT * FROM TestPertanyaan LIMIT 1 OFFSET :id")
    fun getTestPertanyaanWithId(id: Long): Flow<List<TestPertanyaanEntity>>

    // ------------------- Test jawaban ----------------------------
    @Query("SELECT * FROM TestJawaban")
    fun getTestAnswer(): Flow<List<TestJawabanEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTestAnswer(student: List<TestJawabanEntity>)

    @Query("DELETE FROM TestJawaban")
    suspend fun deleteTestAnswer()

    @Transaction
    suspend fun insertAndDeleteTestAnswer(student: List<TestJawabanEntity>) {
        deleteTestAnswer()
        insertTestAnswer(student)
    }

    @Update
    fun updatetestAnswer(answer: TestJawabanEntity)

    @Transaction
    @Query("SELECT * FROM testjawaban")
    fun getCheckedTestAnswer(): Flow<List<TestJawabanEntity>>

    @Transaction
    @Query("SELECT text_choice FROM testjawaban WHERE isChecked = 1")
    fun getOnlyTestCheckedAnswer(): Flow<List<String>>

    //    --------------- schedule Room -------------------
    @Query("SELECT * FROM RoomSchedule")
    fun getRoomShedule(): Flow<List<RoomScheduleEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRoomSchedule(student: List<RoomScheduleEntity>)

    @Query("DELETE FROM RoomSchedule")
    suspend fun deleteRoomSchedule()

    @Transaction
    suspend fun insertAndDeleteRoomSchedule(student: List<RoomScheduleEntity>) {
        deleteRoomSchedule()
        insertRoomSchedule(student)
    }

    @Query("SELECT * FROM trainerschedule")
    fun getTrainerShedule(): Flow<List<TrainerScheduleEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTrainerSchedule(student: List<TrainerScheduleEntity>)

    @Query("DELETE FROM trainerschedule")
    suspend fun deleteTrainerSchedule()

    @Transaction
    suspend fun insertAndDeleteTrainerSchedule(student: List<TrainerScheduleEntity>) {
        deleteTrainerSchedule()
        insertTrainerSchedule(student)
    }

    //    --------------- Mentoring -------------------
    @Query("SELECT * FROM mentoringList")
    fun getMentoring(): Flow<List<MentoringEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMentoring(student: List<MentoringEntity>)

    @Query("DELETE FROM mentoringList")
    suspend fun deleteMentoring()

    @Transaction
    suspend fun insertAndDeleteMentoring(student: List<MentoringEntity>) {
        deleteMentoring()
        insertMentoring(student)
    }


    //    --------------- Mentoring Chat -------------------
    @Query("SELECT * FROM mentoringChat")
    fun getMentoringChat(): Flow<List<MentoringChatEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMentoringChat(student: List<MentoringChatEntity>)

    @Query("DELETE FROM mentoringChat")
    suspend fun deleteMentoringChat()

    @Transaction
    suspend fun insertAndDeleteMentoringChat(student: List<MentoringChatEntity>) {
        deleteMentoringChat()
        insertMentoringChat(student)
    }

    //    --------------- Mentoring Detail -------------------
    @Query("SELECT * FROM mentoringDetail")
    fun getMentoringDetail(): Flow<List<MentoringDetailEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMentoringDetail(student: List<MentoringDetailEntity>)

    @Query("DELETE FROM mentoringDetail")
    suspend fun deleteMentoringDetail()

    @Transaction
    suspend fun insertAndDeleteMentoringDetail(student: List<MentoringDetailEntity>) {
        deleteMentoringDetail()
        insertMentoringDetail(student)
    }

    //    --------------- absensi -------------------
    @Query("SELECT * FROM absensi")
    fun getAbsensi(): Flow<AbsensiEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAbsesnsi(student: AbsensiEntity)

    @Query("DELETE FROM absensi")
    suspend fun deleteAbsensi()

    @Transaction
    suspend fun insertAndDeletAbsensi(student: AbsensiEntity) {
        deleteAbsensi()
        insertAbsesnsi(student)
    }


}