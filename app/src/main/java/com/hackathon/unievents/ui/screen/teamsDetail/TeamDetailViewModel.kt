package com.hackathon.unievents.ui.screen.teamsDetail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.hackathon.unievents.ui.screen.util.Event

class TeamDetailViewModel : ViewModel() {

    var event by mutableStateOf<Event<Action>?>(null)
        private set

    fun onUpClicked() {
        event = Event(Action.NavigateUp)
    }

    sealed class Action {
        object NavigateUp: Action()
    }
}