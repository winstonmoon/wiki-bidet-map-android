package com.winstonmoon.settings

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun SettingsScreen(
    modifier: Modifier = Modifier,
    back: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Settings")
                },
                navigationIcon = {
                    IconButton(onClick = back) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = null
                        )
                    }
                }
            )
        },
        content = { innerPadding ->
//            LazyColumn(
//                contentPadding = innerPadding,
//                verticalArrangement = Arrangement.spacedBy(8.dp)
//            ) {
//                val list = listOf("Language", "Dark Mode")
//                items(count = list.size) {
//                    Text(
//                        text = list[it],
//                        style = MaterialTheme.typography.bodyLarge,
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .padding(horizontal = 16.dp)
//                    )
//                }
//            }
            Column(
                modifier = Modifier.padding(innerPadding),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                val context = LocalContext.current
                SettingsClickableText(context, "Language")
//                ClickableText(
//                    modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(horizontal = 16.dp),
//                    text = AnnotatedString("Language"),
//                    style = MaterialTheme.typography.bodyLarge,
//                    onClick = {
//                        Toast.makeText(context, "Language", Toast.LENGTH_SHORT).show()
//                    }
//                )
                SettingsClickableText(context, "Dark Mode")
//                ClickableText(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .padding(horizontal = 16.dp),
//                    text = AnnotatedString("Dark Mode"),
//                    style = MaterialTheme.typography.bodyLarge,
//                    onClick = {
//                        Toast.makeText(context, "Dark Mode", Toast.LENGTH_SHORT).show()
//                    }
//                )
            }
        }
    )
}
@Composable
internal fun SettingsClickableText(context: Context, text: String) {
    ClickableText(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        text = AnnotatedString(text),
        style = MaterialTheme.typography.bodyLarge,
        onClick = {
            Toast.makeText(context, "Dark Mode", Toast.LENGTH_SHORT).show()
        }
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewMapScreen() {
    SettingsScreen(back = {})
}