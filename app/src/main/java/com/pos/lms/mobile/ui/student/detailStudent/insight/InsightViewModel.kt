package com.pos.lms.mobile.ui.student.detailStudent.insight

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.pos.lms.core.domain.usecase.student.StudentUsecase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flatMapLatest

class InsightViewModel @ViewModelInject constructor(private val studentUsecase: StudentUsecase) :
    ViewModel() {

    val searchQuery = MutableStateFlow("")
    val myInsightQuery = MutableStateFlow("")

    private val insightFlow = searchQuery.flatMapLatest {
        studentUsecase.getSearchInsight(it)
    }

    private val myInsightFlow = myInsightQuery.flatMapLatest {
        studentUsecase.getOwnerInsight(it)
    }

    val search = insightFlow.asLiveData()

    val myInisght = myInsightFlow.asLiveData()

    fun getInsightList(batchId: String, begda: String, endda: String) =
        studentUsecase.getInsightList(batchId, begda, endda).asLiveData()

    fun getDelete(oid: String) = studentUsecase.deteleInsight(oid).asLiveData()

//    fun getMyInsight(owner: String) = studentUsecase.getOwnerInsight(owner).asLiveData()
}