package com.pos.lms.core.data.source.local.room.dao

import androidx.room.*
import com.pos.lms.core.data.source.local.entity.trainer.TrainerUserEntity
import com.pos.lms.core.data.source.local.entity.trainer.TrainerUserEntity2
import com.pos.lms.core.data.source.local.entity.trainer.TrainerUserEntity3
import kotlinx.coroutines.flow.Flow

@Dao
interface TrainerDao {

    /**
     * ongoing
     */
    @Query("SELECT * FROM traineruser")
    fun getTrainerList(): Flow<List<TrainerUserEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTrainerList(student: List<TrainerUserEntity>)

    @Query("DELETE FROM traineruser")
    suspend fun deleteTrainerUser()

    @Transaction
    suspend fun insertAndDeleteTrainerUser(data: List<TrainerUserEntity>) {
        deleteTrainerUser()
        insertTrainerList(data)
    }

    /**
     * upcoming
     */
    @Query("SELECT * FROM traineruser2")
    fun getUpcoming(): Flow<List<TrainerUserEntity2>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUpcoming(student: List<TrainerUserEntity2>)

    @Query("DELETE FROM traineruser2")
    suspend fun deleteUpcoming()

    @Transaction
    suspend fun insertAndDeleteUpcoming(data: List<TrainerUserEntity2>) {
        deleteUpcoming()
        insertUpcoming(data)
    }

    /**
     * completed
     */
    @Query("SELECT * FROM traineruser3")
    fun getCompleted(): Flow<List<TrainerUserEntity3>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCompleted(student: List<TrainerUserEntity3>)

    @Query("DELETE FROM traineruser3")
    suspend fun deleteCompleted()

    @Transaction
    suspend fun insertAndDeleteCompleted(data: List<TrainerUserEntity3>) {
        deleteCompleted()
        insertCompleted(data)
    }
}