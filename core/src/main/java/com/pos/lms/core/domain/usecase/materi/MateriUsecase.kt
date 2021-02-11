package com.pos.lms.core.domain.usecase.materi

import com.pos.lms.core.data.Resource
import com.pos.lms.core.domain.model.Materi
import kotlinx.coroutines.flow.Flow

/**
 * Created by Muhammad Zaim Milzam on 10/02/21.
 * linkedin : Muhammad Zaim Milzam
 */
interface MateriUsecase {

    fun getMateri(begda :String, enda : String) : Flow<Resource<List<Materi>>>
}