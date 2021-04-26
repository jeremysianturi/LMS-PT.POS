package com.pos.lms.core.domain.usecase.trainer

import com.pos.lms.core.data.Resource
import com.pos.lms.core.data.repository.TrainerRepository
import com.pos.lms.core.domain.model.TrainerUser
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by Muhammad Zaim Milzam on 10/02/21.
 * linkedin : Muhammad Zaim Milzam
 */

class TrainerInteractor @Inject constructor(private val trainerRepository: TrainerRepository) :
    TrainerUsecase {

    override fun getTrainerList(eventStatus: String): Flow<Resource<List<TrainerUser>>> =
        trainerRepository.getTrainerList(eventStatus)

    override fun getUpcoming(eventStatus: String): Flow<Resource<List<TrainerUser>>> =
        trainerRepository.getUpcoming(eventStatus)

    override fun getComplete(eventStatus: String): Flow<Resource<List<TrainerUser>>> =
        trainerRepository.getComplete(eventStatus)

}