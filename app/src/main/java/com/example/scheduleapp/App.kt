package com.example.scheduleapp

import android.app.Application
import com.example.schedule.di.deps.ScheduleDepsStore
import com.example.scheduleapp.di.AppComponentHolder

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        AppComponentHolder.build(applicationContext)
        ScheduleDepsStore.deps = AppComponentHolder.get()

    }
}