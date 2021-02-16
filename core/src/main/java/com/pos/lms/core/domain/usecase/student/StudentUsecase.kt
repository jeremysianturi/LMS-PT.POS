package com.pos.lms.core.domain.usecase.student

import com.pos.lms.core.data.Resource
import com.pos.lms.core.domain.model.*
import kotlinx.coroutines.flow.Flow

/**
 * Created by Muhammad Zaim Milzam on 10/02/21.
 * linkedin : Muhammad Zaim Milzam
 */
interface StudentUsecase {

    fun getStudent(parid :String) : Flow<Resource<List<Student>>>
    fun getDetailSession(eventId : String) : Flow<Resource<List<DetailSession>>>
    fun getSessionList(batchId : String, begda : String, endda :String) : Flow<Resource<List<SessionList>>>
    fun getForumList(batchId : String, begda : String, endda :String) : Flow<Resource<List<ForumList>>>
    fun getInsightList(batchId : String, begda : String, endda :String) : Flow<Resource<List<InsightList>>>


}