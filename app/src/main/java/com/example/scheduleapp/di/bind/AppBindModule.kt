package com.example.scheduleapp.di.bind

import dagger.Module

@Module(
    includes = [
        ScheduleDepsBindModule::class,
        ScheduleDetailDepsBindModule::class,
        ScheduleDetailUiDepsBindModule::class,
    ]
)
class AppBindModule