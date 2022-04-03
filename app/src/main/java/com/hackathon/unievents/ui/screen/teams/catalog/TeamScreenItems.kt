package com.hackathon.unievents.ui.screen.teams.catalog

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.hackathon.unievents.R
import com.hackathon.unievents.ui.screen.catalog.IconInfo
import com.hackathon.unievents.ui.screen.catalog.TeamCard
import com.hackathon.unievents.ui.theme.Typography

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MyTeamCard(
    team: String,
    captainName: String,
    teamImageId: Int,
    date: String = "01.03.2019",
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    onLeaveClick: () -> Unit
) {
    Column(
        modifier = modifier
            .padding(
                start = 12.dp,
                end = 12.dp,
                bottom = 12.dp,
                top = 4.dp
            )
            .clickable { onClick() },
        verticalArrangement = Arrangement.spacedBy(space = 10.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Current team",
                style = Typography.h6,
                fontWeight = FontWeight.Bold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.weight(weight = 1f)
            )
            Card(
                shape = RoundedCornerShape(size = 16.dp),
                backgroundColor = Color(color = 0xffd84315),
                onClick = onLeaveClick
            ) {
                Text(
                    text = "Leave the team",
                    color = Color.White,
                    style = Typography.overline,
                    modifier = Modifier.padding(all = 10.dp)
                )
            }
        }
        IconInfo(
            text = "Member since: $date",
            iconId = R.drawable.ic_member,
            modifier = Modifier.padding(top = 10.dp)
        )
        IconInfo(
            text = "16 participants",
            iconId = R.drawable.ic_participant
        )
        TeamCard(
            team = team,
            captainName = captainName,
            teamImageId = teamImageId,
            onClick = onClick
        )
    }
}

@Composable
fun TeamDivider(
    height: Dp,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxWidth()) {
        Spacer(modifier = modifier.height(height = height))
        Text(
            text = "Available teams",
            style = Typography.h6,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(height = 4.dp))
    }

}