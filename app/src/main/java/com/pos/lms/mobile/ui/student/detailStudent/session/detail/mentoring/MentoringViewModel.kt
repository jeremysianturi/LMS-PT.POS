package com.pos.lms.mobile.ui.student.detailStudent.session.detail.mentoring

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.pos.lms.core.domain.usecase.student.StudentUsecase

class MentoringViewModel @ViewModelInject constructor(private val studentUsecase: StudentUsecase) :
    ViewModel() {

    fun getMentoringList(
        sessionId: String,
        id: String,
        begda: String,
        endda: String
    ) = studentUsecase.getMentoring(sessionId, id, begda, endda).asLiveData()
}