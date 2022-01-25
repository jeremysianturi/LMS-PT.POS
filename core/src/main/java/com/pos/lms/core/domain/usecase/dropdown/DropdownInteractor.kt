package com.pos.lms.core.domain.usecase.dropdown

import com.pos.lms.core.data.Resource
import com.pos.lms.core.data.repository.DropDownRepository
import com.pos.lms.core.domain.model.Company
import com.pos.lms.core.domain.model.Competency
import com.pos.lms.core.domain.model.PL
import com.pos.lms.core.domain.model.Type
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DropdownInteractor @Inject constructor(private val dropDownRepository: DropDownRepository) :
    DropdownUsecase {

    override fun getCompetency(begda: String, enda: String): Flow<Resource<List<Competency>>> =
        dropDownRepository.getCompetency(begda, enda)

    override fun getPL(begda: String, enda: String): Flow<Resource<List<PL>>> =
        dropDownRepository.getPL(begda, enda)

    override fun getType(begda: String, enda: String): Flow<Resource<List<Type>>> =
        dropDownRepository.getType(begda, enda)

    override fun getCompany(begda: String, enda: String): Flow<Resource<List<Company>>> =
        dropDownRepository.getCompany(begda, enda)
}