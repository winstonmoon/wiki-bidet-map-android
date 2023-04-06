package com.winstonmoon.wikibidetmap.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost

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

    }
}