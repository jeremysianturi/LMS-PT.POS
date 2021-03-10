package com.pos.lms.core.domain.usecase.materi

import com.pos.lms.core.data.Resource
import com.pos.lms.core.data.repository.Materirepository
import com.pos.lms.core.domain.model.Materi
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by Muhammad Zaim Milzam on 10/02/21.
 * linkedin : Muhammad Zaim Milzam
 */
class MateriInteractor @Inject constructor(private val materirepository: Materirepository) :
    MateriUsecase {
    override fun getMateri(begda: String, enda: String): Flow<Resource<List<Materi>>> =
        materirepository.getMateri(begda, enda)

    override fun getSearchMateri(search: String): Flow<List<Materi>> =
        materirepository.getSearchMateri(search)
}