package com.pos.lms.core.domain.repository

import com.pos.lms.core.data.Resource
import com.pos.lms.core.domain.model.*
import kotlinx.coroutines.flow.Flow

/**
 * Created by Muhammad Zaim Milzam on 25/02/21.
 * linkedin : Muhammad Zaim Milzam
 */
interface IRoadmapRepository {

    fun getEventRoadmap(begda: String, endda: String): Flow<Resource<List<EventRoadmap>>>

    fun getECPRotasi(
        eventCode: String,
        personalNumber: String,
        begda: String,
        endda: String
    ): Flow<Resource<List<ECPRotasi>>>

    fun getECPPromosi(
        eventCode: String,
        personalNumber: String,
        begda: String,
        endda: String
    ): Flow<Resource<List<ECPPromosi>>>

    fun getMCPRotasi(
        eventCode: String,
        personalNumber: String,
        begda: String,
        endda: String
    ): Flow<Resource<List<MCPRotasi>>>

    fun getMCPPromosi(
        eventCode: String,
        personalNumber: String,
        begda: String,
        endda: String
    ): Flow<Resource<List<MCPPromosi>>>

    fun getSCPRotasi(
        eventCode: String,
        personalNumber: String,
        begda: String,
        endda: String
    ): Flow<Resource<List<SCPRotasi>>>

    fun getSCPPromosi(
        eventCode: String,
        personalNumber: String,
        begda: String,
        endda: String
    ): Flow<Resource<List<SCPPromosi>>>


}