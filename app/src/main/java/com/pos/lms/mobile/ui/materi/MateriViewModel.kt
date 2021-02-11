package com.pos.lms.mobile.ui.materi

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.pos.lms.core.domain.usecase.materi.MateriUsecase

/**
 * Created by Muhammad Zaim Milzam on 10/02/21.
 * linkedin : Muhammad Zaim Milzam
 */
class MateriViewModel @ViewModelInject constructor(private val materiUsecase: MateriUsecase) : ViewModel() {

    fun getMateri(begda :String, enda : String) = materiUsecase.getMateri(begda, enda).asLiveData()
}