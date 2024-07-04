package com.example.schedule.presentation.createdialogfragment

import androidx.lifecycle.ViewModel
import com.example.schedule.di.deps.ScheduleRouter
import com.example.schedule.domain.models.ScheduleDomainListItem
import com.example.schedule.domain.usecases.CreateScheduleListUseCase
import javax.inject.Inject

/**
 * @author b.sabirzyanov
 */
class CreateFragmentViewModel @Inject constructor(
    private val createScheduleListUseCase: CreateScheduleListUseCase,
) : ViewModel() {

    suspend fun createScheduleListItem(scheduleDomainListItem: ScheduleDomainListItem) {
        createScheduleListUseCase.invoke(scheduleDomainListItem)
    }
}