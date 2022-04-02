package com.hackathon.unievents

import android.app.Application
import com.hackathon.unievents.ui.screen.events.EventViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin
import org.koin.dsl.module
import org.koin.androidx.viewmodel.dsl.viewModel

class UniEventsApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@UniEventsApplication)
            modules(appModule())
        }
    }
}

fun appModule() = module {
    viewModel { EventViewModel() }
}