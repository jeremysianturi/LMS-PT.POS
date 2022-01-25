package com.pos.lms.mobile.ui.student.detailStudent.forum.detail

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.pos.lms.core.data.source.remote.post.ForumCommnetPost
import com.pos.lms.core.domain.usecase.student.StudentUsecase

class DetailForumViewModel @ViewModelInject constructor(private val studentUsecase: StudentUsecase) :
    ViewModel() {

    fun getComment(forumId: String, begda: String, endda: String) =
        studentUsecase.getForumComment(forumId, begda, endda).asLiveData()

    fun postComment(forumCommnetPost: ForumCommnetPost) =
        studentUsecase.postForumComment(forumCommnetPost).asLiveData()
}