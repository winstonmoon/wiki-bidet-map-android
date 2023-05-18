package com.winstonmoon.map

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Map
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.constraintlayout.solver.state.helpers.AlignVerticallyReference
import com.mapbox.maps.MapView
import com.mapbox.maps.ResourceOptionsManager
import com.mapbox.maps.Style
import com.mapbox.maps.dsl.cameraOptions
import kotlinx.coroutines.launch

//@Composable
//internal fun MapRoute(
//    modifier: Modifier = Modifier,
//    navigateToMap = ,
//    navigateToSettings =
//) {
//    MapScreen(
//        modifier = modifier
//    )
//}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun MapScreen(
    modifier: Modifier = Modifier,
    navigateToMap: () -> Unit,
    navigateToSettings: () -> Unit
) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    var value by remember {
        mutableStateOf("")
    }
    var text by rememberSaveable { mutableStateOf("") }
    var active by rememberSaveable { mutableStateOf(false) }

    val items = listOf(stringResource(id = R.string.map_title), stringResource(id = R.string.settings_title))
    val selectedItem = remember { mutableStateOf(items[0]) }
    ModalNavigationDrawer(
        drawerState = drawerState,
        gesturesEnabled = drawerState.isOpen,
        drawerContent = {
            ModalDrawerSheet {
                WikiBidetMapLogo(
                    modifier = Modifier.padding(horizontal = 28.dp, vertical = 24.dp)
                )
                NavigationDrawerItem(
                    label = { Text(stringResource(id = R.string.map_title)) },
                    icon = { Icon(Icons.Default.Map, null) },
//                    selected = currentRoute == JetnewsDestinations.HOME_ROUTE,
//                    onClick = { navigateToHome(); closeDrawer() },
                    selected = stringResource(id = R.string.map_title) == selectedItem.value,
                    onClick = {
                        scope.launch { drawerState.close() }
                        navigateToMap
                        selectedItem.value = "Map"
                    },
                    modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
                )
                NavigationDrawerItem(
                    label = { Text(stringResource(id = R.string.settings_title)) },
                    icon = { Icon(Icons.Default.Settings, null) },
//                    selected = currentRoute == JetnewsDestinations.HOME_ROUTE,
//                    onClick = { navigateToHome(); closeDrawer() },
                    selected = stringResource(id = R.string.settings_title) == selectedItem.value,
                    onClick = {
                        scope.launch { drawerState.close() }
                        navigateToSettings
                        selectedItem.value = "Settings"
                              },
                    modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
                )
//                Spacer(Modifier.height(12.dp))
//                items.forEach { item ->
//                    NavigationDrawerItem(
//                        icon = { Icon(item, contentDescription = null) },
//                        label = { Text(item.name) },
//                        selected = item == selectedItem.value,
//                        onClick = {
//                            scope.launch { drawerState.close() }
//                            selectedItem.value = item
//                        },
//                        modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
//                    )
//                }
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
                            zoom(1000.0)
                        }
                    }
                }
            }
        )
    }
}

@Composable
private fun WikiBidetMapLogo(modifier: Modifier = Modifier) {
    Row(modifier = modifier) {
//        Icon(
//            painterResource(R.drawable.baseline_map_24),
//            contentDescription = null,
//            tint = MaterialTheme.colorScheme.primary
//        )
        Spacer(Modifier.width(8.dp))
//        Icon(
//            painter = painterResource(R.drawable.ic_jetnews_wordmark),
//            contentDescription = stringResource(R.string.app_name),
//            tint = MaterialTheme.colorScheme.onSurfaceVariant
//        )
        Text(text = "Wiki Bidet Map")
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewMapScreen() {
    MapScreen(navigateToMap = navigateToMap, )
}