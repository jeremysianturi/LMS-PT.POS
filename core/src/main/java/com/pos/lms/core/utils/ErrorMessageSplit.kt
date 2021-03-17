package com.pos.lms.core.utils

import java.util.*

/**
 * Created by Muhammad Zaim Milzam on 17/03/21.
 * linkedin : Muhammad Zaim Milzam
 */
object ErrorMessageSplit {

    fun message(msg: String): String {
        val result: String

        val tokens = StringTokenizer(msg, ":")
        val first: String = tokens.nextToken() // this will contain "Fruit"
        val second: String = tokens.nextToken()
        result = second

        return result
    }

    fun code(msg: String): String {
        val result: String

        val tokens = StringTokenizer(msg, ":")
        val first: String = tokens.nextToken() // this will contain "Fruit"
        val second: String = tokens.nextToken()
        result = second

        return result
    }
}