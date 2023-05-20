package com.winstonmoon.map.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.winstonmoon.map.MapScreen

const val mapNavigationRoute = "map_route"

fun NavController.navigateToMap(navOptions: NavOptions? = null) {
    this.navigate(mapNavigationRoute, navOptions)
}

fun NavGraphBuilder.mapRoute(
    navigateToMap: () -> Unit,
    navigateToSettings: () -> Unit,
) {
    composable(route = mapNavigationRoute) {
        MapScreen(
            navigateToMap = navigateToMap,
            navigateToSettings = navigateToSettings
        )
    }
}