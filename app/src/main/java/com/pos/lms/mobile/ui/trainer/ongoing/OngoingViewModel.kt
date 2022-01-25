package com.pos.lms.mobile.ui.trainer.ongoing

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.pos.lms.core.domain.usecase.trainer.TrainerUsecase

class OngoingViewModel @ViewModelInject constructor(private val trainerUsecase: TrainerUsecase) :
    ViewModel() {

    val getList = trainerUsecase.getTrainerList("01").asLiveData()
}