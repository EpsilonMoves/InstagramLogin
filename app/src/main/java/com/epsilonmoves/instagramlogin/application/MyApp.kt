package com.epsilonmoves.instagramlogin.application

import android.app.Application
import com.epsilonmoves.instagramlogin.module.webViewModule
import org.koin.android.ext.android.startKoin

class MyApp:Application(){
    companion object {
        lateinit var instance: MyApp
            private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        // start Koin!
        startKoin(this, listOf(webViewModule))
    }
}