package com.pos.lms.core.domain.usecase.trainer

import com.pos.lms.core.data.Resource
import com.pos.lms.core.domain.model.TrainerUser
import kotlinx.coroutines.flow.Flow

/**
 * Created by Muhammad Zaim Milzam on 10/02/21.
 * linkedin : Muhammad Zaim Milzam
 */
interface TrainerUsecase {

    fun getTrainerList(eventStatus : String) : Flow<Resource<List<TrainerUser>>>

    fun getUpcoming(eventStatus: String): Flow<Resource<List<TrainerUser>>>

    fun getComplete(eventStatus: String): Flow<Resource<List<TrainerUser>>>
}