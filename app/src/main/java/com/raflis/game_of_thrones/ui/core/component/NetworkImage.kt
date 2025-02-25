package com.raflis.game_of_thrones.ui.core.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import coil.compose.AsyncImage

@Composable
fun NetworkImage(urlImage: String, modifier: Modifier = Modifier) {
    AsyncImage(
        model = urlImage,
        contentDescription = "Network Image",
        modifier = Modifier
    )
}