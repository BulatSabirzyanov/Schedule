package com.example.schedule.data.usecases

import com.example.api.usecases.GetAllScheduleListsUseCase
import com.example.schedule.domain.ScheduleRepository
import com.example.schedule.domain.models.ScheduleDomainListItem
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * @author b.sabirzyanov
 */
class GetAllScheduleListsUseCaseImpl @Inject constructor(
    private val scheduleRepository: ScheduleRepository
) : GetAllScheduleListsUseCase {
    override fun invoke(): Flow<List<ScheduleDomainListItem>> {
        return scheduleRepository.getAllScheduleLists()
    }
}