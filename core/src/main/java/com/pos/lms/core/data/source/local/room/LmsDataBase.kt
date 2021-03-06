package com.pos.lms.core.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.pos.lms.core.data.source.local.entity.ItemParIdEntity
import com.pos.lms.core.data.source.local.entity.LoginEntity
import com.pos.lms.core.data.source.local.entity.SubmitEntity
import com.pos.lms.core.data.source.local.entity.account.AccountEntity
import com.pos.lms.core.data.source.local.entity.curiculum.CuriculumEntity
import com.pos.lms.core.data.source.local.entity.dropdown.CompanyEnitity
import com.pos.lms.core.data.source.local.entity.dropdown.CompetencyEntity
import com.pos.lms.core.data.source.local.entity.dropdown.PLEntity
import com.pos.lms.core.data.source.local.entity.dropdown.TypeEntity
import com.pos.lms.core.data.source.local.entity.materi.MateriEntity
import com.pos.lms.core.data.source.local.entity.mentor.MentorUserEntity
import com.pos.lms.core.data.source.local.entity.profile.AvatarEntity
import com.pos.lms.core.data.source.local.entity.roadmap.*
import com.pos.lms.core.data.source.local.entity.student.*
import com.pos.lms.core.data.source.local.entity.trainer.TrainerUserEntity
import com.pos.lms.core.data.source.local.entity.trainer.TrainerUserEntity2
import com.pos.lms.core.data.source.local.entity.trainer.TrainerUserEntity3
import com.pos.lms.core.data.source.local.room.dao.*
import com.pos.lms.core.utils.Converter

@Database(
    entities = [
        LoginEntity::class,
        SubmitEntity::class,
        ItemParIdEntity::class,
        CuriculumEntity::class,
        CompetencyEntity::class,
        CompanyEnitity::class,
        TypeEntity::class,
        PLEntity::class,
        MateriEntity::class,
        StudentEntity::class,
        DetailSessionEntity::class,
        SessionListEntity::class,
        ForumListEntity::class,
        ForumCommentEntity::class,
        ForumLikeEntity::class,
        PaginationEntity::class,
        InsightListEntity::class,
        ScheduleEntity::class,
        MateriScheduleEntity::class,
        TestScheduleEntity::class,
        TestPertanyaanEntity::class,
        TestJawabanEntity::class,
        QuisionerScheduleEntity::class,
        QuisionerAnswerEntity::class,
        QuisionerPertanyaanEntity::class,
        TrainerScheduleEntity::class,
        RoomScheduleEntity::class,
        MentoringEntity::class,
        MentoringDetailEntity::class,
        MentoringChatEntity::class,
        AbsensiEntity::class,
        EventRoadmapEntity::class,
        ECPPromosiEntity::class,
        ECPRotasiEntity::class,
        MCPPromosiEntity::class,
        MCPRotasiEntity::class,
        SCPPromosiEntity::class,
        SCPRotasiEntity::class,
        TrainerUserEntity::class,
        TrainerUserEntity2::class,
        TrainerUserEntity3::class,
        AccountEntity::class,
        AvatarEntity::class,
        MentorUserEntity::class
    ],
    version = 2,
    exportSchema = false
)
@TypeConverters(Converter::class)
abstract class LmsDataBase : RoomDatabase() {

    abstract fun loginDao(): LoginDao

    abstract fun curiculumDao(): CuriculumnDao

    abstract fun dropdown(): DropDownDao

    abstract fun submit(): SubmitDao

    abstract fun materi(): MateriDao

    abstract fun roadmapDao(): RoadmapDao

    abstract fun student(): StudentDao

    abstract fun trainerDao(): TrainerDao

    abstract fun profileDao(): ProfileDao

    abstract fun mentorDao(): MentorDao


}