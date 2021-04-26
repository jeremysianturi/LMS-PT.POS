package com.pos.lms.core.domain.repository

import com.pos.lms.core.data.Resource
import com.pos.lms.core.domain.model.TrainerUser
import kotlinx.coroutines.flow.Flow

/**
 * Created by Muhammad Zaim Milzam on 22/04/21.
 * linkedin : Muhammad Zaim Milzam
 */
interface ITrainerRepository {

    fun getTrainerList(eventStatus: String): Flow<Resource<List<TrainerUser>>>

    fun getUpcoming(eventStatus: String): Flow<Resource<List<TrainerUser>>>

    fun getComplete(eventStatus: String): Flow<Resource<List<TrainerUser>>>
}