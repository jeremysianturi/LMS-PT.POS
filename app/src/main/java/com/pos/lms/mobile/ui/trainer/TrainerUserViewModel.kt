package com.pos.lms.mobile.ui.trainer

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.pos.lms.core.domain.usecase.trainer.TrainerUsecase

class TrainerUserViewModel @ViewModelInject constructor(private val trainerUsecase: TrainerUsecase) :
    ViewModel() {



}