package com.hackathon.unievents.ui.screen.teamsDetail.catalog

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.hackathon.unievents.R
import com.hackathon.unievents.ui.screen.catalog.DescriptionHolder
import com.hackathon.unievents.ui.screen.catalog.IconInfo
import com.hackathon.unievents.ui.screen.catalog.ScreenHeader
import com.hackathon.unievents.ui.screen.catalog.ScreenTitle
import com.hackathon.unievents.ui.theme.Typography

@Composable
fun TeamsDetailScreenHolder(
    modifier: Modifier = Modifier
) {

    val listState = rememberLazyGridState()

    val transition = updateTransition(listState.firstVisibleItemIndex != 0, label = "Image Size Transition")

    val cornerRadius by transition.animateDp(
        label = "",
        transitionSpec = { tween(easing = LinearEasing) }
    ) { isScrolling ->
        if (isScrolling) 0.dp else 20.dp
    }

    val padding by transition.animateDp(
        label = "",
        transitionSpec = { tween(easing = LinearEasing) }
    ) { isScrolling ->
        if (isScrolling) 0.dp else 100.dp
    }

    Box(
        modifier = modifier
            .fillMaxWidth()
            .navigationBarsPadding()
    ) {
        Image(
            painter = painterResource(id = R.drawable.forest_team_img),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .offset(y = (-60).dp),
            contentScale = ContentScale.Fit
        )
        Card(
            shape = RoundedCornerShape(topStart = cornerRadius, topEnd = cornerRadius),
            modifier = Modifier
                .padding(top = padding)
                .fillMaxSize(),
            backgroundColor = MaterialTheme.colors.background
        ) {
            LazyVerticalGrid(
                state = listState,
                columns = GridCells.Fixed(count = 3),
                contentPadding = PaddingValues(all = 20.dp),
                verticalArrangement = Arrangement.spacedBy(space = 12.dp),
                modifier = Modifier.navigationBarsPadding(),
                content = {
                    item(span = { GridItemSpan(currentLineSpan = maxCurrentLineSpan) }) {
                        ScreenHeader(
                            title = "Halcyon Mobile",
                            subtitle = "Kacso Gellert",
                            modifier = Modifier.padding(bottom = 12.dp)
                        )
                    }
                    item(span = { GridItemSpan(currentLineSpan = maxCurrentLineSpan) }) {
                        DescriptionHolder(
                            title = "Team description",
                            description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam rutrum tempus ex eget lacinia. Donec vel erat ut est varius tristique. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed auctor libero felis, id vehicula nulla lacinia fringilla. Cras faucibus nisl rutrum",
                            modifier = Modifier.padding(top = 12.dp)
                        )
                    }
                    item(span = { GridItemSpan(currentLineSpan = maxCurrentLineSpan) }) {
                        DescriptionParticipantDivider(
                            modifier = Modifier.padding(top = 12.dp)
                        )
                    }
                    items(count = 9) {
                        DescriptionParticipant(
                            name = "John Doe",
                            avatarId = R.drawable.avatar,
                            modifier = Modifier.padding(all = 4.dp)
                        )
                    }
                }
            )
        }
    }
}

@Composable
private fun DescriptionParticipant(
    name: String,
    avatarId: Int,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.wrapContentSize(),
        shape = RoundedCornerShape(size = 12.dp),
        elevation = 4.dp,
        backgroundColor = MaterialTheme.colors.background
    ) {
        Column(
            modifier = Modifier
                .padding(
                    top = 12.dp,
                    start = 14.dp,
                    end = 14.dp,
                    bottom = 20.dp
                ),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(space = 8.dp)
        ) {
            Image(
                painter = painterResource(id = avatarId),
                contentDescription = null,
                modifier = Modifier
                    .size(size = 70.dp)
                    .clip(shape = RoundedCornerShape(size = 12.dp)),
                contentScale = ContentScale.Crop
            )
            Text(
                text = name,
                style = Typography.overline,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
private fun DescriptionParticipantDivider(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(space = 4.dp)
    ) {
        Text(
            text = "Participants",
            style = Typography.body1,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(all = 4.dp)
        )
        IconInfo(
            text = "16 participants",
            iconId = R.drawable.ic_participant,
            modifier = Modifier.padding(start = 4.dp)
        )
    }
}
