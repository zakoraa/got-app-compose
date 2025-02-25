package com.raflis.game_of_thrones.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val LightColorScheme = lightColorScheme(
    primary = PrimaryColor,
    onPrimary = OnPrimaryColor,

    secondary = SecondaryColor,
    onSecondary = OnSecondaryColor,

    background = BackgroundColor,
    onBackground = OnBackgroundColor,
)

@Composable
fun GameOfThronesTheme(
    content: @Composable () -> Unit
) {
    val colorScheme = LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}