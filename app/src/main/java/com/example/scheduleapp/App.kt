package com.example.scheduleapp

import android.app.Application
import com.example.schedule.detail.di.deps.ScheduleDetailDepsStore
import com.example.schedule.detail.ui.di.deps.ScheduleDetailUiDepsStore
import com.example.schedule.di.deps.ScheduleDepsStore
import com.example.scheduleapp.di.AppComponentHolder

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        AppComponentHolder.build(applicationContext)
        ScheduleDepsStore.deps = AppComponentHolder.get()
        ScheduleDetailDepsStore.deps = AppComponentHolder.get()
        ScheduleDetailUiDepsStore.deps = AppComponentHolder.get()
    }
}