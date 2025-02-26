package com.raflis.game_of_thrones.ui.core.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import coil.compose.AsyncImage
import com.raflis.game_of_thrones.R

@Composable
fun NetworkImage(
    urlImage: String,
    modifier: Modifier = Modifier,
    contentScale: ContentScale = ContentScale.Fit,
) {
    AsyncImage(
        model = urlImage,
        contentDescription = stringResource(R.string.network_image_desc),
        contentScale = contentScale,
        modifier = modifier,
    )
}