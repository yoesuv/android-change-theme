package com.yoesuv.changetheme

import android.content.Context
import android.content.SharedPreferences

class PreferencesHelper(context: Context) {

    private val prefHelper: SharedPreferences = context.getSharedPreferences(AppConstants.PREFERENCES_NAME, Context.MODE_PRIVATE)

    fun setBoolean(key: String, value: Boolean){
        prefHelper.edit().putBoolean(key, value).apply()
    }

    fun getBoolean(key: String): Boolean{
        return prefHelper.getBoolean(key, true)
    }

    fun setString(key: String, value: String){
        prefHelper.edit().putString(key, value).apply()
    }

    fun getString(key: String): String?{
        return prefHelper.getString(key,"")
    }
}