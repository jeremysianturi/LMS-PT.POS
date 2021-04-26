package com.pos.lms.core.data.source.local.room

import com.pos.lms.core.data.source.local.entity.trainer.TrainerUserEntity
import com.pos.lms.core.data.source.local.entity.trainer.TrainerUserEntity2
import com.pos.lms.core.data.source.local.entity.trainer.TrainerUserEntity3
import com.pos.lms.core.data.source.local.room.dao.TrainerDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Muhammad Zaim Milzam on 22/04/21.
 * linkedin : Muhammad Zaim Milzam
 */

@Singleton
class TrainerLocalDataSource @Inject constructor(
    private val mTrainerDao: TrainerDao
) {

    fun getTrainer(): Flow<List<TrainerUserEntity>> = mTrainerDao.getTrainerList()
    suspend fun inserTrainer(materi: List<TrainerUserEntity>) =
        mTrainerDao.insertAndDeleteTrainerUser(materi)

    suspend fun deleteTrainer() = mTrainerDao.deleteTrainerUser()

    fun getUpcoming(): Flow<List<TrainerUserEntity2>> = mTrainerDao.getUpcoming()
    suspend fun insertUpcoming(materi: List<TrainerUserEntity2>) =
        mTrainerDao.insertAndDeleteUpcoming(materi)

    suspend fun deletUpcoming() = mTrainerDao.deleteUpcoming()

    fun getCompleted(): Flow<List<TrainerUserEntity3>> = mTrainerDao.getCompleted()
    suspend fun insertCompleted(materi: List<TrainerUserEntity3>) =
        mTrainerDao.insertAndDeleteCompleted(materi)

    suspend fun deleteCompleted() = mTrainerDao.deleteCompleted()

//    fun getSearchMateri(search: String): Flow<List<MateriEntity>> =
//        mTrainerDao.getS(search)
}