package com.pos.lms.mobile.ui.student.detailStudent.session.detail.mentoring.detail

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.pos.lms.core.data.source.remote.post.MentoringChatPost
import com.pos.lms.core.domain.usecase.student.StudentUsecase

class DetailMentoringViewModel @ViewModelInject constructor(private val studentUsecase: StudentUsecase) :
    ViewModel() {

    fun getChat(mentoringId: String) = studentUsecase.getMentoringChat(mentoringId).asLiveData()

    fun postChat(mentoringPostChatPost: MentoringChatPost) =
        studentUsecase.postMentoringChat(mentoringPostChatPost).asLiveData()

    fun getDetail(mentoringId: String, begda: String, endda: String) =
        studentUsecase.getMentoringDetail(mentoringId, begda, endda).asLiveData()
}