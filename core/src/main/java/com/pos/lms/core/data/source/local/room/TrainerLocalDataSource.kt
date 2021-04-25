package com.pos.lms.core.data.source.local.room

import com.pos.lms.core.data.source.local.entity.trainer.TrainerUserEntity
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

//    fun getSearchMateri(search: String): Flow<List<MateriEntity>> =
//        mTrainerDao.getS(search)
}