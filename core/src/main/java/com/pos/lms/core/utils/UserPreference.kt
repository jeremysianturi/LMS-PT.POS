package com.pos.lms.core.utils
import android.content.Context
import androidx.core.content.edit

/**
 * Created by Muhammad Zaim Milzam on 26/11/2020.
 * linkedin : Muhammad Zaim Milzam
 */

class UserPreference(context: Context) {

    companion object {
        private const val PREFS_NAME = "user_pref"
        private const val TOKEN = "token"
        private const val TOKEN_TYPE = "token_type"
        private const val PARID = "parid"
        private const val USERNAME_LOGIN = "username_login"
        private const val PASSWORD_LOGIN = "password_login"
        private const val ISLOGIN = "islogin"
        private const val ROLE = "role"
    }

    private val preferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    fun setPref(value: PreferenceEntity) {
        preferences.edit {
            putString(TOKEN, value.token)
            putString(TOKEN_TYPE, value.tokenType)
            putInt(PARID, value.parId!!)
            putString(USERNAME_LOGIN, value.username)
            putString(PASSWORD_LOGIN, value.password)
            putBoolean(ISLOGIN, value.isLogin!!)
            putString(ROLE, value.role)
        }
    }

    fun getPref(): PreferenceEntity {

        val data = PreferenceEntity()
        data.token = preferences.getString(TOKEN, "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJ5aXQwR05nbVVHamIyZXRxIiwiaWF0IjoxNjEzMzYzMjIyLCJuYmYiOjE2MTMzNjMyMjIsImV4cCI6MTYxMzQ0OTYyMiwidXNlciI6Ijk5MjQxNTIxNCIsInJvbGUiOlsiRU1QUE9TIiwiUEFSVElDSVBBTlQiXX0.1MF-boejJ28IQB2m5tOZS2ouhJg2OaoBjyxs4VpP_cs")
        data.tokenType = preferences.getString(TOKEN_TYPE, "").toString()
        data.parId = preferences.getInt(PARID, 0)
        data.username = preferences.getString(USERNAME_LOGIN, "")
        data.password = preferences.getString(PASSWORD_LOGIN, "")
        data.isLogin = preferences.getBoolean(ISLOGIN, false)
        data.role = preferences.getString(ROLE, "")

        return data
    }
}