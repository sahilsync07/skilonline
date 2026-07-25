package com.skil.app.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val AppLightColorScheme = lightColorScheme(
    primary = AppColors.AccentGold,
    onPrimary = Color.White,
    secondary = AppColors.AccentDeep,
    onSecondary = Color.White,
    background = AppColors.SurfaceBackground,
    onBackground = AppColors.TextPrimary,
    surface = AppColors.PanelBackground,
    onSurface = AppColors.TextPrimary,
    outline = AppColors.BorderLight
)

@Composable
fun AppTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = AppLightColorScheme,
        content = content
    )
}
