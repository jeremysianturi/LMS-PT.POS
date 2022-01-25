package com.pos.lms.mobile.ui.proposal.update

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.pos.lms.core.data.source.remote.post.CuriculumUpdate
import com.pos.lms.core.domain.usecase.curiculum.CuriculumUsecase
import com.pos.lms.core.domain.usecase.dropdown.DropdownUsecase

class UpdateCuriculumViewModel @ViewModelInject constructor(
    private val dropdownUsecase: DropdownUsecase,
    private val curiculumUsecase: CuriculumUsecase
) : ViewModel() {

    fun updateCuriculum(curiculumUpdate: CuriculumUpdate) =
        curiculumUsecase.updateSubmit(curiculumUpdate).asLiveData()

    fun getCompetency(begda: String, enda: String) =
        dropdownUsecase.getCompetency(begda, enda).asLiveData()

    fun getPL(begda: String, enda: String) = dropdownUsecase.getPL(begda, enda).asLiveData()
    fun getType(begda: String, enda: String) = dropdownUsecase.getType(begda, enda).asLiveData()
    fun getCompany(begda: String, enda: String) =
        dropdownUsecase.getCompany(begda, enda).asLiveData()
}