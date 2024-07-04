package com.example.schedule.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.example.schedule.data.entity.ScheduleList
import kotlinx.coroutines.flow.Flow

/**
 * @author b.sabirzyanov
 */
@Dao
interface ScheduleListDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(scheduleList: ScheduleList)

    @Query("DELETE FROM ScheduleList WHERE id = :id")
    suspend fun deleteById(id: String)

    @Transaction
    @Query("SELECT * FROM ScheduleList")
    fun getAllScheduleLists(): Flow<List<ScheduleList>>
}
