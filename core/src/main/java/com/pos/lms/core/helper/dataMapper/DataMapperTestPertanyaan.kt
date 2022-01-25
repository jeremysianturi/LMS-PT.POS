package com.pos.lms.core.helper.dataMapper

import com.pos.lms.core.data.source.local.entity.student.TestPertanyaanEntity
import com.pos.lms.core.data.source.remote.response.student.session.detailSchedule.TestPertanyaanResponse
import com.pos.lms.core.domain.model.TestPertanyaan

object DataMapperTestPertanyaan {

    fun mapResponsesToEntities(input: List<TestPertanyaanResponse>): List<TestPertanyaanEntity> {
        val list = ArrayList<TestPertanyaanEntity>()
        input.map {
            val entity = TestPertanyaanEntity(
                questionText = it.questionText,
                tableCode = it.tableCode,
                objectIdentifier = it.objectIdentifier,
                tqsid = it.tqsid,
                companyName = it.companyName,
                questionName = it.questionName,
                questionImage = it.questionImage as String?,
                businessCode = it.businessCode,
                otype = it.otype,
                relation = it.relation,
                objects = it.objects,
                _id = 0

            )
            list.add(entity)
        }
        return list
    }

    fun mapEntitiesToDomain(input: List<TestPertanyaanEntity>): List<TestPertanyaan> =
        input.map {
            TestPertanyaan(
                questionText = it.questionText.toString(),
                tableCode = it.tableCode!!,
                objectIdentifier = it.objectIdentifier!!,
                tqsid = it.tqsid!!,
                companyName = it.companyName!!,
                questionName = it.questionName!!,
                questionImage = it.questionImage,
                businessCode = it.businessCode!!,
                otype = it.otype!!,
                relation = it.relation!!,
                objects = it.objects!!,
                _id = it._id!!
            )
        }

}