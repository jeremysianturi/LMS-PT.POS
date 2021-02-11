package com.pos.lms.core.domain.usecase.student

import com.pos.lms.core.data.Resource
import com.pos.lms.core.data.repository.StudentRepository
import com.pos.lms.core.domain.model.Student
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by Muhammad Zaim Milzam on 10/02/21.
 * linkedin : Muhammad Zaim Milzam
 */
class StudentInteractor @Inject constructor(private val studentRepository: StudentRepository) : StudentUsecase {
    override fun getStudent(): Flow<Resource<List<Student>>> =
        studentRepository.getStudent()
}