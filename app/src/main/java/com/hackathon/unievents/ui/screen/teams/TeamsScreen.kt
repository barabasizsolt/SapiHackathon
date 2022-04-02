package com.hackathon.unievents.ui.screen.teams

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.hackathon.unievents.R
import com.hackathon.unievents.ui.screen.catalog.CardHolder
import com.hackathon.unievents.ui.screen.catalog.ScreenTitle
import com.hackathon.unievents.ui.screen.catalog.TeamCard
import com.hackathon.unievents.ui.screen.teams.catalog.MyTeamCard
import com.hackathon.unievents.ui.screen.teams.catalog.TeamDivider
import com.hackathon.unievents.ui.theme.Typography

@Composable
fun TeamsScreen(viewModel: TeamViewModel) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Card(
            elevation = 4.dp,
            shape = RoundedCornerShape(size = 0.dp)
        ) {
            ScreenTitle(
                title = "Student Teams",
                modifier = Modifier.padding(top = 20.dp, start = 20.dp, bottom = 10.dp)
            )
        }
        LazyColumn(
            contentPadding = PaddingValues(bottom = 20.dp),
            verticalArrangement = Arrangement.spacedBy(space = 12.dp),
            modifier = Modifier.navigationBarsPadding()
        ) {
            item {
                CardHolder {
                    MyTeamCard(
                        team = "Team Halcyon",
                        captainName = "Kacso Gellert",
                        teamImageId = R.drawable.event_card_img,
                        onClick = { viewModel.onTeamClicked() },
                        onLeaveClick = { /*Leave the team*/ },
                        modifier = Modifier.padding(top = 10.dp, bottom = 10.dp)
                    )
                }
            }
            item {
                TeamDivider(
                    height = 15.dp,
                    modifier = Modifier.padding(start = 20.dp, end = 20.dp)
                )
            }
            items(count = 5) {
                TeamCard(
                    team = "Team Forest",
                    captainName = "Lebron James",
                    teamImageId = R.drawable.forest_team_img,
                    onClick = { viewModel.onTeamClicked() },
                    modifier = Modifier.padding(start = 20.dp, end = 20.dp),
                    elevation = 4.dp,
                    showJoinOption = true
                )
            }
        }
    }
}