package com.winstonmoon.map

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import com.mapbox.maps.MapView
import com.mapbox.maps.ResourceOptionsManager
import com.mapbox.maps.Style
import com.mapbox.maps.dsl.cameraOptions
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
    var text by rememberSaveable { mutableStateOf("") }
    var active by rememberSaveable { mutableStateOf(false) }
    ModalNavigationDrawer(
        drawerState = drawerState,
        gesturesEnabled = drawerState.isOpen,
        drawerContent = {
            ModalDrawerSheet {
                ModalNavigationDrawerTitle()
                ModalNavigationDrawerMap()
                ModalNavigationDrawerSettings()
            }
        },
        content = {
            Box {
                MapboxView()
                SearchBar(
                    modifier = Modifier.align(Alignment.TopCenter),
                    query = text,
                    onQueryChange = { text = it },
                    onSearch = { active = false },
                    active = false,
                    onActiveChange = {
                        active = it
                    },
                    placeholder = { Text("Search here") },
                    leadingIcon = {
                        IconButton(onClick = {
                            scope.launch {
                                drawerState.apply {
                                    if (isClosed) open() else close()
                                }
                            }
                        }) {
                            Icon(Icons.Default.Menu, contentDescription = "menu icon")
                        }
                    },
                    trailingIcon = {
                        Icon(
                            Icons.Default.Search,
                            contentDescription = "search icon"
                        )
                    },
                ) {

                }
            }
        }
    )
}

@Composable
fun MapboxView(modifier: Modifier = Modifier) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .fillMaxSize()
    ) {
        AndroidView(
            modifier = Modifier,
            factory = { context ->
                ResourceOptionsManager.getDefault(
                    context,
                    context.getString(R.string.mapbox_access_token)
                )

                MapView(context).apply {
                    getMapboxMap().loadStyleUri(Style.MAPBOX_STREETS) {
                        cameraOptions {
                            zoom(19.0)
                        }
                    }
                }
            }
        )
    }
}

@Composable
private fun ModalNavigationDrawerTitle(modifier: Modifier = Modifier) {
    Row() {
        Text(text = "Wiki Bidet Map")
    }
}

@Composable
private fun ModalNavigationDrawerMap(modifier: Modifier = Modifier) {
    Row() {
        Image(
            painter = painterResource(id = R.drawable.baseline_map_24),
            contentDescription = "map icon"
        )
        Text(text = "Map")
    }
}

@Composable
private fun ModalNavigationDrawerSettings(modifier: Modifier = Modifier) {
    Row() {
        Image(
            painter = painterResource(id = R.drawable.baseline_settings_24),
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