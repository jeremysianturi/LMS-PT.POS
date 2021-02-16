package com.pos.lms.mobile.ui.home

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.pos.lms.core.domain.usecase.login.LoginUsecase

/**
 * Created by Muhammad Zaim Milzam on 15/02/21.
 * linkedin : Muhammad Zaim Milzam
 */
class HomeViewModel @ViewModelInject constructor(private val loginUsecase: LoginUsecase) :
    ViewModel() {

    fun  getParId(token : String) = loginUsecase.getParid(token).asLiveData()
}