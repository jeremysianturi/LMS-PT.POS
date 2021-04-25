package com.pos.lms.core.domain.usecase.profile

import com.pos.lms.core.data.Resource
import com.pos.lms.core.data.repository.ProfileRepository
import com.pos.lms.core.domain.model.Avatar
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by Muhammad Zaim Milzam on 25/04/21.
 * linkedin : Muhammad Zaim Milzam
 */
class ProfileInteractor @Inject constructor(private val profileRepository: ProfileRepository) :
    ProfileUseCase {

    override fun getAvatar(userName: String): Flow<Resource<List<Avatar>>> =
        profileRepository.getAvatar(userName)
}