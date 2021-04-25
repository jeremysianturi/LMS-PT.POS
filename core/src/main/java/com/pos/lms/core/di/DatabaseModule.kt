package com.pos.lms.core.di

import android.content.Context
import androidx.room.Room
import com.pos.lms.core.data.source.local.room.LmsDataBase
import com.pos.lms.core.data.source.local.room.dao.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): LmsDataBase = Room.databaseBuilder(
        context,
        LmsDataBase::class.java, "LMS.db"
    ).fallbackToDestructiveMigration().build()

    @Provides
    fun provideLoginDao(database: LmsDataBase): LoginDao = database.loginDao()

    @Provides
    fun provideDropdownDao(database: LmsDataBase): DropDownDao = database.dropdown()

    @Provides
    fun provideCuriculumDao(database: LmsDataBase): CuriculumnDao = database.curiculumDao()

    @Provides
    fun provideSubmitDao(database: LmsDataBase): SubmitDao = database.submit()

    @Provides
    fun provideMateriDao(database: LmsDataBase): MateriDao = database.materi()

    @Provides
    fun provideStudentDao(database: LmsDataBase): StudentDao = database.student()

    @Provides
    fun provideRoadmapDao(database: LmsDataBase): RoadmapDao = database.roadmapDao()

    @Provides
    fun provideTrainerDao(database: LmsDataBase): TrainerDao = database.trainerDao()

    @Provides
    fun provideProfileDao(database: LmsDataBase): ProfileDao = database.profileDao()

    @Provides
    fun provideMentorDao(database: LmsDataBase): MentorDao = database.mentorDao()
}