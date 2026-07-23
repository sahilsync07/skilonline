package com.skil.app.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val MemphisLightColorScheme = lightColorScheme(
    primary = MemphisColors.LimeYellow,
    onPrimary = Color.Black,
    secondary = MemphisColors.MemphisPink,
    onSecondary = Color.Black,
    tertiary = MemphisColors.RetroCyan,
    onTertiary = Color.Black,
    background = MemphisColors.CanvasBackground,
    onBackground = MemphisColors.TextMain,
    surface = MemphisColors.CardBackground,
    onSurface = MemphisColors.TextMain,
    outline = MemphisColors.BorderBlack
)

@Composable
fun MemphisTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = MemphisLightColorScheme,
        content = content
    )
}
