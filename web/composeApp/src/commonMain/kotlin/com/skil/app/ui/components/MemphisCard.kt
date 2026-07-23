package com.skil.app.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.skil.app.theme.MemphisColors

/**
 * MemphisCard - Light Mode Neo-Brutalist Container Card
 * Styled with 3dp black borders, hard offset shadow, and neon accent backgrounds.
 */
@Composable
fun MemphisCard(
    title: String,
    modifier: Modifier = Modifier,
    accentColor: Color = MemphisColors.LimeYellow,
    content: @Composable () -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .shadow(elevation = 5.dp, shape = RoundedCornerShape(12.dp), spotColor = Color.Black)
            .background(accentColor, shape = RoundedCornerShape(12.dp))
            .border(width = 3.dp, color = MemphisColors.BorderBlack, shape = RoundedCornerShape(12.dp))
            .padding(18.dp)
    ) {
        Column {
            Text(
                text = title.uppercase(),
                fontWeight = FontWeight.Black,
                fontSize = 14.sp,
                color = Color.Black,
                modifier = Modifier.padding(bottom = 10.dp)
            )
            content()
        }
    }
}
