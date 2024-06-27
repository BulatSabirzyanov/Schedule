package com.example.scheduleapp.di.navigation.wrappers

import com.example.schedule.di.deps.ScheduleRouter
import com.example.scheduleapp.Screens
import com.github.terrakok.cicerone.Router
import javax.inject.Inject

class ScheduleRouterWrapper @Inject constructor(
    private val router: Router
) : ScheduleRouter {

    override fun navigateToSchedule() {
        router.navigateTo(Screens.Schedule())
    }

    override fun navigateToCreateScheduleItem() {
        router.navigateTo(Screens.CreateScheduleItem())
    }

    override fun exit() {
        router.exit()
    }
}
