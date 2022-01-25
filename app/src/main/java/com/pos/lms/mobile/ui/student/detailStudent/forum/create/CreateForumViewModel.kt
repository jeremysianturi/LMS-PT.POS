package com.pos.lms.mobile.ui.student.detailStudent.forum.create

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.pos.lms.core.domain.model.Submit
import com.pos.lms.core.domain.usecase.student.StudentUsecase
import okhttp3.MultipartBody
import okhttp3.RequestBody

class CreateForumViewModel @ViewModelInject constructor(private val studentUsecase: StudentUsecase) : ViewModel(){

    val listGedung = MutableLiveData<Submit>()

   fun createForum(
       businesCode: RequestBody,
       batch: RequestBody,
       owner: RequestBody,
       tittle: RequestBody,
       desc: RequestBody,
       type: RequestBody,
       image: MultipartBody.Part,
       time: RequestBody,
       begda: RequestBody,
       endda: RequestBody
   ) = studentUsecase.createForum(businesCode,
       batch,
       owner,
       tittle,
       desc,
       type,
       image,
       time,
       begda,
       endda).asLiveData()




}