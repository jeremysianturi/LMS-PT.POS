package com.pos.lms.mobile.ui.profile

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.pos.lms.core.domain.usecase.profile.ProfileUseCase

/**
 * Created by Muhammad Zaim Milzam on 20/04/21.
 * linkedin : Muhammad Zaim Milzam
 */

/**
 * kurang di support
 * jd mau gamau yg penting jd
 */

class ProfileViewModel @ViewModelInject constructor(private val profileUseCase: ProfileUseCase) :
    ViewModel() {

    fun getAvatar(username: String) = profileUseCase.getAvatar(username).asLiveData()
}