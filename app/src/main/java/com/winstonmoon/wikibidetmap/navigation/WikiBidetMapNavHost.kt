package com.winstonmoon.wikibidetmap.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.winstonmoon.login.navigation.loginScreen
import com.winstonmoon.map.navigation.mapScreen
import com.winstonmoon.settings.navigation.settingsScreen
import com.winstonmoon.welcome.navigation.welcomeScreen

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
        loginScreen()
        mapScreen()
        settingsScreen()
        welcomeScreen()
    }
}