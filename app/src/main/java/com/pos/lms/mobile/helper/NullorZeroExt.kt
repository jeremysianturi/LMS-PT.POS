package com.pos.lms.mobile.helper

/**
 * Created by Muhammad Zaim Milzam on 06/04/21.
 * linkedin : Muhammad Zaim Milzam
 */

fun Any?.isNull() = this == null

fun Int?.orZero(): Int = this ?: 0

fun Long?.orZero(): Long = this ?: 0L
