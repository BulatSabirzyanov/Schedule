package com.example.scheduleapp.di.bind

import com.example.schedule.di.deps.ScheduleDatabase
import com.example.schedule.di.deps.ScheduleRouter
import com.example.scheduleapp.AppDatabase
import com.example.scheduleapp.di.navigation.wrappers.ScheduleRouterWrapper
import dagger.Binds
import dagger.Module

@Module
interface ScheduleDepsBindModule {

    @Binds
    fun bindScheduleRouterHolderToScheduleRouter(
        scheduleRouterWrapper: ScheduleRouterWrapper
    ): ScheduleRouter

    @Binds
    fun bindAppDatabaseToScheduleDatabase(
        appDatabase: AppDatabase
    ): ScheduleDatabase
}