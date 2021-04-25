package com.pos.lms.core.data.source.local.room.dao

import androidx.room.*
import com.pos.lms.core.data.source.local.entity.trainer.TrainerUserEntity
import kotlinx.coroutines.flow.Flow

/**
 * Created by Muhammad Zaim Milzam on 22/04/21.
 * linkedin : Muhammad Zaim Milzam
 */
@Dao
interface TrainerDao {

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
}