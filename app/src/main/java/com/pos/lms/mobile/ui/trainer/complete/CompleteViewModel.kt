package com.pos.lms.mobile.ui.trainer.complete

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.pos.lms.core.domain.usecase.trainer.TrainerUsecase

/**
 * Created by Muhammad Zaim Milzam on 23/04/21.
 * linkedin : Muhammad Zaim Milzam
 */
class CompleteViewModel @ViewModelInject constructor(private val trainerUsecase: TrainerUsecase) :
    ViewModel() {

    val getList = trainerUsecase.getComplete("03").asLiveData()
}