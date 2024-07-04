package com.example.api.usecases

import com.example.schedule.domain.models.ScheduleDomainListItem
import kotlinx.coroutines.flow.Flow

/**
 * @author b.sabirzyanov
 */
interface GetAllScheduleListsUseCase {
    fun invoke(): Flow<List<ScheduleDomainListItem>>
}