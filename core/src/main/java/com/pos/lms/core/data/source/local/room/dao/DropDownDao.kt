package com.pos.lms.core.data.source.local.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.pos.lms.core.data.source.local.entity.dropdown.CompanyEnitity
import com.pos.lms.core.data.source.local.entity.dropdown.CompetencyEntity
import com.pos.lms.core.data.source.local.entity.dropdown.PLEntity
import com.pos.lms.core.data.source.local.entity.dropdown.TypeEntity
import kotlinx.coroutines.flow.Flow

/**
 * Created by Muhammad Zaim Milzam on 08/02/21.
 * linkedin : Muhammad Zaim Milzam
 */

@Dao
interface DropDownDao {

    @Query("SELECT * FROM Competency")
    fun getCompetency(): Flow<List<CompetencyEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCompetency(tourism: List<CompetencyEntity>)

    @Query("SELECT * FROM PROVICIENCYLEVEL")
    fun getPL(): Flow<List<PLEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPL(pl: List<PLEntity>)

    @Query("SELECT * FROM Type")
    fun getType(): Flow<List<TypeEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertType(type: List<TypeEntity>)

    @Query("SELECT * FROM Company")
    fun getCompany(): Flow<List<CompanyEnitity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCompany(type: List<CompanyEnitity>)

}