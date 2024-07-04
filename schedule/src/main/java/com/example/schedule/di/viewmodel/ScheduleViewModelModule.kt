package com.example.schedule.di.viewmodel

import androidx.lifecycle.ViewModel
import com.example.schedule.presentation.createdialogfragment.CreateFragmentViewModel
import com.example.schedule.presentation.schedulefragment.ScheduleViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ScheduleViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(ScheduleViewModel::class)
    fun scheduleViewModel(viewModel: ScheduleViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(CreateFragmentViewModel::class)
    fun createFragmentViewModel(viewModel: CreateFragmentViewModel): ViewModel
}