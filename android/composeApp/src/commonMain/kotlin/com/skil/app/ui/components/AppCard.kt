package com.skil.app.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.skil.app.theme.AppColors

@Composable
fun AppCard(
    modifier: Modifier = Modifier,
    backgroundColor: Color = Color.White,
    content: @Composable () -> Unit
) {
    Box(
        modifier = modifier
            .shadow(elevation = 12.dp, shape = RoundedCornerShape(24.dp), spotColor = Color(0x0C131518))
            .background(backgroundColor, shape = RoundedCornerShape(24.dp))
            .border(width = 1.dp, color = AppColors.BorderLight, shape = RoundedCornerShape(24.dp))
            .padding(20.dp)
    ) {
        content()
    }
}
