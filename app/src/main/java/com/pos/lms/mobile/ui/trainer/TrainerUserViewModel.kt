package com.pos.lms.mobile.ui.trainer

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.pos.lms.core.domain.usecase.trainer.TrainerUsecase

/**
 * Created by Muhammad Zaim Milzam on 22/04/21.
 * linkedin : Muhammad Zaim Milzam
 */
class TrainerUserViewModel @ViewModelInject constructor(private val trainerUsecase: TrainerUsecase) :
    ViewModel() {



}