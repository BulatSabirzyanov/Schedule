package com.example.scheduleapp.di

import android.content.Context
import com.example.common.di.holder.DiComponent
import com.example.schedule.detail.di.deps.ScheduleDetailDeps
import com.example.schedule.detail.ui.di.deps.ScheduleDetailUiDeps
import com.example.schedule.di.deps.ScheduleDeps
import com.example.scheduleapp.MainActivity
import com.example.scheduleapp.MainFragment
import com.example.scheduleapp.di.bind.AppBindModule
import com.example.scheduleapp.di.db.AppDatabaseModule
import com.example.scheduleapp.di.navigation.AppNavigationModule
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent : ScheduleDeps, ScheduleDetailDeps, ScheduleDetailUiDeps, DiComponent {

    fun inject(mainActivity: MainActivity)

    fun inject(mainFragment: MainFragment)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun appContext(applicationContext: Context): Builder
        fun build(): AppComponent
    }
}

@Module(
    includes = [AppNavigationModule::class, AppDatabaseModule::class, AppBindModule::class]
)
class AppModule
