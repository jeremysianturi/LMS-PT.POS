package com.pos.lms.mobile.ui.changePassword

/**
 * Data validation state of the login form.
 */
data class ChangePasswordFormState(
    val passwordError: Int? = null,
    val confirmPasswordError: Int? = null,
    val isDataValid: Boolean = false
)