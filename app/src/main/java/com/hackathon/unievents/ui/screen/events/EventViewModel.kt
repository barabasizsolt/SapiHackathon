package com.hackathon.unievents.ui.screen.events

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.hackathon.unievents.ui.screen.util.Event

class EventViewModel : ViewModel() {

    var event by mutableStateOf<Event<Action>?>(null)
        private set

    fun onEventClicked() {
        event = Event(Action.NavigateToEventDetailScreen)
    }

    fun onTeamClicked() {
        event = Event(Action.NavigateToTeamDetailScreen)
    }

    fun onUpClicked() {
        event = Event(Action.NavigateUp)
    }

    sealed class Action {
        object NavigateUp: Action()
        object NavigateToEventDetailScreen: Action() // Todo [high] pass id
        object NavigateToTeamDetailScreen: Action() // Todo [high] pass id
    }
}