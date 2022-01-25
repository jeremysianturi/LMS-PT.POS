package com.pos.lms.mobile.ui.trainer.complete

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.pos.lms.core.domain.usecase.trainer.TrainerUsecase

class CompleteViewModel @ViewModelInject constructor(private val trainerUsecase: TrainerUsecase) :
    ViewModel() {

    val getList = trainerUsecase.getComplete("03").asLiveData()
}