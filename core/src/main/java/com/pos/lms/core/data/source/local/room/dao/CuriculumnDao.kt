package com.pos.lms.core.data.source.local.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.pos.lms.core.data.source.local.entity.curiculum.CuriculumEntity
import kotlinx.coroutines.flow.Flow

/**
 * Created by Muhammad Zaim Milzam on 08/02/21.
 * linkedin : Muhammad Zaim Milzam
 */

@Dao
interface CuriculumnDao {

    @Query("SELECT * FROM curiculum")
    fun getCuriculum(): Flow<List<CuriculumEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCuriculum(curiculum: List<CuriculumEntity>)
}