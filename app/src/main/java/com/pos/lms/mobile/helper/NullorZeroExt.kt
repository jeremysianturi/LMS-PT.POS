package com.pos.lms.mobile.helper


fun Any?.isNull() = this == null

fun Int?.orZero(): Int = this ?: 0

fun Long?.orZero(): Long = this ?: 0L
