package com.example.schedule.di.data

import com.example.schedule.data.dao.ScheduleListDao
import com.example.schedule.di.deps.ScheduleDatabase
import dagger.Module
import dagger.Provides

@Module
class ScheduleListDaoModule {

    @Provides
    fun provideScheduleDao(db: ScheduleDatabase): ScheduleListDao = db.scheduleListDao()
}