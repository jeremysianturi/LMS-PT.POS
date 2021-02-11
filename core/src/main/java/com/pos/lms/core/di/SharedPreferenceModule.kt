package com.pos.lms.core.di

import android.content.Context
import com.pos.lms.core.utils.PreferenceEntity
import com.pos.lms.core.utils.UserPreference
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

/**
 * Created by Muhammad Zaim Milzam on 07/02/21.
 * linkedin : Muhammad Zaim Milzam
 */

@Module
@InstallIn(ApplicationComponent::class)
class SharedPreferenceModule {

    @Singleton
    @Provides
    fun preference (@ApplicationContext context: Context) : PreferenceEntity {
        return UserPreference(context).getPref()
    }
}