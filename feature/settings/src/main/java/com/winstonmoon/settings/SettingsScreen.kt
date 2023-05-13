package com.winstonmoon.settings

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
internal fun SettingsRoute(
    modifier: Modifier = Modifier,
) {
    SettingsScreen(
        modifier = modifier,
    )
}

@Composable
internal fun SettingsScreen(
    modifier: Modifier = Modifier,
) {
    Column() {
        Row() {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
            }
            Text(text = "Settings")
        }
        Text(text = "Languages")
        Text(text = "Dark Mode")


    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMapScreen() {
    SettingsScreen()
}