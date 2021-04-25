package com.pos.lms.core.di

import com.pos.lms.core.data.repository.*
import com.pos.lms.core.domain.repository.*
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@Module(includes = [NetworkModule::class])
@InstallIn(ApplicationComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideRepository(loginRepository: LoginRepository): ILoginRepository

    @Binds
    abstract fun provideCuriculumRepository(curiculumrepository: Curiculumrepository): ICuriculumRepository

    @Binds
    abstract fun provideDropdownRepository(dropDownRepository: DropDownRepository): IDropDownRepository

    @Binds
    abstract fun provideMateriRepository(materirepository: Materirepository): IMateriRepository

    @Binds
    abstract fun provideStudentRepository(studentRepository: StudentRepository): IStudentRepository

    @Binds
    abstract fun provideRoadmapRepository(roadmapRepository: RoadmapRepository): IRoadmapRepository

    @Binds
    abstract fun provideTrainerRepository(trainerRepository: TrainerRepository): ITrainerRepository

    @Binds
    abstract fun provideProfileRepository(profileRepository: ProfileRepository): IProfileRepository

    @Binds
    abstract fun provideMentorRepository(mentorRepository: MentorRepository): IMentorRepository

}