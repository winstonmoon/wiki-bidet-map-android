package com.winstonmoon.settings

import android.app.Dialog
import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.text.ClickableText
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
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
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
    var state by remember { mutableStateOf(false) }
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
                SettingsClickableText(context, "Language") {
                    state = true
                }
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
                SettingsClickableText(context, "Dark Mode") {

                }
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
    if (state) {
        LanguageAlertDialog()
    }
}
@Composable
internal fun SettingsClickableText(context: Context, text: String, onClick: (Int) -> Unit) {
    ClickableText(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        text = AnnotatedString(text),
        style = MaterialTheme.typography.bodyLarge,
        onClick = {  }
    )
//    TextButton(modifier = Modifier
//        .fillMaxWidth()
//        .padding(horizontal = 16.dp),
//        onClick = { Toast.makeText(context, text, Toast.LENGTH_SHORT).show() }) {
//        Text(text = text,style = MaterialTheme.typography.bodyLarge)
//    }
}

@Composable
internal fun LanguageAlertDialog() {
    AlertDialog(
        onDismissRequest = {

        },
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
            val (selectedOption, onOptionSelected) = remember { mutableStateOf(radioOptions[2]) }
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
            TextButton(onClick = {  }) {
                Text("cancel")
            }
        }, modifier = Modifier.padding(vertical = 5.dp)
    )
}

@Composable
internal fun DarkModeAlertDialog() {

}

@Preview(showBackground = true)
@Composable
fun PreviewMapScreen() {
    SettingsScreen(back = {})
}