package com.pos.lms.core.domain.usecase.roadmap

import com.pos.lms.core.data.Resource
import com.pos.lms.core.data.repository.RoadmapRepository
import com.pos.lms.core.domain.model.*
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by Muhammad Zaim Milzam on 08/02/21.
 * linkedin : Muhammad Zaim Milzam
 */
class RoadmapInteractor @Inject constructor(private val roadmapRepository: RoadmapRepository) :
    RoadmapUsecase {

    override fun getEventRoadmap(begda: String, endda: String): Flow<Resource<List<EventRoadmap>>> =
        roadmapRepository.getEventRoadmap(begda, endda)

    override fun getECPRotasi(
        eventCode: String,
        personalNumber: String,
        begda: String,
        endda: String
    ): Flow<Resource<List<ECPRotasi>>>  = roadmapRepository.getECPRotasi(eventCode, personalNumber, begda, endda)

    override fun getECPPromosi(
        eventCode: String,
        personalNumber: String,
        begda: String,
        endda: String
    ): Flow<Resource<List<ECPPromosi>>> = roadmapRepository.getECPPromosi(eventCode, personalNumber, begda, endda)

    override fun getMCPRotasi(
        eventCode: String,
        personalNumber: String,
        begda: String,
        endda: String
    ): Flow<Resource<List<MCPRotasi>>> = roadmapRepository.getMCPRotasi(eventCode, personalNumber, begda, endda)

    override fun getMCPPromosi(
        eventCode: String,
        personalNumber: String,
        begda: String,
        endda: String
    ): Flow<Resource<List<MCPPromosi>>> = roadmapRepository.getMCPPromosi(eventCode, personalNumber, begda, endda)

    override fun getSCPRotasi(
        eventCode: String,
        personalNumber: String,
        begda: String,
        endda: String
    ): Flow<Resource<List<SCPRotasi>>> = roadmapRepository.getSCPRotasi(eventCode, personalNumber, begda, endda)

    override fun getSCPPromosi(
        eventCode: String,
        personalNumber: String,
        begda: String,
        endda: String
    ): Flow<Resource<List<SCPPromosi>>> = roadmapRepository.getSCPPromosi(eventCode, personalNumber, begda, endda)


}