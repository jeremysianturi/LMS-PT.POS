package com.pos.lms.mobile.ui.changePassword

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.pos.lms.core.domain.usecase.login.LoginUsecase
import com.pos.lms.mobile.R
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
class ChangePasswordViewModel @ViewModelInject constructor(private val loginUsecase: LoginUsecase) :
    ViewModel() {

    private val _loginForm = MutableLiveData<ChangePasswordFormState>()
    val loginFormState: LiveData<ChangePasswordFormState> = _loginForm

    fun loginDataChanged(password: String, coPassword: String) {
        if (!isPasswordValid(password)) {
            _loginForm.value = ChangePasswordFormState(passwordError = R.string.invalid_password)
        } else if (!isUserNameValid(password, coPassword)) {
            _loginForm.value =
                ChangePasswordFormState(confirmPasswordError = R.string.invalid_password_match)
        } else {
            _loginForm.value = ChangePasswordFormState(isDataValid = true)
        }
    }

    // A placeholder password validation check
    private fun isPasswordValid(password: String): Boolean {
        return password.length > 5
    }

    // A placeholder username validation check
    private fun isUserNameValid(password: String, coPassword: String): Boolean {
        return password == coPassword
    }

    fun changePassword(username: String, password: String) =
        loginUsecase.changePassword(username, password).asLiveData()

}