package com.pos.lms.core.domain.usecase.login

import com.pos.lms.core.data.Resource
import com.pos.lms.core.data.source.remote.post.LoginPost
import com.pos.lms.core.domain.model.Login
import com.pos.lms.core.domain.model.ParId
import com.pos.lms.core.domain.model.Submit
import com.pos.lms.core.domain.repository.ILoginRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by Muhammad Zaim Milzam on 26/01/21.
 * linkedin : Muhammad Zaim Milzam
 */
class LoginInteractor @Inject constructor(private val loginRepository: ILoginRepository) :
    LoginUsecase {
    override fun login(loginPost: LoginPost): Flow<Resource<Login>> =
        loginRepository.login(loginPost)

    override fun getParid(token : String): Flow<Resource<List<ParId>>> =
        loginRepository.getParId(token)

    override fun changePassword(username: String, password: String): Flow<Resource<Submit>>  =
        loginRepository.changePassword(username, password)
}