package com.pos.lms.mobile.ui.student.detailStudent.session.detail.schedule.detailSchedule.detailTest

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.pos.lms.core.data.source.remote.post.TestJawabanPost
import com.pos.lms.core.domain.usecase.student.StudentUsecase

/**
 * Created by Muhammad Zaim Milzam on 25/03/21.
 * linkedin : Muhammad Zaim Milzam
 */
class DetailTestViewModel @ViewModelInject constructor(private val studentUsecase: StudentUsecase) :
    ViewModel() {

    fun getPertanyaan(begda: String, endda: String) =
        studentUsecase.getTestPertanyaan(begda, endda).asLiveData()

    fun getSinglePertanyaan(idPertanyaan: Long) =
        studentUsecase.getTestPertanyaanWithId(idPertanyaan).asLiveData()

    fun getJawaban(questionId: String, begda: String, endda: String) =
        studentUsecase.getTestJawaban(questionId, begda, endda).asLiveData()

    fun postJawaban(testJawabanPost: TestJawabanPost) =
        studentUsecase.postTestAnswer(testJawabanPost).asLiveData()

}