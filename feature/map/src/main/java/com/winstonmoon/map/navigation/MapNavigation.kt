package com.winstonmoon.map.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.winstonmoon.map.MapRoute

const val mapNavigationRoute = "map_route"

fun NavController.navigateToMap(navOptions: NavOptions? = null) {
    this.navigate(mapNavigationRoute, navOptions)
}

fun NavGraphBuilder.mapScreen() {
    composable(route = mapNavigationRoute) {
        MapRoute()
    }
}