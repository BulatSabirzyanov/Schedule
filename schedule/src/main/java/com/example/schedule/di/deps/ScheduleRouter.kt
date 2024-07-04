package com.example.schedule.di.deps

interface ScheduleRouter {

    fun navigateToSchedule()

    fun navigateToScheduleDetails()

    fun navigateToCreateScheduleItem()

    fun exit()
}