package com.pos.lms.core.domain.usecase.materi

import com.pos.lms.core.data.Resource
import com.pos.lms.core.domain.model.Materi
import kotlinx.coroutines.flow.Flow


interface MateriUsecase {

    fun getMateri(begda :String, enda : String) : Flow<Resource<List<Materi>>>

    fun getSearchMateri(search: String): Flow<List<Materi>>
}