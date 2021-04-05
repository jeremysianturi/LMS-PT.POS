package com.pos.lms.core.helper.dataMapper

import com.pos.lms.core.data.source.local.entity.student.TestJawabanEntity
import com.pos.lms.core.data.source.remote.response.student.session.detailSchedule.TestJawabanResponse
import com.pos.lms.core.domain.model.TestJawaban

/**
 * Created by Muhammad Zaim Milzam on 08/02/21.
 * linkedin : Muhammad Zaim Milzam
 */
object DataMapperTestJawaban {

    fun mapResponsesToEntities(input: List<TestJawabanResponse>): List<TestJawabanEntity> {
        val list = ArrayList<TestJawabanEntity>()
        input.map {
            val entity = TestJawabanEntity(
                endDate = it.endDate,
                score = it.score,
                flagTrue = it.flagTrue,
                objectIdentifier = it.objectIdentifier,
                question = it.question,
                changeDate = it.changeDate,
                beginDate = it.beginDate,
                textChoice = it.textChoice,
                changeUser = it.changeUser,
                businessCode = it.businessCode,
                sequenceNo = it.sequenceNo,
                isChecked = false

            )
            list.add(entity)
        }
        return list
    }

    fun mapEntitiesToDomain(input: List<TestJawabanEntity>): List<TestJawaban> =
        input.map {
            TestJawaban(
                endDate = it.endDate!!,
                score = it.score!!,
                flagTrue = it.flagTrue!!,
                objectIdentifier = it.objectIdentifier!!,
                question = it.question!!,
                changeDate = it.changeDate!!,
                beginDate = it.beginDate!!,
                textChoice = it.textChoice!!,
                changeUser = it.changeUser!!,
                businessCode = it.businessCode!!,
                sequenceNo = it.sequenceNo!!,
                isChecked = it.isChecked!!
            )
        }

    fun mapDomainToEntity(input: TestJawaban) = TestJawabanEntity(
        endDate = input.endDate,
        score = input.score,
        flagTrue = input.flagTrue,
        objectIdentifier = input.objectIdentifier,
        question = input.question,
        changeDate = input.changeDate,
        beginDate = input.beginDate,
        textChoice = input.textChoice,
        changeUser = input.changeUser,
        businessCode = input.businessCode,
        sequenceNo = input.sequenceNo,
        isChecked = input.isChecked

    )


}