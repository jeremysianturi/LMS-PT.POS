package com.pos.lms.mobile.ui.materi

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.pos.lms.core.domain.usecase.materi.MateriUsecase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flatMapLatest

/**
 * Created by Muhammad Zaim Milzam on 10/02/21.
 * linkedin : Muhammad Zaim Milzam
 */
@ExperimentalCoroutinesApi
class MateriViewModel @ViewModelInject constructor(private val materiUsecase: MateriUsecase) :
    ViewModel() {

    val searchQuery = MutableStateFlow("")

    private val materiFlow = searchQuery.flatMapLatest {
        materiUsecase.getSearchMateri(it)
    }

    val search = materiFlow.asLiveData()

    fun getMateri(begda: String, enda: String) = materiUsecase.getMateri(begda, enda).asLiveData()

}