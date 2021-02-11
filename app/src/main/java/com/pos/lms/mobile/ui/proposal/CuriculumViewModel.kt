package com.pos.lms.mobile.ui.proposal

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.pos.lms.core.domain.usecase.curiculum.CuriculumUsecase

/**
 * Created by Muhammad Zaim Milzam on 09/02/21.
 * linkedin : Muhammad Zaim Milzam
 */
class CuriculumViewModel @ViewModelInject constructor(private val curiculumUsecase: CuriculumUsecase) :
    ViewModel() {

    fun getCuriculum(begda: String, enda: String) =
        curiculumUsecase.getCuriculum(begda, enda).asLiveData()
}