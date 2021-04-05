package com.pos.lms.core.domain.model

data class TestPertanyaan(
    val questionText: String,
    val tableCode: String,
    val objectIdentifier: Int,
    val tqsid: Int,
    val companyName: String,
    val questionName: String,
    val questionImage: String?,
    val businessCode: String,
    val otype: String,
    val relation: String,
    val objects: String,
    val _id: Long
)