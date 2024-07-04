package com.example.schedule.presentation.schedulefragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.api.usecases.DeleteScheduleListUseCase
import com.example.api.usecases.GetAllScheduleListsUseCase
import com.example.schedule.di.deps.ScheduleRouter
import com.example.schedule.presentation.mappers.ScheduleDomainToUiMapper
import com.example.schedule.presentation.mappers.ScheduleUiToDomainMapper
import com.example.schedule.presentation.models.ScheduleUiListItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


/**
 * @author b.sabirzyanov
 */
class ScheduleViewModel @Inject constructor(
    private val getAllScheduleListsUseCase: GetAllScheduleListsUseCase,
    private val deleteScheduleListUseCase: DeleteScheduleListUseCase,
    private val scheduleDomainToUiMapper: ScheduleDomainToUiMapper,
    private val scheduleUiToDomainMapper: ScheduleUiToDomainMapper,
    private val scheduleRouter: ScheduleRouter,
) : ViewModel() {

    private val _scheduleLists = MutableStateFlow<List<ScheduleUiListItem>>(emptyList())
    val scheduleLists: StateFlow<List<ScheduleUiListItem>> = _scheduleLists

    init {
        loadScheduleLists()
    }

    private fun loadScheduleLists() {
        viewModelScope.launch {
            getAllScheduleListsUseCase.invoke().collect { lists ->
                _scheduleLists.value = lists.map {
                    scheduleDomainToUiMapper.toUiItem(it)
                }
            }
        }
    }

    fun deleteScheduleItem(scheduleUiListItem: ScheduleUiListItem) {
        viewModelScope.launch {
            deleteScheduleListUseCase.invoke(
                scheduleUiToDomainMapper.toDomain(
                    scheduleUiListItem
                )
            )
        }
    }

    fun navigateToScheduleDetail(scheduleUiListItem: ScheduleUiListItem) {
        scheduleRouter.navigateToScheduleDetails()
    }
}
