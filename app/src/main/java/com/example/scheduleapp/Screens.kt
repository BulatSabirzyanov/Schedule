package com.example.scheduleapp

import com.example.schedule.presentation.createdialogfragment.CreateScheduleItemFragment
import com.example.schedule.presentation.schedulefragment.ScheduleFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object Screens {
    fun CreateScheduleItem() = FragmentScreen { CreateScheduleItemFragment() }
    fun Schedule() = FragmentScreen { ScheduleFragment() }
    fun Main() = FragmentScreen { MainFragment() }
}