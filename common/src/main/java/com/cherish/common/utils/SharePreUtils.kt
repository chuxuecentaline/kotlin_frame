package com.cherish.common.utils

import android.content.Context
import android.content.SharedPreferences
import com.cherish.common.BaseApplication
import com.cherish.common.utils.SharePreUtils.preferences


/**
 * @author: cherish
 * @description: SharedPreference
 * @date: 2019/5/27 15:20
 * @version: 2.0
 */
object SharePreUtils {

    private const val SP_NAME = "SP_NAME"
    private lateinit var mContext: Context
    fun init(context: Context) {
        mContext = context
    }

    val preferences: SharedPreferences by lazy {
        mContext.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE)
    }

    fun put(key: String, value: Int) {
        preferences.edit().putInt(key, value).commit()
    }

    fun getInt(key: String, defValue: Int = 0) = preferences.getInt(key, defValue)

    fun put(key: String, value: String?) {
        preferences.edit().putString(key, value).commit()
    }

    fun getString(key: String, defValue: String? = ""): String? =
            preferences.getString(key, defValue)


    fun put(key: String, value: Boolean) {
        preferences.edit().putBoolean(key, value).commit()
    }

    fun getBoolean(key: String, defValue: Boolean = false) =
            preferences.getBoolean(key, defValue)

    /**
     * 清除所有的数据
     */
    fun clear() {
        preferences.edit().clear()
    }
}
    