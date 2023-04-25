package com.winstonmoon.map

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

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
    ) { paddingValues ->
        Box(Modifier.padding(paddingValues = paddingValues)) {
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
                        },
                        colors = TextFieldDefaults.textFieldColors(
                            backgroundColor = Color.White,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                            disabledIndicatorColor = Color.Transparent
                        ),
                        placeholder = { Text("Search here") }
                    )
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