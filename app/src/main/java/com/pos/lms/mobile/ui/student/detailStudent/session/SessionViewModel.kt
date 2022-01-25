package com.pos.lms.mobile.ui.student.detailStudent.session

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.pos.lms.core.domain.usecase.student.StudentUsecase

class SessionViewModel @ViewModelInject constructor(private val studentUsecase: StudentUsecase) :
    ViewModel() {

    fun getDetailSession(eventId: String) = studentUsecase.getDetailSession(eventId).asLiveData()

    fun getSessionList(batchId: String, begda: String, endda: String) =
        studentUsecase.getSessionList(batchId, begda, endda).asLiveData()
}