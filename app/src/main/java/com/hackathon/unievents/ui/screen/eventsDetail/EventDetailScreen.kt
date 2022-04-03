package com.hackathon.unievents.ui.screen.eventsDetail

import androidx.compose.runtime.Composable
import com.hackathon.unievents.ui.screen.catalog.FloatingButton
import com.hackathon.unievents.ui.screen.eventsDetail.catalog.EventDetailHolder

@Composable
fun EventDetailScreen(viewModel: EventDetailViewModel) {
    FloatingButton(
        onClick = { viewModel.onUpClicked() },
        content = { EventDetailHolder(onEventClicked = { viewModel.onTeamClicked() }) }
    )
}