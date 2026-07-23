package com.skil.app.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.skil.app.presentation.ECommerceViewModel
import com.skil.app.presentation.HomeScreenViewModel
import com.skil.app.theme.MemphisColors
import com.skil.app.theme.MemphisTheme
import com.skil.app.ui.screens.ECommerceScreen
import com.skil.app.ui.screens.HomeScreen

enum class AppTab {
    STORE, DASHBOARD
}

/**
 * App - Cross-Platform Root Entry Point for Compose Multiplatform
 * Runs identically on Android, Web (Wasm), Windows/macOS Desktop, and iOS.
 * Features:
 * - Safe area window insets (status bars & gesture navigation safe padding).
 * - Super-fluid Memphis bottom navigation bar connecting ECommerceStore & SystemDashboard.
 */
@Composable
fun App() {
    val homeViewModel = remember { HomeScreenViewModel() }
    val ecommerceViewModel = remember { ECommerceViewModel() }
    var currentTab by remember { mutableStateOf(AppTab.STORE) }

    MemphisTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MemphisColors.CanvasBackground)
                .safeDrawingPadding() // Safe space for status bar, battery, network, camera cutouts
        ) {
            Column(modifier = Modifier.fillMaxSize()) {
                // Active Screen Content
                Box(modifier = Modifier.weight(1f)) {
                    when (currentTab) {
                        AppTab.STORE -> ECommerceScreen(viewModel = ecommerceViewModel)
                        AppTab.DASHBOARD -> HomeScreen(viewModel = homeViewModel)
                    }
                }

                // Memphis Light Mode Navigation Bar
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                        .shadow(elevation = 5.dp, shape = RoundedCornerShape(16.dp), spotColor = Color.Black)
                        .background(Color.White, shape = RoundedCornerShape(16.dp))
                        .border(width = 3.dp, color = MemphisColors.BorderBlack, shape = RoundedCornerShape(16.dp))
                        .padding(8.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        NavTabItem(
                            title = "STORE",
                            isSelected = currentTab == AppTab.STORE,
                            accentColor = MemphisColors.LimeYellow,
                            onClick = { currentTab = AppTab.STORE },
                            modifier = Modifier.weight(1f)
                        )
                        NavTabItem(
                            title = "SYSTEM",
                            isSelected = currentTab == AppTab.DASHBOARD,
                            accentColor = MemphisColors.RetroCyan,
                            onClick = { currentTab = AppTab.DASHBOARD },
                            modifier = Modifier.weight(1f)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun NavTabItem(
    title: String,
    isSelected: Boolean,
    accentColor: Color,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val bgColor = if (isSelected) accentColor else Color.White
    val shadowElev = if (isSelected) 3.dp else 0.dp

    Box(
        modifier = modifier
            .shadow(elevation = shadowElev, shape = RoundedCornerShape(12.dp), spotColor = Color.Black)
            .background(bgColor, shape = RoundedCornerShape(12.dp))
            .border(width = 2.dp, color = Color.Black, shape = RoundedCornerShape(12.dp))
            .clickable(onClick = onClick)
            .padding(vertical = 12.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.Black,
            fontSize = 13.sp,
            color = Color.Black
        )
    }
}
