package com.pos.lms.core.domain.usecase.curiculum

import com.pos.lms.core.data.Resource
import com.pos.lms.core.data.source.remote.post.CuriculumCreate
import com.pos.lms.core.data.source.remote.post.CuriculumUpdate
import com.pos.lms.core.domain.model.Curiculum
import com.pos.lms.core.domain.model.Submit
import kotlinx.coroutines.flow.Flow


interface CuriculumUsecase {

    fun getCuriculum(begda: String, enda: String): Flow<Resource<List<Curiculum>>>

    fun updateSubmit(curiculumUpdate: CuriculumUpdate) : Flow<Resource<Submit>>

    fun createCuriculum(curiculumCreate: CuriculumCreate) : Flow<Resource<Submit>>

    fun getSearchCuriculum(search: String): Flow<List<Curiculum>>
}