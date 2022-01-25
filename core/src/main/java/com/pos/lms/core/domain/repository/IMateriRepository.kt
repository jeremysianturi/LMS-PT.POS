package com.pos.lms.core.domain.repository

import com.pos.lms.core.data.Resource
import com.pos.lms.core.domain.model.Materi
import kotlinx.coroutines.flow.Flow


interface IMateriRepository {

    fun getMateri(begda: String, endda: String): Flow<Resource<List<Materi>>>

    fun getSearchMateri(search: String): Flow<List<Materi>>
}