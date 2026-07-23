package com.skil.app.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.skil.app.presentation.HomeScreenViewModel
import com.skil.app.theme.MemphisTheme
import com.skil.app.ui.screens.HomeScreen

/**
 * App - Cross-Platform Root Entry Point for Compose Multiplatform
 * Runs identically on Android, Web (Wasm), Windows/macOS Desktop, and iOS.
 */
@Composable
fun App() {
    val viewModel = remember { HomeScreenViewModel() }

    MemphisTheme {
        HomeScreen(viewModel = viewModel)
    }
}
