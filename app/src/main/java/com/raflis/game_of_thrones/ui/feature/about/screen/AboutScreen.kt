package com.raflis.game_of_thrones.ui.feature.about.screen

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.raflis.game_of_thrones.ui.feature.about.component.AboutAppBar
import com.raflis.game_of_thrones.ui.feature.about.component.AboutSection
import com.raflis.game_of_thrones.ui.theme.GameOfThronesTheme

@Composable
fun AboutScreen(modifier: Modifier = Modifier) {
    Scaffold(
        topBar = {
            AboutAppBar(onBackClick = {})
        },

        modifier = modifier
    ) { innerPadding ->
        AboutSection(innerPadding)
    }
}

@Preview(showBackground = true)
@Composable
fun AboutScreenPreview() {
    GameOfThronesTheme {
        AboutScreen()
    }
}