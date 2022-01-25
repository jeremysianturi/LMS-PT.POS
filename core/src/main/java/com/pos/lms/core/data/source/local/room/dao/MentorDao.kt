package com.pos.lms.core.data.source.local.room.dao

import androidx.room.*
import com.pos.lms.core.data.source.local.entity.mentor.MentorUserEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MentorDao {

    @Query("SELECT * FROM mentorUser")
    fun getMentor(): Flow<List<MentorUserEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMentor(student: List<MentorUserEntity>)

    @Query("DELETE FROM mentorUser")
    suspend fun deleteMentorUser()

    @Transaction
    suspend fun insertAndDeleteMentorUser(data: List<MentorUserEntity>) {
        deleteMentorUser()
        insertMentor(data)
    }
}