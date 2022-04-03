package com.hackathon.unievents

import android.app.Application
import com.hackathon.unievents.ui.screen.events.EventViewModel
import com.hackathon.unievents.ui.screen.eventsDetail.EventDetailViewModel
import com.hackathon.unievents.ui.screen.auth.LoginScreenViewModel
import com.hackathon.unievents.ui.screen.auth.RegisterScreenViewModel
import com.hackathon.unievents.ui.screen.profile.ProfileViewModel
import com.hackathon.unievents.ui.screen.teams.TeamViewModel
import com.hackathon.unievents.ui.screen.teamsDetail.TeamDetailViewModel
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
    viewModel { LoginScreenViewModel() }
    viewModel { RegisterScreenViewModel() }
    viewModel { EventViewModel() }
    viewModel { EventDetailViewModel() }
    viewModel { TeamViewModel() }
    viewModel { ProfileViewModel() }
    viewModel { TeamDetailViewModel() }
}