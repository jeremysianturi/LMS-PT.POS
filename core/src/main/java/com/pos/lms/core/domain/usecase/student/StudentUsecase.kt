package com.pos.lms.core.domain.usecase.student

import com.pos.lms.core.data.Resource
import com.pos.lms.core.domain.model.Student
import kotlinx.coroutines.flow.Flow

/**
 * Created by Muhammad Zaim Milzam on 10/02/21.
 * linkedin : Muhammad Zaim Milzam
 */
interface StudentUsecase {

    fun getStudent() : Flow<Resource<List<Student>>>
}