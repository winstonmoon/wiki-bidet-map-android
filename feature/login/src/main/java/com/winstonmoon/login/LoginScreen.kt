package com.winstonmoon.login

import android.app.Activity
import androidx.compose.animation.*
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layout
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.core.view.doOnPreDraw

@Composable
internal fun LoginRoute(
    modifier: Modifier = Modifier,
) {
    LoginScreen(
        modifier = modifier,
    )
}

@Composable
internal fun LoginScreen(
    modifier: Modifier = Modifier,
) {

}