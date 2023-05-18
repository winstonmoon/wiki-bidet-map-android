package com.winstonmoon.login.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.winstonmoon.login.LoginRoute
import com.winstonmoon.login.LoginScreen

const val loginNavigationRoute = "login_route"

fun NavController.navigateToLogin(navOptions: NavOptions? = null) {
    this.navigate(loginNavigationRoute, navOptions)
}

fun NavGraphBuilder.loginRoute() {
    composable(route = loginNavigationRoute) {
        LoginScreen()
    }
}