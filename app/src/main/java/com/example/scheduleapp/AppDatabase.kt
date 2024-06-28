package com.example.scheduleapp

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.schedule.detail.data.entity.ScheduleItem
import com.example.schedule.data.dao.ScheduleListDao
import com.example.schedule.data.entity.ScheduleList
import com.example.schedule.detail.data.dao.ScheduleDetailItemDao
import com.example.schedule.detail.di.deps.ScheduleDetailDatabase
import com.example.schedule.di.deps.ScheduleDatabase

@Database(
    entities = [
        ScheduleList::class,
        ScheduleItem::class
    ],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase(), ScheduleDatabase , ScheduleDetailDatabase {

    abstract override fun scheduleListDao(): ScheduleListDao

    abstract override fun scheduleItemDao(): ScheduleDetailItemDao

    companion object {
        const val DB_NAME = "AppDataBase"
    }
}