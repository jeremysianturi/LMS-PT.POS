package com.pos.lms.mobile.ui.student

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.pos.lms.core.domain.usecase.student.StudentUsecase

class StudentViewModel @ViewModelInject constructor(private val studentUsecase: StudentUsecase) : ViewModel(){

    fun getStudent(parid : String) = studentUsecase.getStudent(parid).asLiveData()
}