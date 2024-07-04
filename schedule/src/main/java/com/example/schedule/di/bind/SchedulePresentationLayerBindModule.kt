package com.example.schedule.di.bind

import com.example.schedule.presentation.mappers.ScheduleDomainToUiMapper
import com.example.schedule.presentation.mappers.ScheduleDomainToUiMapperImpl
import com.example.schedule.presentation.mappers.ScheduleUiToDomainMapper
import com.example.schedule.presentation.mappers.ScheduleUiToDomainMapperImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
internal interface SchedulePresentationLayerBindModule {

    @Binds
    fun bindScheduleDomainToUiMapperImplToScheduleDomainToUiMapper(
        scheduleDomainToUiMapperImpl: ScheduleDomainToUiMapperImpl
    ): ScheduleDomainToUiMapper

    @Binds
    fun bindScheduleUiToDomainMapperImplToScheduleUiToDomainMapper(
        scheduleUiToDomainMapperImpl: ScheduleUiToDomainMapperImpl
    ): ScheduleUiToDomainMapper
}