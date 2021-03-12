package com.pos.lms.mobile.ui.roadmap.mcp

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.pos.lms.core.domain.usecase.roadmap.RoadmapUsecase
/**
 * Created by Muhammad Zaim Milzam on 15/02/21.
 * linkedin : Muhammad Zaim Milzam
 */
class MCPViewModel @ViewModelInject constructor(private val roadmapUsecase: RoadmapUsecase) :
    ViewModel(){

    fun mcpRotasi(eventCode: String, personalNumber: String, begda: String, enda: String) =
        roadmapUsecase.getMCPRotasi(eventCode, personalNumber, begda, enda).asLiveData()

    fun mcpPromosi(eventCode: String, personalNumber: String, begda: String, enda: String) =
        roadmapUsecase.getMCPPromosi(eventCode, personalNumber, begda, enda).asLiveData()
}