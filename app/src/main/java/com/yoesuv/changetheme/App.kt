package com.yoesuv.changetheme

import android.app.Application

class App: Application() {

    companion object {
        var prefHelper: PreferencesHelper? = null
    }

    override fun onCreate() {
        super.onCreate()
        prefHelper = PreferencesHelper(this)
    }

}