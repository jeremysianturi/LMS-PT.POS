package com.pos.lms.mobile.ui.login

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.pos.lms.core.data.source.remote.post.LoginPost
import com.pos.lms.core.domain.usecase.login.LoginUsecase

/**
 * Created by Muhammad Zaim Milzam on 05/02/21.
 * linkedin : Muhammad Zaim Milzam
 */
class LoginViewModel @ViewModelInject constructor(private val loginUsecase: LoginUsecase) :
    ViewModel() {

    fun getLogin(loginPost: LoginPost) = loginUsecase.login(loginPost).asLiveData()

//    val getParId = loginUsecase.getParid().asLiveData()

    fun  getParId(token : String) = loginUsecase.getParid(token).asLiveData()
    
}