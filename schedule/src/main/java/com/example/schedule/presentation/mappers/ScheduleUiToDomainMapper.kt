package com.example.schedule.presentation.mappers

import com.example.schedule.domain.models.ScheduleDomainListItem
import com.example.schedule.presentation.models.ScheduleUiListItem
import javax.inject.Inject

interface ScheduleUiToDomainMapper {
    fun toDomain(item: ScheduleUiListItem) : ScheduleDomainListItem
}

internal class ScheduleUiToDomainMapperImpl @Inject constructor() : ScheduleUiToDomainMapper {

    override fun toDomain(item: ScheduleUiListItem): ScheduleDomainListItem {
        return ScheduleDomainListItem(
            item.id,
            item.title,
            item.scheduleItemsCount,
        )
    }

}