package com.pos.lms.core.data.source.local.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.pos.lms.core.data.source.local.entity.SubmitEntity
import kotlinx.coroutines.flow.Flow

/**
 * Created by Muhammad Zaim Milzam on 10/02/21.
 * linkedin : Muhammad Zaim Milzam
 */

@Dao
interface SubmitDao {

    @Query("SELECT * FROM submit")
    fun getSubmit(): Flow<SubmitEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSubmit(submit : SubmitEntity)

}