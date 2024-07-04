package com.example.schedule.data

import com.example.schedule.domain.models.ScheduleDomainListItem
import com.example.schedule.data.entity.ScheduleList
import com.example.schedule.data.dao.ScheduleListDao
import com.example.schedule.domain.ScheduleRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/**
 * @author b.sabirzyanov
 */
class ScheduleRepositoryImpl @Inject constructor(
    private val scheduleListDao: ScheduleListDao,
) : ScheduleRepository {

    override fun getAllScheduleLists(): Flow<List<ScheduleDomainListItem>> {
        return scheduleListDao.getAllScheduleLists().map { scheduleList ->
            scheduleList.map { scheduleListItem ->
                ScheduleDomainListItem(
                    id = scheduleListItem.id,
                    title = scheduleListItem.title,
                    scheduleItemsCount = scheduleListItem.scheduleItemsCount
                )
            }
        }
    }

    override suspend fun createScheduleListItem(scheduleApiList: ScheduleDomainListItem) {
        val scheduleList = ScheduleList(
            id = scheduleApiList.id,
            title = scheduleApiList.title,
            scheduleItemsCount = scheduleApiList.scheduleItemsCount
        )
        scheduleListDao.insert(scheduleList)
    }

    override suspend fun deleteScheduleListItem(scheduleApiList: ScheduleDomainListItem) {
        scheduleListDao.deleteById(scheduleApiList.id)
    }
}