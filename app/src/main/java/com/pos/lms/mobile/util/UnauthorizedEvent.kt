package com.pos.lms.mobile.util

/**
 * Created by Muhammad Zaim Milzam on 17/03/21.
 * linkedin : Muhammad Zaim Milzam
 */
class UnauthorizedEvent() {
    private val INSTANCE: UnauthorizedEvent = UnauthorizedEvent()
    fun instance(): UnauthorizedEvent {
        return INSTANCE
    }
}