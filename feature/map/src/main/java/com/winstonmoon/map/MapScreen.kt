package com.winstonmoon.map

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
internal fun MapRoute(
    modifier: Modifier = Modifier,
) {
    MapScreen(
        modifier = modifier,
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun MapScreen(
    modifier: Modifier = Modifier,
) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    var value by remember {
        mutableStateOf("")
    }
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                ModalNavigationDrawerTitle()
                Divider()
                ModalNavigationDrawerMap()
                ModalNavigationDrawerSettings()
            }
        },
        content = {
            Box {
//            AndroidView(factory = )
                Image(
                    modifier = Modifier.fillMaxSize(),
                    painter = painterResource(id = R.drawable.baseline_menu_40),
                    contentDescription = ""
                )
                Card(
                    modifier = Modifier
                        .padding(start = 10.dp, end = 10.dp, top = 10.dp)
                        .fillMaxWidth()
                        .shadow(elevation = 10.dp, shape = RoundedCornerShape(10.dp))
                ) {
                    Row() {
                        Image(
                            modifier = Modifier.clickable(onClick = {
                                scope.launch {
                                    drawerState.apply {
                                        if (isClosed) open() else close()
                                    }
                                }
                            }),
                            painter = painterResource(id = R.drawable.baseline_menu_40),
                            contentDescription = "menu icon"
                        )
                        TextField(
                            modifier = Modifier.weight(weight = 0.8f, fill = true),
                            value = value,
                            onValueChange = { newText ->
                                value = newText
                            },
                            colors = TextFieldDefaults.textFieldColors(
                                focusedIndicatorColor = Color.Transparent,
                                unfocusedIndicatorColor = Color.Transparent,
                                disabledIndicatorColor = Color.Transparent
                            ),
                            placeholder = { Text("Search here") }
                        )
                        Image(
                            painter = painterResource(id = R.drawable.baseline_search_40),
                            contentDescription = "search icon"
                        )
                    }
                }
            }
        })
}

@Composable
private fun ModalNavigationDrawerTitle(modifier: Modifier = Modifier) {
    Row() {
        Image(
            painter = painterResource(id = R.drawable.baseline_menu_40),
            contentDescription = "app icon"
        )
        Text(text = "Wiki Bidet Map")
    }
}

@Composable
private fun ModalNavigationDrawerMap(modifier: Modifier = Modifier) {
    Row() {
        Image(
            painter = painterResource(id = R.drawable.baseline_map_40),
            contentDescription = "map icon"
        )
        Text(text = "Map")
    }
}

@Composable
private fun ModalNavigationDrawerSettings(modifier: Modifier = Modifier) {
    Row() {
        Image(
            painter = painterResource(id = R.drawable.baseline_settings_40),
            contentDescription = "settings icon"
        )
        Text(text = "Settings")
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMapScreen() {
    MapScreen()
}

@Preview
@Composable
fun PreviewModalNavigationDrawerTitle() {
    ModalNavigationDrawerTitle()
}

@Preview
@Composable
fun PreviewModalNavigationDrawerMap() {
    ModalNavigationDrawerMap()
}

@Preview
@Composable
fun PreviewModalNavigationDrawerSettings() {
    ModalNavigationDrawerSettings()
}