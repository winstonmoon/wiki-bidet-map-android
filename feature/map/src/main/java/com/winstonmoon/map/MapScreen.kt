package com.winstonmoon.map

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import com.google.android.material.shape.CornerSize
import kotlin.math.round
import androidx.compose.ui.unit.dp

@Composable
internal fun MapRoute(
    modifier: Modifier = Modifier,
) {
    MapScreen(
        modifier = modifier,
    )
}

@Composable
internal fun MapScreen(
    modifier: Modifier = Modifier,
) {
    Box(
        modifier =
            modifier.shadow(shadowElevation, shape, clip = false)
            .then(if (border != null) Modifier.border(border, shape) else Modifier)
            .background(color = backgroundColor, shape = RoundedCornerShape(corner = CornerSize(8.dp)))
            .clip(shape)
    ) {

    }

}