package com.pos.lms.mobile.ui.roadmap.ecp

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.pos.lms.core.domain.usecase.roadmap.RoadmapUsecase
/**
 * Created by Muhammad Zaim Milzam on 15/02/21.
 * linkedin : Muhammad Zaim Milzam
 */
class ECPViewModel @ViewModelInject constructor(private val roadmapUsecase: RoadmapUsecase) :
    ViewModel() {

    fun ecpRotasi(eventCode: String, personalNumber: String, begda: String, enda: String) =
        roadmapUsecase.getECPRotasi(eventCode, personalNumber, begda, enda).asLiveData()

    fun ecpPromosi(eventCode: String, personalNumber: String, begda: String, enda: String) =
        roadmapUsecase.getECPPromosi(eventCode, personalNumber, begda, enda).asLiveData()
}