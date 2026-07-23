package com.skil.app.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.skil.app.presentation.ECommerceViewModel
import com.skil.app.theme.MemphisColors
import com.skil.app.theme.MemphisTheme
import com.skil.app.ui.screens.ECommerceScreen

/**
 * App - Cross-Platform Root Entry Point for Compose Multiplatform
 * Runs identically on Android, Web (Wasm), Windows/macOS Desktop, and iOS.
 * Features:
 * - Safe area window insets (status bars & gesture navigation safe padding).
 * - Full E-Commerce Store experience matching Web App UI/UX.
 */
@Composable
fun App() {
    val ecommerceViewModel = remember { ECommerceViewModel() }

    MemphisTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MemphisColors.CanvasBackground)
                .safeDrawingPadding()
        ) {
            ECommerceScreen(viewModel = ecommerceViewModel)
        }
    }
}

