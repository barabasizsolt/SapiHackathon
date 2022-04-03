package com.hackathon.unievents.ui.screen.profile.catalog

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.hackathon.unievents.R
import com.hackathon.unievents.ui.theme.Typography

@Composable
fun ProfileAvatar(
    modifier: Modifier = Modifier,
    avatarId: Int = R.drawable.avatar
) {
    Card(
        shape = RoundedCornerShape(size = 12.dp),
        elevation = 4.dp,
        modifier = modifier.wrapContentHeight(),
    ) {
        Image(
            painter = painterResource(id = avatarId),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.size(size = 100.dp)
        )
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ProfileLogoutButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(size = 16.dp),
        elevation = 4.dp,
        backgroundColor = Color(color = 0xffd84315),
        onClick = onClick
    ) {
        Row(horizontalArrangement = Arrangement.Center) {
            Text(
                text = "Logout",
                Modifier.padding(all = 16.dp),
                style = Typography.body2,
                color = Color.White
            )
        }
    }
}

