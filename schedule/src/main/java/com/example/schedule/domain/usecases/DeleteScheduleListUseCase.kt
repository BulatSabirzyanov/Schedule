package com.example.api.usecases

import com.example.schedule.domain.models.ScheduleDomainListItem

/**
 * @author b.sabirzyanov
 */
interface DeleteScheduleListUseCase {
    suspend fun invoke(scheduleApiList: ScheduleDomainListItem)
}