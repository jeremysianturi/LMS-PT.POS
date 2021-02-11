package com.pos.lms.core.data.source.local.room

import com.pos.lms.core.data.source.local.entity.ItemParIdEntity
import com.pos.lms.core.data.source.local.entity.LoginEntity
import com.pos.lms.core.data.source.local.entity.SubmitEntity
import com.pos.lms.core.data.source.local.entity.curiculum.CuriculumEntity
import com.pos.lms.core.data.source.local.entity.dropdown.CompanyEnitity
import com.pos.lms.core.data.source.local.entity.dropdown.CompetencyEntity
import com.pos.lms.core.data.source.local.entity.dropdown.PLEntity
import com.pos.lms.core.data.source.local.entity.dropdown.TypeEntity
import com.pos.lms.core.data.source.local.entity.materi.MateriEntity
import com.pos.lms.core.data.source.local.entity.student.StudentEntity
import com.pos.lms.core.data.source.local.room.dao.*
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Muhammad Zaim Milzam on 29/01/21.
 * linkedin : Muhammad Zaim Milzam
 */
@Singleton
class LocalDataSource @Inject constructor(
    private val mLoginDao: LoginDao,
    private val mSubmitDao: SubmitDao,
    private val mCuriculumDao: CuriculumnDao,
    private val mDropDownDao: DropDownDao,
    private val mMateriDao: MateriDao,
    private val mStudentDao: StudentDao
) {

    fun getLogin(): Flow<LoginEntity> = mLoginDao.getLogin()
    suspend fun insertLogin(login: LoginEntity) = mLoginDao.insetLogin(login)

    fun getParId(): Flow<List<ItemParIdEntity>> = mLoginDao.getParId()
    suspend fun insertParId(parId: List<ItemParIdEntity>) = mLoginDao.insetParId(parId)

    // dropdown
    fun getCompetency(): Flow<List<CompetencyEntity>> = mDropDownDao.getCompetency()
    suspend fun insertCompetency(competency: List<CompetencyEntity>) =
        mDropDownDao.insertCompetency(competency)

    fun getPL(): Flow<List<PLEntity>> = mDropDownDao.getPL()
    suspend fun insertPL(pl: List<PLEntity>) =
        mDropDownDao.insertPL(pl)

    fun getType(): Flow<List<TypeEntity>> = mDropDownDao.getType()
    suspend fun insertType(type: List<TypeEntity>) =
        mDropDownDao.insertType(type)

    fun getCompany(): Flow<List<CompanyEnitity>> = mDropDownDao.getCompany()
    suspend fun insertCompany(company: List<CompanyEnitity>) =
        mDropDownDao.insertCompany(company)

    // curiculum
    fun getCuriculum(): Flow<List<CuriculumEntity>> = mCuriculumDao.getCuriculum()
    suspend fun insertCuriculum(curiculum: List<CuriculumEntity>) =
        mCuriculumDao.insertCuriculum(curiculum)

    fun getSubmitResponse(): Flow<SubmitEntity> = mSubmitDao.getSubmit()
    suspend fun insertSubmitResponse(submitEntity: SubmitEntity) =
        mSubmitDao.insertSubmit(submitEntity)

    // materi
    fun getMateri(): Flow<List<MateriEntity>> = mMateriDao.getMateri()
    suspend fun insertMateri(materi: List<MateriEntity>) =
        mMateriDao.insertMateri(materi)

    // student
    fun getStudent(): Flow<List<StudentEntity>> = mStudentDao.getStudent()
    suspend fun insertStudent(student : List<StudentEntity>) = mStudentDao.insertStudent(student)

}