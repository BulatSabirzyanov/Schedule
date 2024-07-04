package com.example.schedule.di.deps

import com.example.schedule.data.dao.ScheduleListDao

interface ScheduleDatabase {
    fun scheduleListDao(): ScheduleListDao
}
