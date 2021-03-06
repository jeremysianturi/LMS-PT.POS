package com.pos.lms.mobile.ui.student.detailStudent.session.detail.schedule

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.pos.lms.core.domain.usecase.student.StudentUsecase

class ScheduleViewModel @ViewModelInject constructor(private val studentUsecase: StudentUsecase) :
    ViewModel() {

    fun getScheduleList(sessionId : String) = studentUsecase.getSchedule(sessionId).asLiveData()
}