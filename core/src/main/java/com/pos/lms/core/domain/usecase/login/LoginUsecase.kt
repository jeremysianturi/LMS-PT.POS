package com.pos.lms.core.domain.usecase.login

import com.pos.lms.core.data.Resource
import com.pos.lms.core.data.source.remote.post.LoginPost
import com.pos.lms.core.domain.model.Login
import com.pos.lms.core.domain.model.ParId
import kotlinx.coroutines.flow.Flow

/**
 * Created by Muhammad Zaim Milzam on 26/01/21.
 * linkedin : Muhammad Zaim Milzam
 */
interface LoginUsecase  {

    fun login(loginPost: LoginPost) : Flow<Resource<Login>>
    fun getParid(token : String) :Flow<Resource<List<ParId>>>
}