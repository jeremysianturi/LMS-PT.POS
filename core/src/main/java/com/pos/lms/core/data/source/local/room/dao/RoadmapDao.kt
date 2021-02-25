package com.pos.lms.core.data.source.local.room.dao

import androidx.room.*
import com.pos.lms.core.data.source.local.entity.roadmap.*
import kotlinx.coroutines.flow.Flow

/**
 * Created by Muhammad Zaim Milzam on 24/02/21.
 * linkedin : Muhammad Zaim Milzam
 */

@Dao
interface RoadmapDao {

    // event roadmap
    @Query("SELECT * FROM eventRoadmap")
    fun getEventRoadmap(): Flow<List<EventRoadmapEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertEventRoadmap(materi: List<EventRoadmapEntity>)

    @Query("DELETE FROM eventRoadmap")
    suspend fun deleteEventRoadmap()

    @Transaction
    suspend fun insertAndDeleteEventRoadmap(student: List<EventRoadmapEntity>) {
        deleteEventRoadmap()
        insertEventRoadmap(student)
    }

    // ECP Rotasi
    @Query("SELECT * FROM ecpRotasi")
    fun getECPRotasi(): Flow<List<ECPRotasiEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertECPRotasi(materi: List<ECPRotasiEntity>)

    @Query("DELETE FROM ecpRotasi")
    suspend fun deleteECPRotasi()

    @Transaction
    suspend fun insertAndDeleteECPRotasi(student: List<ECPRotasiEntity>) {
        deleteECPRotasi()
        insertECPRotasi(student)
    }

    // ECP Promosi
    @Query("SELECT * FROM ecpPromosi")
    fun getECPPromosi(): Flow<List<ECPPromosiEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertECPPromosi(materi: List<ECPPromosiEntity>)

    @Query("DELETE FROM ecpPromosi")
    suspend fun deleteECPPromosi()

    @Transaction
    suspend fun insertAndDeleteECPPromosi(student: List<ECPPromosiEntity>) {
        deleteECPPromosi()
        insertECPPromosi(student)
    }

    // MCP Rotasi
    @Query("SELECT * FROM mcpRotasi")
    fun getMCPRotasi(): Flow<List<MCPRotasiEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMCPRotasi(materi: List<MCPRotasiEntity>)

    @Query("DELETE FROM mcpRotasi")
    suspend fun deleteMCPRotasi()

    @Transaction
    suspend fun insertAndDeleteMCPRotasi(student: List<MCPRotasiEntity>) {
        deleteMCPRotasi()
        insertMCPRotasi(student)
    }

    // MCP Promosi
    @Query("SELECT * FROM mcpPromosi")
    fun getMCPPromosi(): Flow<List<MCPPromosiEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMCPPromosi(materi: List<MCPPromosiEntity>)

    @Query("DELETE FROM mcpPromosi")
    suspend fun deleteMCPPromosi()

    @Transaction
    suspend fun insertAndDeleteMCPPromosi(student: List<MCPPromosiEntity>) {
        deleteMCPPromosi()
        insertMCPPromosi(student)
    }

    // SCP Rotasi
    @Query("SELECT * FROM scpRotasi")
    fun getSCPRotasi(): Flow<List<SCPRotasiEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSCPRotasi(materi: List<SCPRotasiEntity>)

    @Query("DELETE FROM scpRotasi")
    suspend fun deleteSCPRotasi()

    @Transaction
    suspend fun insertAndDeleteSCPRotasi(student: List<SCPRotasiEntity>) {
        deleteSCPRotasi()
        insertSCPRotasi(student)
    }

    // SCP Promosi
    @Query("SELECT * FROM scpPromosi")
    fun getSCPPromosi(): Flow<List<SCPPromosiEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSCPPromosi(materi: List<SCPPromosiEntity>)

    @Query("DELETE FROM scpPromosi")
    suspend fun deleteSCPPromosi()

    @Transaction
    suspend fun insertAndDeleteSCPPromosi(student: List<SCPPromosiEntity>) {
        deleteSCPPromosi()
        insertSCPPromosi(student)
    }

}