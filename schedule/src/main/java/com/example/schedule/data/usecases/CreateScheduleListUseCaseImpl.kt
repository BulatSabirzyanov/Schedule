package com.example.schedule.data.usecases

import com.example.schedule.domain.ScheduleRepository
import com.example.schedule.domain.models.ScheduleDomainListItem
import com.example.schedule.domain.usecases.CreateScheduleListUseCase
import javax.inject.Inject

/**
 * @author b.sabirzyanov
 */
internal class CreateScheduleListUseCaseImpl @Inject constructor(
    private val scheduleRepository: ScheduleRepository
) : CreateScheduleListUseCase {

    override suspend fun invoke(scheduleApiList: ScheduleDomainListItem) {
        scheduleRepository.createScheduleListItem(scheduleApiList = scheduleApiList)
    }
}