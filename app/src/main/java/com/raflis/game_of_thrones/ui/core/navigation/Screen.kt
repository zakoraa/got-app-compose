package com.raflis.game_of_thrones.ui.core.navigation

sealed class Screen(val route: String) {
    data object Home : Screen("home")
    data object About : Screen("about")
    data object CharacterDetail : Screen("character_detail/{id}") {
        fun createRoute(characterId: Int) = "character_detail/$characterId"
    }
}