package com.pos.lms.core.domain.repository

import com.pos.lms.core.data.Resource
import com.pos.lms.core.data.source.remote.post.LoginPost
import com.pos.lms.core.domain.model.Account
import com.pos.lms.core.domain.model.Login
import com.pos.lms.core.domain.model.ParId
import com.pos.lms.core.domain.model.Submit
import kotlinx.coroutines.flow.Flow

interface ILoginRepository {
    fun login(loginPost: LoginPost): Flow<Resource<Login>>
    fun getParId(typeId: String): Flow<Resource<List<ParId>>>
    fun changePassword(username: String, password: String): Flow<Resource<Submit>>
    fun account(): Flow<Resource<Account>>
}