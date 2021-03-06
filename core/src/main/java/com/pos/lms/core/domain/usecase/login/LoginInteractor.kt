package com.pos.lms.core.domain.usecase.login

import com.pos.lms.core.data.Resource
import com.pos.lms.core.data.source.remote.post.LoginPost
import com.pos.lms.core.domain.model.Login
import com.pos.lms.core.domain.model.ParId
import com.pos.lms.core.domain.model.Submit
import com.pos.lms.core.domain.repository.ILoginRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LoginInteractor @Inject constructor(private val loginRepository: ILoginRepository) :
    LoginUsecase {
    override fun login(loginPost: LoginPost): Flow<Resource<Login>> =
        loginRepository.login(loginPost)

    override fun getParid(typeId : String): Flow<Resource<List<ParId>>> =
        loginRepository.getParId(typeId)

    override fun changePassword(username: String, password: String): Flow<Resource<Submit>>  =
        loginRepository.changePassword(username, password)
}