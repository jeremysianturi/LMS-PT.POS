package com.pos.lms.mobile.ui.proposal

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.pos.lms.core.domain.usecase.curiculum.CuriculumUsecase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flatMapLatest

@ExperimentalCoroutinesApi
class CuriculumViewModel @ViewModelInject constructor(private val curiculumUsecase: CuriculumUsecase) :
    ViewModel() {

    val searchQuery = MutableStateFlow("")

    private val curiculumFlow = searchQuery.flatMapLatest {
        curiculumUsecase.getSearchCuriculum(it)
    }

    val search = curiculumFlow.asLiveData()

    fun getCuriculum(begda: String, enda: String) =
        curiculumUsecase.getCuriculum(begda, enda).asLiveData()
}