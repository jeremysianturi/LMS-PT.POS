package com.pos.lms.core.data.source.local.room.dao

import androidx.room.*
import com.pos.lms.core.data.source.local.entity.profile.AvatarEntity
import kotlinx.coroutines.flow.Flow

/**
 * Created by Muhammad Zaim Milzam on 25/04/21.
 * linkedin : Muhammad Zaim Milzam
 */

@Dao
interface ProfileDao {

    @Query("SELECT * FROM avatar")
    fun getAvatar(): Flow<List<AvatarEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAvatar(data: List<AvatarEntity>)

    @Query("DELETE FROM avatar")
    suspend fun deleteAvatar()

    @Transaction
    suspend fun insertAndDeleteAvatar(data: List<AvatarEntity>) {
        deleteAvatar()
        insertAvatar(data)
    }
}