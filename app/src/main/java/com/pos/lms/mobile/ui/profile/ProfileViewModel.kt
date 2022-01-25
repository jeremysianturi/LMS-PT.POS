package com.pos.lms.mobile.ui.profile

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.pos.lms.core.domain.usecase.profile.ProfileUseCase

class ProfileViewModel @ViewModelInject constructor(private val profileUseCase: ProfileUseCase) :
    ViewModel() {

    fun getAvatar(username: String) = profileUseCase.getAvatar(username).asLiveData()
}