package com.pos.lms.core.data.source.local.room.dao

import androidx.room.*
import com.pos.lms.core.data.source.local.entity.ItemParIdEntity
import com.pos.lms.core.data.source.local.entity.LoginEntity
import kotlinx.coroutines.flow.Flow

/**
 * Created by Muhammad Zaim Milzam on 29/01/21.
 * linkedin : Muhammad Zaim Milzam
 */

@Dao
interface LoginDao {
    @Query("SELECT * FROM login")
    fun getLogin(): Flow<LoginEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insetLogin(login : LoginEntity)

    @Query("SELECT * FROM ParId")
    fun getParId(): Flow<List<ItemParIdEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insetParId(parId : List<ItemParIdEntity>)

    @Query("DELETE FROM ParId")
    suspend fun deleteParId()

    @Transaction
    suspend fun insertAndDeleteStudent(student: List<ItemParIdEntity>) {
        deleteParId()
        insetParId(student)
    }
}