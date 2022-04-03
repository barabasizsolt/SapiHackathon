package com.hackathon.unievents.ui.screen.catalog

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun UniEventsInput(
    text: String,
    label: String,
    modifier: Modifier = Modifier,
    onValueChange: (String) -> Unit = {},
    isEnabled: Boolean = true,
    keyboardOptions: KeyboardOptions = KeyboardOptions(),
    keyboardActions: KeyboardActions = KeyboardActions()
) {
    Column(modifier = modifier.fillMaxWidth()) {
        Text(
            text = label,
            color = Color.Gray
        )
        Spacer(modifier = Modifier.height(height = 4.dp))
        OutlinedTextField(
            value = text,
            onValueChange = onValueChange,
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    if (isSystemInDarkTheme()) Color.Black else Color.White,
                    RoundedCornerShape(size = 12.dp)
                ),
            shape = RoundedCornerShape(size = 12.dp),
            maxLines = 1,
            singleLine = true,
            enabled = isEnabled,
            keyboardActions = keyboardActions,
            keyboardOptions = keyboardOptions
        )
    }
}
