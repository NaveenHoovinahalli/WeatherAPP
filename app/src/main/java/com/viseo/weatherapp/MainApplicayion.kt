package com.viseo.weatherapp

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import com.example.basicdemo.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApplicayion : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoinInstance()
    }

    private fun startKoinInstance() {

        startKoin {
            androidContext(this@MainApplicayion)
            modules(appModule)

        }
    }

}