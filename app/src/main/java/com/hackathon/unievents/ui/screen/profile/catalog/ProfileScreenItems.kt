package com.hackathon.unievents.ui.screen.profile.catalog


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.hackathon.unievents.R

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

