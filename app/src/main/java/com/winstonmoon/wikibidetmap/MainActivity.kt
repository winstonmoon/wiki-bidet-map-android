package com.winstonmoon.wikibidetmap

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.view.WindowCompat
import androidx.navigation.compose.rememberNavController
import com.winstonmoon.presentation.theme.WikiBidetMapTheme
import com.winstonmoon.wikibidetmap.navigation.WikiBidetMapNavHost
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            WikiBidetMapTheme {
                val navController = rememberNavController()
                WikiBidetMapNavHost(
                    navController = navController,
                    //TODO
                    startDestination = "map_route"
//                    startDestination = "settings_route"
                )
            }
        }
    }
}