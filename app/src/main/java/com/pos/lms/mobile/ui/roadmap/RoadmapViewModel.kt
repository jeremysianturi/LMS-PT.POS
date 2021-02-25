package com.pos.lms.mobile.ui.roadmap

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.pos.lms.core.domain.usecase.roadmap.RoadmapUsecase

/**
 * Created by Muhammad Zaim Milzam on 25/02/21.
 * linkedin : Muhammad Zaim Milzam
 */

class RoadmapViewModel @ViewModelInject constructor(private val roadmapUsecase: RoadmapUsecase) :
    ViewModel() {

    fun getEventRoadmap(begda: String, enda: String) =
        roadmapUsecase.getEventRoadmap(begda, enda).asLiveData()
}