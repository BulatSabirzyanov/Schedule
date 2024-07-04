package com.example.schedule.di.bind

import com.example.schedule.domain.usecases.CreateScheduleListUseCase
import com.example.schedule.data.usecases.CreateScheduleListUseCaseImpl
import com.example.api.usecases.DeleteScheduleListUseCase
import com.example.schedule.data.usecases.DeleteScheduleListUseCaseImpl
import com.example.api.usecases.GetAllScheduleListsUseCase
import com.example.schedule.data.usecases.GetAllScheduleListsUseCaseImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
internal interface ScheduleDomainLayerBindModule {

    @Binds
    fun bindCreateScheduleListUseCaseImplToCreateScheduleListUseCase(
        createScheduleListUseCaseImpl: CreateScheduleListUseCaseImpl
    ): CreateScheduleListUseCase

    @Binds
    fun bindDeleteScheduleListUseCaseImplToDeleteScheduleListUseCase(
        deleteScheduleListUseCaseImpl: DeleteScheduleListUseCaseImpl
    ): DeleteScheduleListUseCase

    @Binds
    fun bindGetAllScheduleListsUseCaseImplToGetAllScheduleListsUseCase(
        getAllScheduleListsUseCaseImpl: GetAllScheduleListsUseCaseImpl
    ): GetAllScheduleListsUseCase
}