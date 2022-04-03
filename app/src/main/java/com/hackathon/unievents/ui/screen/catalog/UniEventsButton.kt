package com.hackathon.unievents.ui.screen.catalog

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.hackathon.unievents.ui.theme.Typography

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun UniEventsButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    color: Color = Color(color = 0xffd84315),
    isLoading: Boolean = false,
    isEnabled: Boolean = false
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(size = 16.dp),
        elevation = 4.dp,
        backgroundColor = if (isEnabled) color else Color.Gray,
        onClick = onClick
    ) {
        Row(horizontalArrangement = Arrangement.Center) {
            if (isLoading) {
                CircularProgressIndicator(
                    color = MaterialTheme.colors.onSurface,
                    modifier = Modifier.padding(all = 16.dp)
                )
            } else {
                Text(
                    text = text,
                    modifier = Modifier.padding(all = 16.dp),
                    style = Typography.body2,
                    color = Color.White
                )
            }
        }
    }
}