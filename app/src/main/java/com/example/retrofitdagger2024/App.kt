package com.example.retrofitdagger2024

import android.app.Application
import android.content.Context
import com.example.retrofitdagger2024.di.ApplicationComponent
import com.example.retrofitdagger2024.di.DaggerApplicationComponent

class App : Application() {
    lateinit var applicationComponent: ApplicationComponent

    companion object {
        private var INSTANCES: App? = null

        fun getApplicationContext(): Context {
            return INSTANCES!!.applicationContext
        }
    }

    override fun onCreate() {
        super.onCreate()

        applicationComponent = DaggerApplicationComponent.factory().create(this)
        INSTANCES = this
    }
}