package com.pos.lms.mobile.ui.mentor

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.pos.lms.core.domain.usecase.mentor.MentorUseCase


class MentorViewModel @ViewModelInject constructor(private val mentorUseCase: MentorUseCase) :
    ViewModel() {

    fun getMentorList(id: String, begda: String, endda: String) =
        mentorUseCase.getMentor(id, begda, endda).asLiveData()
}