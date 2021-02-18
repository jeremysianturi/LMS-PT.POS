package com.pos.lms.mobile.ui.student.detailStudent.session.detail.schedule.detailSchedule

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.pos.lms.core.domain.usecase.student.StudentUsecase

class DetailScheduleViewModel @ViewModelInject constructor(private val studentUsecase: StudentUsecase) :
    ViewModel() {

}