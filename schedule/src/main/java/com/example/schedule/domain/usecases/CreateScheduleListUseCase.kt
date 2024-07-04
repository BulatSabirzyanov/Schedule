package com.example.schedule.domain.usecases

import com.example.schedule.domain.models.ScheduleDomainListItem

/**
 * @author b.sabirzyanov
 */
interface CreateScheduleListUseCase {
    suspend fun invoke(scheduleApiList: ScheduleDomainListItem)
}