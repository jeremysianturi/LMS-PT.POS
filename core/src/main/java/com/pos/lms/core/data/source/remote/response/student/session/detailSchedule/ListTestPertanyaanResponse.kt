package com.pos.lms.core.data.source.remote.response.student.session.detailSchedule

import com.google.gson.annotations.SerializedName

data class ListTestPertanyaanResponse(

	@field:SerializedName("data")
	val data: List<TestPertanyaanResponse>
)