package com.winstonmoon.map

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.android.material.shape.CornerSize
import kotlin.math.round
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import kotlinx.coroutines.launch

@Composable
internal fun MapRoute(
    modifier: Modifier = Modifier,
) {
    MapScreen(
        modifier = modifier,
    )
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
internal fun MapScreen(
    modifier: Modifier = Modifier,
) {
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    var value by remember {
        mutableStateOf("")
    }
    Scaffold(
        scaffoldState = scaffoldState,
        drawerContent = {
            Text("Drawer title", modifier = Modifier.padding(16.dp))
            Divider()
            // Drawer items
        }
    ) {
        Box() {
//            AndroidView(factory = )
            Image(
                painter = painterResource(id = R.drawable.baseline_menu_40),
                contentDescription = "",
                modifier = Modifier.fillMaxSize()
            )
            Card(
                modifier = Modifier
                    .padding(start = 10.dp, end = 10.dp, top = 10.dp)
                    .fillMaxWidth()
                    .shadow(elevation = 10.dp, shape = RoundedCornerShape(10.dp))
            ) {
                Row() {
                    Image(
                        painter = painterResource(id = R.drawable.baseline_menu_40),
                        contentDescription = "menu",
                        modifier = Modifier.clickable(onClick = {
                            scope.launch {
                                scaffoldState.drawerState.apply {
                                    if (isClosed) open() else close()
                                }
                            }
                        })
                    )
                    TextField(
                        value = value,
                        onValueChange = { newText ->
                            value = newText
                        })
                    Image(
                        painter = painterResource(id = R.drawable.baseline_search_40),
                        contentDescription = "search"
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewMapScreen() {
    MapScreen()
}