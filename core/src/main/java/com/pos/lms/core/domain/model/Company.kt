package com.pos.lms.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Company(
	val endDate: String,
	val country: String,
	val objectIdentifier: Int,
	val companyId: String,
	val city: String,
	val changeDate: String,
	val beginDate: String,
	val businessCode: String,
	val province: String,
	val phone: String,
	val street: String,
	val companyName: String,
	val changeUser: String,
	val postalCode: String
) : Parcelable