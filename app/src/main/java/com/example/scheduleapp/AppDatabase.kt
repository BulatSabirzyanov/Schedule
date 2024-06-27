package com.example.scheduleapp

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.feature_impl.db.entity.ScheduleItem
import com.example.schedule.data.dao.ScheduleListDao
import com.example.schedule.data.entity.ScheduleList
import com.example.schedule.di.deps.ScheduleDatabase
import com.example.scheduleapp.di.db.Converters

@Database(
    entities = [
        ScheduleList::class,
        ScheduleItem::class
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase(), ScheduleDatabase {

    abstract override fun scheduleListDao(): ScheduleListDao

    companion object {
        const val DB_NAME = "AppDataBase"
    }
}