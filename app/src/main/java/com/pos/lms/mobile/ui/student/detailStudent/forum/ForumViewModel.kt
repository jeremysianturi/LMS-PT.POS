package com.pos.lms.mobile.ui.student.detailStudent.forum

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.pos.lms.core.domain.usecase.student.StudentUsecase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flatMapLatest

class ForumViewModel @ViewModelInject constructor(private val studentUsecase: StudentUsecase) :
    ViewModel() {

    val searchQuery = MutableStateFlow("")
    val myForumtQuery = MutableStateFlow("")


    fun getDetailSession(eventId: String) = studentUsecase.getDetailSession(eventId).asLiveData()

    fun getForumList(batchId: String, begda: String, endda: String) =
        studentUsecase.getForumList(batchId, begda, endda).asLiveData()

    fun deleteForum(objectIdentifier: String) =
        studentUsecase.deteleForum(objectIdentifier).asLiveData()

    private val forumFlow = searchQuery.flatMapLatest {
        studentUsecase.getSearchInsight(it)
    }

    private val myForumFlow = myForumtQuery.flatMapLatest {
        studentUsecase.getOwnerInsight(it)
    }

    val search = forumFlow.asLiveData()

    val myForum = myForumFlow.asLiveData()
}