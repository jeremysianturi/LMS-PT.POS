package com.pos.lms.core.domain.usecase.curiculum

import com.pos.lms.core.data.Resource
import com.pos.lms.core.data.repository.Curiculumrepository
import com.pos.lms.core.data.source.remote.post.CuriculumCreate
import com.pos.lms.core.data.source.remote.post.CuriculumUpdate
import com.pos.lms.core.domain.model.Curiculum
import com.pos.lms.core.domain.model.Submit
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by Muhammad Zaim Milzam on 08/02/21.
 * linkedin : Muhammad Zaim Milzam
 */
class CuriculumInteractor @Inject constructor(private val curiculumrepository: Curiculumrepository) :
    CuriculumUsecase {

    override fun getCuriculum(begda: String, enda: String): Flow<Resource<List<Curiculum>>> =
        curiculumrepository.getCuriculum(begda, enda)

    override fun updateSubmit(curiculumUpdate: CuriculumUpdate): Flow<Resource<Submit>> =
        curiculumrepository.updateCuriculum(curiculumUpdate)

    override fun createCuriculum(curiculumCreate: CuriculumCreate): Flow<Resource<Submit>> =
        curiculumrepository.createCuriculum(curiculumCreate)


}