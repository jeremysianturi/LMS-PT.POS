package com.pos.lms.mobile

import com.pos.lms.core.domain.usecase.curiculum.CuriculumInteractor
import com.pos.lms.core.domain.usecase.curiculum.CuriculumUsecase
import com.pos.lms.core.domain.usecase.dropdown.DropdownInteractor
import com.pos.lms.core.domain.usecase.dropdown.DropdownUsecase
import com.pos.lms.core.domain.usecase.login.LoginInteractor
import com.pos.lms.core.domain.usecase.login.LoginUsecase
import com.pos.lms.core.domain.usecase.materi.MateriInteractor
import com.pos.lms.core.domain.usecase.materi.MateriUsecase
import com.pos.lms.core.domain.usecase.mentor.MentorInteractor
import com.pos.lms.core.domain.usecase.mentor.MentorUseCase
import com.pos.lms.core.domain.usecase.profile.ProfileInteractor
import com.pos.lms.core.domain.usecase.profile.ProfileUseCase
import com.pos.lms.core.domain.usecase.roadmap.RoadmapInteractor
import com.pos.lms.core.domain.usecase.roadmap.RoadmapUsecase
import com.pos.lms.core.domain.usecase.student.StudentInteractor
import com.pos.lms.core.domain.usecase.student.StudentUsecase
import com.pos.lms.core.domain.usecase.trainer.TrainerInteractor
import com.pos.lms.core.domain.usecase.trainer.TrainerUsecase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
abstract class AppModule {

    @Binds
    abstract fun provideLoginUsecase(loginInteractor: LoginInteractor): LoginUsecase

    @Binds
    abstract fun provideCuriculumUseCase(curiculumInteractor: CuriculumInteractor): CuriculumUsecase

    @Binds
    abstract fun provideDropdownUseCase(dropdownInteractor: DropdownInteractor): DropdownUsecase

    @Binds
    abstract fun provideMateriUseCase(materiInteractor: MateriInteractor): MateriUsecase

    @Binds
    abstract fun provideStudentUseCase(studentInteractor: StudentInteractor): StudentUsecase

    @Binds
    abstract fun provideRoadmapUseCase(roadmapInteractor: RoadmapInteractor): RoadmapUsecase

    @Binds
    abstract fun provideTrainerUseCase(trainerInteractor: TrainerInteractor): TrainerUsecase

    @Binds
    abstract fun provideProfileUseCase(profileInteractor: ProfileInteractor): ProfileUseCase

    @Binds
    abstract fun provideMentoreUseCase(mentorInteractor: MentorInteractor): MentorUseCase

}