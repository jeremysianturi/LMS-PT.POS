package com.pos.lms.mobile.ui.student.detailStudent.insight

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.pos.lms.core.domain.usecase.student.StudentUsecase

class InsightViewModel @ViewModelInject constructor(private val studentUsecase: StudentUsecase) :
    ViewModel() {

    fun getInsightList(batchId: String, begda: String, endda: String) =
        studentUsecase.getInsightList(batchId, begda, endda).asLiveData()
}