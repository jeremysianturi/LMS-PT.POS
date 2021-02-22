package com.pos.lms.core.data.source.local.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.pos.lms.core.data.source.local.entity.student.*
import kotlinx.coroutines.flow.Flow

/**
 * Created by Muhammad Zaim Milzam on 10/02/21.
 * linkedin : Muhammad Zaim Milzam
 */

@Dao
interface StudentDao {

    @Query("SELECT * FROM student")
    fun getStudent(): Flow<List<StudentEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStudent(student: List<StudentEntity>)

    @Query("SELECT * FROM detailsession")
    fun getDetailSessiont(): Flow<List<DetailSessionEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDetailSession(student: List<DetailSessionEntity>)

    @Query("SELECT * FROM sessionlist")
    fun getSessionList(): Flow<List<SessionListEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSessionList(student: List<SessionListEntity>)

    @Query("SELECT * FROM forumlist")
    fun getForumList(): Flow<List<ForumListEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertForumList(student: List<ForumListEntity>)

    @Query("SELECT * FROM insightlist")
    fun getInsightList(): Flow<List<InsightListEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertInsightList(student: List<InsightListEntity>)

    @Query("SELECT * FROM schedule")
    fun getSchedule(): Flow<List<ScheduleEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSchedule(student: List<ScheduleEntity>)

    @Query("SELECT * FROM forumcomment")
    fun getForumComment(): Flow<List<ForumCommentEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertForumComment(student: List<ForumCommentEntity>)

    @Query("SELECT * FROM materischedule")
    fun getMateriSchedule(): Flow<List<MateriScheduleEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMateriSchedule(student: List<MateriScheduleEntity>)

    @Query("SELECT * FROM testschedule")
    fun getTestchedule(): Flow<List<TestScheduleEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTestSchedule(student: List<TestScheduleEntity>)

    @Query("SELECT * FROM quisionerSchedule")
    fun getQuisionerchedule(): Flow<List<QuisionerScheduleEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertQuisionerSchedule(student: List<QuisionerScheduleEntity>)

    @Query("SELECT * FROM RoomSchedule")
    fun getRoomShedule(): Flow<List<RoomScheduleEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRoomSchedule(student: List<RoomScheduleEntity>)

    @Query("SELECT * FROM trainerschedule")
    fun getTrainerShedule(): Flow<List<TrainerScheduleEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTrainerSchedule(student: List<TrainerScheduleEntity>)

    @Query("SELECT * FROM mentoringList")
    fun getMentoring(): Flow<List<MentoringEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMentoring(student: List<MentoringEntity>)

    @Query("SELECT * FROM mentoringChat")
    fun getMentoringChat(): Flow<List<MentoringChatEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMentoringChat(student: List<MentoringChatEntity>)

}