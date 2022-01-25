package com.pos.lms.core.data.source.remote.network

import com.pos.lms.core.data.source.remote.response.roadmap.ListECPResponse
import com.pos.lms.core.data.source.remote.response.roadmap.ListEventRoadmapResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiITMS {

    @GET("tms/api/event?business_code=POS&order[STRHR]=desc&event_type=ASPIRATION&event_status=02")
    suspend fun eventRoadmap(
        @Query("begin_date_lte") begda: String,
        @Query("end_hour_gte") endda: String,
    ): ListEventRoadmapResponse

    @GET("hcis/api/qualifications/career/read-aspiration?business_code=POS&aspiration_type=ROTATION&aspiration=ECP")
    suspend fun ecpRotasi(
        @Query("begin_date_lte") begda: String,
        @Query("end_date_gte") endda: String,
        @Query("fn_event_code") eventCode: String,
        @Query("fn_personnel_number") personalNumber: String,
    ): ListECPResponse

    @GET("hcis/api/qualifications/career/read-aspiration?business_code=POS&aspiration_type=PROMOTION&aspiration=ECP")
    suspend fun ecpPromosi(
        @Query("begin_date_lte") begda: String,
        @Query("end_date_gte") endda: String,
        @Query("fn_event_code") eventCode: String,
        @Query("fn_personnel_number") personalNumber: String,
    ): ListECPResponse

    @GET("hcis/api/qualifications/career/read-aspiration?business_code=POS&aspiration_type=ROTATION&aspiration=MCP")
    suspend fun mcpRotasi(
        @Query("begin_date_lte") begda: String,
        @Query("end_date_gte") endda: String,
        @Query("fn_event_code") eventCode: String,
        @Query("fn_personnel_number") personalNumber: String,
    ): ListECPResponse

    @GET("hcis/api/qualifications/career/read-aspiration?business_code=POS&aspiration_type=PROMOTION&aspiration=MCP")
    suspend fun mcpPromosi(
        @Query("begin_date_lte") begda: String,
        @Query("end_date_gte") endda: String,
        @Query("fn_event_code") eventCode: String,
        @Query("fn_personnel_number") personalNumber: String,
    ): ListECPResponse

    @GET("hcis/api/qualifications/career/read-aspiration?business_code=POS&aspiration_type=ROTATION&aspiration=SCP")
    suspend fun scpRotasi(
        @Query("begin_date_lte") begda: String,
        @Query("end_date_gte") endda: String,
        @Query("fn_event_code") eventCode: String,
        @Query("fn_personnel_number") personalNumber: String,
    ): ListECPResponse

    @GET("hcis/api/qualifications/career/read-aspiration?business_code=POS&aspiration_type=PROMOTION&aspiration=SCP")
    suspend fun scpPromosi(
        @Query("begin_date_lte") begda: String,
        @Query("end_date_gte") endda: String,
        @Query("fn_event_code") eventCode: String,
        @Query("fn_personnel_number") personalNumber: String,
    ): ListECPResponse

}