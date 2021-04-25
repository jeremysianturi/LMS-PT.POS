package com.pos.lms.mobile.ui.mentor

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pos.lms.core.data.source.remote.response.mentor.MentorTemp
import com.pos.lms.core.domain.usecase.student.StudentUsecase

/**
 * Created by Muhammad Zaim Milzam on 20/04/21.
 * linkedin : Muhammad Zaim Milzam
 */

/**
 * kurang di support
 * jd mau gamau yg penting jd
 *
 */

class MentorViewModel @ViewModelInject constructor(private val studentUsecase: StudentUsecase) :
    ViewModel() {


    private val listMentor = MutableLiveData<ArrayList<MentorTemp>>()


    fun setData(url: String, token: String, begda: String, endda: String, id: String) {

        val reqUrl =
            "$url/lms/api/mentoringparticipant?begin_date_lte=$begda&end_date_gte=$endda&order[BEGDA]=desc&otype[]=MNTOR&include[]=id&include[]=mentoring&include[]=external_mentoring&id[]=22"
//        https://pos-lms.digitalevent.id/lms/api/mentoringparticipant?begin_date_lte=2021-04-22&end_date_gte=2021-04-22&order[BEGDA]=desc&otype[]=MNTOR&include[]=id&include[]=mentoring&include[]=external_mentoring&id[]=22
    }


}