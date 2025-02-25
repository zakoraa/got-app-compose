package com.raflis.game_of_thrones.ui.feature.home.component

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun HomeHeader() {
    Surface(
        color = MaterialTheme.colorScheme.primary,
        modifier = Modifier,
    ) {
        Text(
            text = "Game of Thrones",
            style = MaterialTheme.typography.titleLarge,
        )
    }
}