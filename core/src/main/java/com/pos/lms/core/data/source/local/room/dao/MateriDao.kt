package com.pos.lms.core.data.source.local.room.dao

import androidx.room.*
import com.pos.lms.core.data.source.local.entity.materi.MateriEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MateriDao {

    @Query("SELECT * FROM materi")
    fun getMateri(): Flow<List<MateriEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMateri(materi: List<MateriEntity>)

    @Query("DELETE FROM materi")
    suspend fun deleteMateri()

    @Transaction
    suspend fun insertAndDeleteMateri(student: List<MateriEntity>) {
        deleteMateri()
        insertMateri(student)
    }

    @Transaction
    @Query("SELECT * FROM materi where materi_name LIKE '%'|| :search || '%'")
    fun getSearchMateri(search: String): Flow<List<MateriEntity>>

}