package com.pos.lms.mobile.ui.proposal.create

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.pos.lms.core.data.source.remote.post.CuriculumCreate
import com.pos.lms.core.domain.usecase.curiculum.CuriculumUsecase
import com.pos.lms.core.domain.usecase.dropdown.DropdownUsecase

/**
 * Created by Muhammad Zaim Milzam on 09/02/21.
 * linkedin : Muhammad Zaim Milzam
 */
class CreateCuriculumViewModel @ViewModelInject constructor(
    private val dropdownUsecase: DropdownUsecase,
    private val curiculumUsecase: CuriculumUsecase
) : ViewModel() {

    fun createCuriculum(createCuriculum: CuriculumCreate) =
        curiculumUsecase.createCuriculum(createCuriculum).asLiveData()

    fun getCompetency(begda: String, enda: String) =
        dropdownUsecase.getCompetency(begda, enda).asLiveData()

    fun getPL(begda: String, enda: String) = dropdownUsecase.getPL(begda, enda).asLiveData()
    fun getType(begda: String, enda: String) = dropdownUsecase.getType(begda, enda).asLiveData()
    fun getCompany(begda: String, enda: String) =
        dropdownUsecase.getCompany(begda, enda).asLiveData()

}