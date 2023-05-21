package com.winstonmoon.wikibidetmap.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.winstonmoon.login.navigation.loginRoute
import com.winstonmoon.map.navigation.mapRoute
import com.winstonmoon.map.navigation.navigateToMap
import com.winstonmoon.settings.navigation.navigateToSettings
import com.winstonmoon.settings.navigation.settingsRoute
import com.winstonmoon.welcome.navigation.welcomeRoute

@Composable
fun WikiBidetMapNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    startDestination: String,
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier,
    ) {
        loginRoute()
        mapRoute(
            navigateToMap = {
                navController.popBackStack()
                navController.navigateToMap()
            },
            navigateToSettings = {
                navController.popBackStack()
                navController.navigateToSettings()
            }
        )
        settingsRoute()
        welcomeRoute()
    }
}