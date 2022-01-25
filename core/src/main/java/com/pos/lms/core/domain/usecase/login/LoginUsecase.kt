package com.pos.lms.core.domain.usecase.login

import com.pos.lms.core.data.Resource
import com.pos.lms.core.data.source.remote.post.LoginPost
import com.pos.lms.core.domain.model.Login
import com.pos.lms.core.domain.model.ParId
import com.pos.lms.core.domain.model.Submit
import kotlinx.coroutines.flow.Flow

interface LoginUsecase {
    fun login(loginPost: LoginPost): Flow<Resource<Login>>
    fun getParid(typeId: String): Flow<Resource<List<ParId>>>
    fun changePassword(username: String, password: String): Flow<Resource<Submit>>
}