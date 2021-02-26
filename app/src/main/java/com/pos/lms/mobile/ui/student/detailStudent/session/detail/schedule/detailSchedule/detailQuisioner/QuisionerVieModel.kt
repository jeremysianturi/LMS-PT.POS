package com.pos.lms.mobile.ui.student.detailStudent.session.detail.schedule.detailSchedule.detailQuisioner

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.pos.lms.core.domain.model.QuisionerAnswer
import com.pos.lms.core.domain.usecase.student.StudentUsecase

/**
 * Created by Muhammad Zaim Milzam on 08/01/21.
 * linkedin : Muhammad Zaim Milzam
 */
class QuisionerVieModel @ViewModelInject constructor(private val studentUsecase: StudentUsecase) :
    ViewModel() {

    fun getQuisionerAnswer(quisionerId: String, begda: String, endda: String) =
        studentUsecase.getQuisionerAnswer(quisionerId, begda, endda).asLiveData()

    fun setChecketQuisionerUpdate(answer: QuisionerAnswer, newState: Boolean) =
        studentUsecase.setCheckedQuisionerAnswer(answer, newState)

    fun getCheckedAnswer() = studentUsecase.getCheckedQuisionerAnswer().asLiveData()

    fun getQuisionerPertanyaan(
        objects: String,
        tableCode: String,
        relation: String,
        otype: String,
        begda: String,
        endda: String
    ) = studentUsecase.getQuisionerPertanyaan(objects, tableCode, relation, otype, begda, endda)
        .asLiveData()

    fun getQuisionerPertanyaanWithId(id: Long) =
        studentUsecase.getQuisionerPertanyaanWithId(id).asLiveData()

    fun deleteQuisionerPertanyaan() = studentUsecase.deleteQuisionerPertanyaan()
}