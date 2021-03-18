package com.pos.lms.core.utils

import java.io.IOException

/**
 * Created by Muhammad Zaim Milzam on 17/03/21.
 * linkedin : Muhammad Zaim Milzam
 */

class ApiException(message: String) : IOException(message)
class ApiExceptionCode(code: String) : IOException(code)
class NoInternetException(message: String) : IOException(message)