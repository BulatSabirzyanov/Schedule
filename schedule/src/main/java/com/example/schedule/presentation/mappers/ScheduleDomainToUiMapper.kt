package com.example.schedule.presentation.mappers

import com.example.schedule.domain.models.ScheduleDomainListItem
import com.example.schedule.presentation.models.ScheduleUiListItem
import javax.inject.Inject

interface ScheduleDomainToUiMapper {

    fun toUiItem(item: ScheduleDomainListItem): ScheduleUiListItem
}

internal class ScheduleDomainToUiMapperImpl @Inject constructor() : ScheduleDomainToUiMapper {

    override fun toUiItem(item: ScheduleDomainListItem): ScheduleUiListItem {
        return ScheduleUiListItem(
            item.id,
            item.title,
            item.scheduleItemsCount,
        )

    }

}