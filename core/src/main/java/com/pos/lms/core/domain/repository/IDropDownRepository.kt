package com.pos.lms.core.domain.repository

import com.pos.lms.core.data.Resource
import com.pos.lms.core.domain.model.Company
import com.pos.lms.core.domain.model.Competency
import com.pos.lms.core.domain.model.PL
import com.pos.lms.core.domain.model.Type
import kotlinx.coroutines.flow.Flow

/**
 * Created by Muhammad Zaim Milzam on 08/02/21.
 * linkedin : Muhammad Zaim Milzam
 */
interface IDropDownRepository {

    fun getCompetency(begda : String, enda : String) : Flow<Resource<List<Competency>>>
    fun getPL(begda : String, enda : String) : Flow<Resource<List<PL>>>
    fun getType(begda : String, enda : String) : Flow<Resource<List<Type>>>
    fun getCompany(begda : String, enda : String) : Flow<Resource<List<Company>>>
}