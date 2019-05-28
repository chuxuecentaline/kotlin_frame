package com.cherish.common.utils

import android.content.Context
import android.content.SharedPreferences
import com.cherish.common.utils.SharePreUtils.preferences


/**
 * @author: cherish
 * @description: SharedPreference
 * @date: 2019/5/27 15:20
 * @version: 2.0
 */
object SharePreUtils {

    private const val SP_NAME = "SP_NAME"

    fun preferences(context: Context): SharedPreferences = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE)

    fun put(context: Context, key: String, value: Int) {
        preferences(context).edit().putInt(key, value)
    }

    fun getInt(context: Context, key: String, defValue: Int = 0) = preferences(context).getInt(key, defValue)

    fun put(context: Context, key: String, value: String?) {
        preferences(context).edit().putString(key, value)
    }

    fun getString(context: Context, key: String, defValue: String? = ""): String? =
            preferences(context).getString(key, defValue)


    fun put(context: Context, key: String, value: Boolean) {
        preferences(context).edit().putBoolean(key, value)
    }

    fun getBoolean(context: Context, key: String, defValue: Boolean = false) =
            preferences(context).getBoolean(key, defValue)

}
    