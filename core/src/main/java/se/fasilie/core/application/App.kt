package se.fasilie.core.application

import android.app.Application
import com.facebook.stetho.Stetho
import se.fasilie.core.BuildConfig
import se.fasilie.core.di.AppModule
import se.fasilie.core.di.CoreComponent
import se.fasilie.core.di.DaggerCoreComponent

open class App : Application() {

    companion object {
        lateinit var coreComponent: CoreComponent
    }

    override fun onCreate() {
        super.onCreate()
        initDI()
        initStetho()
    }

    private fun initStetho() {
        if (BuildConfig.DEBUG)
            Stetho.initializeWithDefaults(this)
    }

    private fun initDI() {
        coreComponent = DaggerCoreComponent.builder().appModule(AppModule(this)).build()
    }
}
