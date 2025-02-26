package com.raflis.game_of_thrones.ui.feature.about.screen

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.raflis.game_of_thrones.ui.feature.about.component.AboutAppBar
import com.raflis.game_of_thrones.ui.feature.about.component.AboutSection

@Composable
fun AboutScreen(navController: NavHostController, modifier: Modifier = Modifier) {
    Scaffold(
        topBar = {
            AboutAppBar(onBackClick = { navController.popBackStack() })
        },
        modifier = modifier
    ) { innerPadding ->
        AboutSection(innerPadding)
    }
}
