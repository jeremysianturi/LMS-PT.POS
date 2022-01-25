package com.pos.lms.mobile.ui.home

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.pos.lms.core.domain.usecase.login.LoginUsecase


class HomeViewModel @ViewModelInject constructor(private val loginUsecase: LoginUsecase) :
    ViewModel() {

    fun getParId(typeId: String) = loginUsecase.getParid(typeId).asLiveData()
}