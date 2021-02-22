package com.pos.lms.mobile.ui.student.detailStudent.session.detail.schedule.detailSchedule

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.pos.lms.core.domain.usecase.student.StudentUsecase

class DetailScheduleViewModel @ViewModelInject constructor(private val studentUsecase: StudentUsecase) :
    ViewModel() {

    fun getMateri(
        parentId: String,
        begda: String,
        endda: String
    ) = studentUsecase.getMateriSchedule(parentId, begda, endda).asLiveData()

    fun getTest(
        scheduleId: String,
        begda: String,
        endda: String
    ) = studentUsecase.getTestSchedule(scheduleId, begda, endda).asLiveData()

    fun getQuisioner(
        scheduleId: String,
        begda: String,
        endda: String
    ) = studentUsecase.getQuisionerSchedule(scheduleId, begda, endda).asLiveData()

    fun getTrainer(
        parentId: String,
        begda: String,
        endda: String
    ) = studentUsecase.getTrainerSchedule(parentId, begda, endda).asLiveData()

    fun getRoom(
        parentId: String,
        begda: String,
        endda: String
    ) = studentUsecase.getRoomSchedule(parentId, begda, endda).asLiveData()

}