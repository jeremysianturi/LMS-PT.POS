package com.pos.lms.core.utils

import java.io.IOException

/**
 * Created by Reza Satria on 3/4/2020
 */

class ApiException(message: String) : IOException(message)
class NoInternetException(message: String) : IOException(message)