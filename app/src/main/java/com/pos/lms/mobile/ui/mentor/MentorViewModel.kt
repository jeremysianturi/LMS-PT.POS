package com.pos.lms.mobile.ui.mentor

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.pos.lms.core.domain.usecase.mentor.MentorUseCase

/**
 * Created by Muhammad Zaim Milzam on 20/04/21.
 * linkedin : Muhammad Zaim Milzam
 */

/**
 * kurang di support
 * jd mau gamau yg penting jd
 *
 */

class MentorViewModel @ViewModelInject constructor(private val mentorUseCase: MentorUseCase) :
    ViewModel() {

    fun getMentorList(id: String, begda: String, endda: String) =
        mentorUseCase.getMentor(id, begda, endda).asLiveData()
}