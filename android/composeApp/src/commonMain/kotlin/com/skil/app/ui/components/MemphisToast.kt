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
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import com.skil.app.theme.MemphisColors
import kotlinx.coroutines.delay

/**
 * MemphisToast - Implements RULE 05: Theme-Based Toast & Notification Protocol
 * Strictly replaces native browser alerts with custom Memphis styled toasts featuring
 * auto-timeout and a manual close '×' button.
 */
@Composable
fun MemphisToast(
    message: String,
    isVisible: Boolean,
    onDismiss: () -> Unit,
    modifier: Modifier = Modifier,
    backgroundColor: Color = MemphisColors.LimeYellow,
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
                .padding(horizontal = 16.dp, vertical = 12.dp)
                .shadow(elevation = 8.dp, shape = RoundedCornerShape(12.dp), spotColor = Color.Black)
                .background(Color(0xFF0D0E12), shape = RoundedCornerShape(12.dp))
                .border(width = 1.5.dp, color = MemphisColors.LuxuryGold, shape = RoundedCornerShape(12.dp))
                .padding(14.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Gold Accent Pill
                Box(
                    modifier = Modifier
                        .size(width = 4.dp, height = 36.dp)
                        .background(MemphisColors.LuxuryGold, shape = RoundedCornerShape(2.dp))
                )

                androidx.compose.foundation.layout.Spacer(modifier = Modifier.width(10.dp))

                androidx.compose.foundation.layout.Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = "NOTIFICATION",
                        color = MemphisColors.LuxuryGold,
                        fontWeight = FontWeight.Black,
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

                androidx.compose.foundation.layout.Spacer(modifier = Modifier.width(10.dp))

                // Manual close '×' cross button
                Box(
                    modifier = Modifier
                        .size(26.dp)
                        .background(Color(0xFF22242B), shape = CircleShape)
                        .border(width = 1.dp, color = Color(0xFF3A3D48), shape = CircleShape)
                        .clickable { onDismiss() },
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "×",
                        color = Color.White,
                        fontWeight = FontWeight.Black,
                        fontSize = 15.sp
                    )
                }
            }
        }
    }
}
