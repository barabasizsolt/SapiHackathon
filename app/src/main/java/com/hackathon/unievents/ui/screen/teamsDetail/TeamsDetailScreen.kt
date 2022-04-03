package com.hackathon.unievents.ui.screen.teamsDetail

import androidx.compose.runtime.Composable
import com.hackathon.unievents.ui.screen.catalog.FloatingButton
import com.hackathon.unievents.ui.screen.teamsDetail.catalog.TeamsDetailScreenHolder

@Composable
fun TeamsDetailScreen(viewModel: TeamDetailViewModel) {
    FloatingButton(
        onClick = { viewModel.onUpClicked() },
        content = { TeamsDetailScreenHolder() }
    )
}