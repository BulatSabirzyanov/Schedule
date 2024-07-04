package com.example.schedule.di.bind

import dagger.Module

@Module(
    includes = [ScheduleDataLayerBindModule::class, ScheduleDomainLayerBindModule::class, SchedulePresentationLayerBindModule::class]
)
class ScheduleBindModule {
}