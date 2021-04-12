package com.pos.lms.mobile.ui.student.detailStudent.session.detail.absensi

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.pos.lms.core.domain.usecase.student.StudentUsecase

class AbsensiViewModel @ViewModelInject constructor(private val studentUsecase: StudentUsecase) :
    ViewModel() {

    fun getAbsensi(parId: String, sessionId: String) =
        studentUsecase.getAbsensi(parId, sessionId).asLiveData()

}