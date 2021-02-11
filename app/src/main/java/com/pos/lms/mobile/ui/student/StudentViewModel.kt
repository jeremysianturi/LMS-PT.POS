package com.pos.lms.mobile.ui.student

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.pos.lms.core.domain.usecase.student.StudentUsecase

/**
 * Created by Muhammad Zaim Milzam on 10/02/21.
 * linkedin : Muhammad Zaim Milzam
 */
class StudentViewModel @ViewModelInject constructor(private val studentUsecase: StudentUsecase) : ViewModel(){

    fun getStudent() = studentUsecase.getStudent().asLiveData()
}