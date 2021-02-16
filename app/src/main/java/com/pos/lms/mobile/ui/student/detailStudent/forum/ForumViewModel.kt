package com.pos.lms.mobile.ui.student.detailStudent.forum

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.pos.lms.core.domain.usecase.student.StudentUsecase

class ForumViewModel @ViewModelInject constructor(private val studentUsecase: StudentUsecase) : ViewModel(){

    fun getDetailSession(eventId: String) = studentUsecase.getDetailSession(eventId).asLiveData()

    fun getForumList(batchId : String, begda :String, endda : String) = studentUsecase.getForumList(batchId, begda, endda).asLiveData()
}