package com.winstonmoon.wikibidetmap

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import androidx.navigation.compose.rememberNavController
import com.winstonmoon.presentation.theme.WikiBidetMapTheme
import com.winstonmoon.wikibidetmap.navigation.WikiBidetMapNavHost

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            WikiBidetMapTheme {
                val navController = rememberNavController()
                WikiBidetMapNavHost(
                    navController = navController,
                    startDestination = "login"
                )
            }
        }
    }
}