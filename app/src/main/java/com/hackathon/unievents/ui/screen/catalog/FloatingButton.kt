package com.hackathon.unievents.ui.screen.catalog

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun FloatingButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    content: @Composable () -> Unit
) {
    Box(modifier = modifier.wrapContentSize()) {
        content()
        FloatingActionButton(
            onClick = onClick,
            modifier = Modifier
                .align(Alignment.TopStart)
                .size(size = 40.dp)
                .offset(x = 12.dp, y = 12.dp)
            ,
            shape = CircleShape,
            backgroundColor = Color.Gray
        ) {
            Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = null, tint = Color.White)
        }
    }
}