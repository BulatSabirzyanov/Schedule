package com.example.schedule.domain

import com.example.schedule.domain.models.ScheduleDomainListItem
import kotlinx.coroutines.flow.Flow

/**
 * @author b.sabirzyanov
 */
interface ScheduleRepository {

    fun getAllScheduleLists(): Flow<List<ScheduleDomainListItem>>

    suspend fun createScheduleListItem(scheduleApiList: ScheduleDomainListItem)

    suspend fun deleteScheduleListItem(scheduleApiList: ScheduleDomainListItem)

}