package com.pos.lms.mobile.ui.trainer.upcoming

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.pos.lms.core.domain.usecase.trainer.TrainerUsecase

class UpcomingViewModel @ViewModelInject constructor(private val trainerUsecase: TrainerUsecase) :
    ViewModel() {

    val getList = trainerUsecase.getUpcoming("02").asLiveData()
}