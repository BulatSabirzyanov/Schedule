package com.example.schedule.data.usecases

import com.example.api.usecases.DeleteScheduleListUseCase
import com.example.schedule.domain.ScheduleRepository
import com.example.schedule.domain.models.ScheduleDomainListItem
import javax.inject.Inject

/**
 * @author b.sabirzyanov
 */
class DeleteScheduleListUseCaseImpl @Inject constructor(
    private val scheduleRepository: ScheduleRepository
) : DeleteScheduleListUseCase {

    override suspend fun invoke(scheduleApiList: ScheduleDomainListItem) {
        scheduleRepository.deleteScheduleListItem(scheduleApiList = scheduleApiList)
    }
}
