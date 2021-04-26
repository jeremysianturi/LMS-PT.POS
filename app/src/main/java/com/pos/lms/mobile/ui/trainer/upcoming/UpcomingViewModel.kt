package com.pos.lms.mobile.ui.trainer.upcoming

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.pos.lms.core.domain.usecase.trainer.TrainerUsecase

/**
 * Created by Muhammad Zaim Milzam on 23/04/21.
 * linkedin : Muhammad Zaim Milzam
 */
class UpcomingViewModel @ViewModelInject constructor(private val trainerUsecase: TrainerUsecase) :
    ViewModel() {

    val getList = trainerUsecase.getUpcoming("02").asLiveData()
}