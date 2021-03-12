package com.pos.lms.mobile.ui.roadmap.scp

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.pos.lms.core.domain.usecase.roadmap.RoadmapUsecase
/**
 * Created by Muhammad Zaim Milzam on 15/02/21.
 * linkedin : Muhammad Zaim Milzam
 */
class SCPViewModel @ViewModelInject constructor(private val roadmapUsecase: RoadmapUsecase) :
    ViewModel(){

    fun scpRotasi(eventCode: String, personalNumber: String, begda: String, enda: String) =
        roadmapUsecase.getSCPRotasi(eventCode, personalNumber, begda, enda).asLiveData()

    fun scpPromosi(eventCode: String, personalNumber: String, begda: String, enda: String) =
        roadmapUsecase.getSCPPromosi(eventCode, personalNumber, begda, enda).asLiveData()
}