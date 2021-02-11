package com.pos.lms.core.data.source.local.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.pos.lms.core.data.source.local.entity.materi.MateriEntity
import kotlinx.coroutines.flow.Flow

/**
 * Created by Muhammad Zaim Milzam on 10/02/21.
 * linkedin : Muhammad Zaim Milzam
 */
@Dao
interface MateriDao {

    @Query("SELECT * FROM materi")
    fun getMateri(): Flow<List<MateriEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMateri(materi: List<MateriEntity>)

}