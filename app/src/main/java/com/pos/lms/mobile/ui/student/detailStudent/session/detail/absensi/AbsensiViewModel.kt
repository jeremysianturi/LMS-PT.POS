package com.pos.lms.mobile.ui.student.detailStudent.session.detail.absensi

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pos.lms.core.domain.usecase.student.StudentUsecase

class AbsensiViewModel @ViewModelInject constructor(private val studentUsecase: StudentUsecase) :
    ViewModel() {
    private val images = MutableLiveData<String>()

}