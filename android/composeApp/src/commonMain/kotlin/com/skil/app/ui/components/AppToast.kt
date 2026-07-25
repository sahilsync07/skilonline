package com.skil.app.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.skil.app.theme.AppColors
import kotlinx.coroutines.delay

/**
 * AppToast - Implements Theme-Based Toast & Notification Protocol
 * Strictly replaces native browser alerts with elegant App styled toasts featuring
 * auto-timeout and a manual close '×' button.
 */
@Composable
fun AppToast(
    message: String,
    isVisible: Boolean,
    onDismiss: () -> Unit,
    modifier: Modifier = Modifier,
    durationMs: Long = 4000L
) {
    LaunchedEffect(isVisible, message) {
        if (isVisible) {
            delay(durationMs)
            onDismiss()
        }
    }

    AnimatedVisibility(
        visible = isVisible,
        enter = slideInVertically(initialOffsetY = { -it }) + fadeIn(),
        exit = slideOutVertically(targetOffsetY = { -it }) + fadeOut(),
        modifier = modifier
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp, vertical = 24.dp)
                .shadow(elevation = 16.dp, shape = RoundedCornerShape(999.dp), spotColor = Color(0x1F111111))
                .background(Color(0xFF0D0E12).copy(alpha = 0.95f), shape = RoundedCornerShape(999.dp))
                .border(width = 1.dp, color = AppColors.AccentGold.copy(alpha = 0.5f), shape = RoundedCornerShape(999.dp))
                .padding(horizontal = 16.dp, vertical = 10.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Gold Accent Pill
                Box(
                    modifier = Modifier
                        .size(38.dp)
                        .background(AppColors.AccentGold.copy(alpha = 0.15f), shape = CircleShape)
                        .border(width = 1.dp, color = AppColors.AccentGold.copy(alpha = 0.4f), shape = CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "!",
                        color = AppColors.AccentGold,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
                }

                Spacer(modifier = Modifier.width(14.dp))

                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = "NOTIFICATION",
                        color = AppColors.AccentGold,
                        fontWeight = FontWeight.Bold,
                        fontSize = 9.sp,
                        letterSpacing = 1.sp
                    )
                    Text(
                        text = message,
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 13.sp
                    )
                }

                Spacer(modifier = Modifier.width(14.dp))

                // Manual close '×' cross button
                Box(
                    modifier = Modifier
                        .size(32.dp)
                        .background(Color.White.copy(alpha = 0.1f), shape = CircleShape)
                        .border(width = 1.dp, color = Color.White.copy(alpha = 0.15f), shape = CircleShape)
                        .clickable { onDismiss() },
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "×",
                        color = Color.White.copy(alpha = 0.8f),
                        fontWeight = FontWeight.Normal,
                        fontSize = 18.sp
                    )
                }
            }
        }
    }
}
