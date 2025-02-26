package com.raflis.game_of_thrones

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.raflis.game_of_thrones.ui.core.navigation.Screen
import com.raflis.game_of_thrones.ui.feature.about.screen.AboutScreen
import com.raflis.game_of_thrones.ui.feature.character_detail.screen.CharacterDetailScreen
import com.raflis.game_of_thrones.ui.feature.home.screen.HomeScreen

@Composable
fun MyApp() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(Screen.Home.route) { HomeScreen(navController) }
        composable(Screen.About.route) { AboutScreen(navController) }
        composable(Screen.CharacterDetail.route) { backStackEntry ->
            val characterId = backStackEntry.arguments?.getString("id")?.toIntOrNull()
            characterId?.let {
                CharacterDetailScreen(navController, it)
            }
        }
    }
}
