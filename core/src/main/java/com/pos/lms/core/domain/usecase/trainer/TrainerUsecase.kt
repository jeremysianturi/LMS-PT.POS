package com.pos.lms.core.domain.usecase.trainer

import com.pos.lms.core.data.Resource
import com.pos.lms.core.domain.model.TrainerUser
import kotlinx.coroutines.flow.Flow

/**
 * Created by Muhammad Zaim Milzam on 10/02/21.
 * linkedin : Muhammad Zaim Milzam
 */
interface TrainerUsecase {

    fun getTrainerList(eventStatus : Int) : Flow<Resource<List<TrainerUser>>>
}