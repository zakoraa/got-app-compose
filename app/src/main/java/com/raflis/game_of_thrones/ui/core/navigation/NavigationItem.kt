package com.raflis.game_of_thrones.ui.core.navigation

import androidx.compose.ui.graphics.vector.ImageVector

data class NavigationItem(
    val title: String,
    val icon: ImageVector,
    val screen: Screen
)