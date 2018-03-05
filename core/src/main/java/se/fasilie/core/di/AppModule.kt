package se.fasilie.core.di

import android.content.Context
import dagger.Module
import dagger.Provides
import se.fasilie.core.networking.AppScheduler
import se.fasilie.core.networking.Scheduler
import javax.inject.Singleton

@Module
class AppModule(val context: Context) {
    @Provides
    @Singleton
    fun providesContext(): Context {
        return context
    }

    @Provides
    @Singleton
    fun scheduler(): Scheduler {
        return AppScheduler()
    }
}
