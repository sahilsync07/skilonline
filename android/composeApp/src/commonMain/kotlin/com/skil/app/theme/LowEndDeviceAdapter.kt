package com.skil.app.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf

/**
 * DevicePerformanceProfile - Configures adaptive performance settings for budget vs flagship devices.
 */
data class DevicePerformanceProfile(
    val isBudgetDevice: Boolean = false,
    val targetFps: Int = 60,
    val enableHeavyBlur: Boolean = false,
    val shadowElevationPx: Float = 4f
)

val LocalDevicePerformance = staticCompositionLocalOf {
    DevicePerformanceProfile(
        isBudgetDevice = true, // Default to lightweight mode for cheap phone compatibility
        targetFps = 60,
        enableHeavyBlur = false,
        shadowElevationPx = 4f
    )
}

/**
 * LowEndDeviceAdapter - Wraps composables in an adaptive performance context
 * ensuring cheap / budget Android phones (Android 5.0+, 2GB-3GB RAM) maintain
 * lightweight zero-jank frame rates.
 */
@Composable
fun LowEndDeviceAdapter(
    isBudgetDevice: Boolean = true,
    content: @Composable () -> Unit
) {
    val profile = if (isBudgetDevice) {
        DevicePerformanceProfile(
            isBudgetDevice = true,
            targetFps = 60,
            enableHeavyBlur = false,
            shadowElevationPx = 3f
        )
    } else {
        DevicePerformanceProfile(
            isBudgetDevice = false,
            targetFps = 120,
            enableHeavyBlur = true,
            shadowElevationPx = 5f
        )
    }

    CompositionLocalProvider(LocalDevicePerformance provides profile) {
        content()
    }
}
