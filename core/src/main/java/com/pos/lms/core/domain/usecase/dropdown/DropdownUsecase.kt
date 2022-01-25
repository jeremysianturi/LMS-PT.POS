package com.pos.lms.core.domain.usecase.dropdown

import com.pos.lms.core.data.Resource
import com.pos.lms.core.domain.model.Company
import com.pos.lms.core.domain.model.Competency
import com.pos.lms.core.domain.model.PL
import com.pos.lms.core.domain.model.Type
import kotlinx.coroutines.flow.Flow


interface DropdownUsecase {
    fun getCompetency(begda: String, enda : String) : Flow<Resource<List<Competency>>>
    fun getPL(begda: String, enda : String) : Flow<Resource<List<PL>>>
    fun getType(begda: String, enda : String) : Flow<Resource<List<Type>>>
    fun getCompany(begda: String, enda : String) : Flow<Resource<List<Company>>>
}