package com.winstonmoon.welcome.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.winstonmoon.welcome.WelcomeRoute

const val welcomeNavigationRoute = "welcome_route"

fun NavController.navigateToWelcome(navOptions: NavOptions? = null) {
    this.navigate(welcomeNavigationRoute, navOptions)
}

fun NavGraphBuilder.welcomeScreen() {
    composable(route = welcomeNavigationRoute) {
        WelcomeRoute()
    }
}