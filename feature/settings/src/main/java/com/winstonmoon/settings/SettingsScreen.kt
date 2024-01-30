package com.winstonmoon.settings

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun SettingsScreen(
    modifier: Modifier = Modifier,
    back: () -> Unit
) {
    var showLanguageSettingsDialog by remember { mutableStateOf(false) }
    var showDarkModeSettingsDialog by remember { mutableStateOf(false) }

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
                SettingsText( "Language") {
                    showLanguageSettingsDialog = true
                }
                SettingsText( "Dark Mode") {
                    showDarkModeSettingsDialog = true
                }
            }
        }
    )
    if (showLanguageSettingsDialog) {
        LanguageSettingsDialog(
            onDismiss = { showLanguageSettingsDialog = false },
        )
    }
    if (showDarkModeSettingsDialog) {
        DarkModeSettingsDialog(
            onDismiss = { showDarkModeSettingsDialog = false },
        )
    }
}
@Composable
internal fun SettingsText(
    text: String,
    onClick: () -> Unit
) {
    Text(modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 16.dp)
        .clickable {
            onClick()
        },
        text = text,style = MaterialTheme.typography.bodyLarge)
}

@Composable
internal fun LanguageSettingsDialog(
    onDismiss: () -> Unit,
) {
        AlertDialog(
            onDismissRequest = { onDismiss() },
            title = {
                Column(
                    Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(5.dp)
                ) {
                    Text(text = "Language")
                }
            },
            text = {
                val radioOptions = listOf(
                    "Follow system",
                    "English",
                    "Korean",
                    "Japanese",
                    "Chinese")
                val (selectedOption, onOptionSelected) = rememberSaveable { mutableStateOf(radioOptions[0]) }
                Column(
                    Modifier.fillMaxWidth()
                ) {
                    radioOptions.forEach { text ->
                        Row(
                            Modifier
                                .fillMaxWidth()
                                .selectable(
                                    selected = (text == selectedOption),
                                    onClick = {
                                        onOptionSelected(text)
                                    }
                                )
                                .padding(vertical = 5.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            RadioButton(
                                selected = (text == selectedOption),
                                onClick = { onOptionSelected(text) }
                            )
                            Text(
                                text = text
                            )
                        }
                    }
                }
            },
            confirmButton = {
                TextButton(onClick = { onDismiss() }) {
                    Text("cancel")
                }
            }, modifier = Modifier.padding(vertical = 5.dp)
        )
    }

@Composable
internal fun DarkModeSettingsDialog(
    onDismiss: () -> Unit,
) {
    AlertDialog(
        onDismissRequest = { onDismiss() },
        title = {
            Column(
                Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                Text(text = "Language")
            }
        },
        text = {
            val radioOptions = listOf(
                "Follow system",
                "Dark",
                "Light",
                )
            val (selectedOption, onOptionSelected) = rememberSaveable { mutableStateOf(radioOptions[0]) }
            Column(
                Modifier.fillMaxWidth()
            ) {
                radioOptions.forEach { text ->
                    Row(
                        Modifier
                            .fillMaxWidth()
                            .selectable(
                                selected = (text == selectedOption),
                                onClick = {
                                    onOptionSelected(text)
                                }
                            )
                            .padding(vertical = 5.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = (text == selectedOption),
                            onClick = { onOptionSelected(text) }
                        )
                        Text(
                            text = text
                        )
                    }
                }
            }
        },
        confirmButton = {
            TextButton(onClick = { onDismiss() }) {
                Text("cancel")
            }
        }, modifier = Modifier.padding(vertical = 5.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewMapScreen() {
    SettingsScreen(back = {})
}