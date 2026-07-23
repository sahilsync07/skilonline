package com.skil.app.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun SearchIcon(
    modifier: Modifier = Modifier,
    tint: Color = Color.Black,
    size: Dp = 18.dp
) {
    Canvas(modifier = modifier.size(size)) {
        val strokeWidth = 2.5.dp.toPx()
        val radius = size.toPx() * 0.33f
        val centerX = size.toPx() * 0.42f
        val centerY = size.toPx() * 0.42f

        // Draw Search Lens Circle
        drawCircle(
            color = tint,
            radius = radius,
            center = androidx.compose.ui.geometry.Offset(centerX, centerY),
            style = Stroke(width = strokeWidth)
        )

        // Draw Search Handle Line
        drawLine(
            color = tint,
            start = androidx.compose.ui.geometry.Offset(centerX + radius * 0.7f, centerY + radius * 0.7f),
            end = androidx.compose.ui.geometry.Offset(size.toPx() * 0.88f, size.toPx() * 0.88f),
            strokeWidth = strokeWidth
        )
    }
}

@Composable
fun CartIcon(
    modifier: Modifier = Modifier,
    tint: Color = Color.Black,
    size: Dp = 20.dp
) {
    Canvas(modifier = modifier.size(size)) {
        val strokeWidth = 2.2.dp.toPx()
        val path = Path().apply {
            moveTo(size.toPx() * 0.05f, size.toPx() * 0.15f)
            lineTo(size.toPx() * 0.25f, size.toPx() * 0.15f)
            lineTo(size.toPx() * 0.38f, size.toPx() * 0.65f)
            lineTo(size.toPx() * 0.85f, size.toPx() * 0.65f)
            lineTo(size.toPx() * 0.95f, size.toPx() * 0.30f)
            lineTo(size.toPx() * 0.30f, size.toPx() * 0.30f)
        }

        // Draw Cart Basket
        drawPath(
            path = path,
            color = tint,
            style = Stroke(width = strokeWidth)
        )

        // Draw Cart Wheels
        val wheelRadius = size.toPx() * 0.08f
        drawCircle(
            color = tint,
            radius = wheelRadius,
            center = androidx.compose.ui.geometry.Offset(size.toPx() * 0.42f, size.toPx() * 0.82f)
        )
        drawCircle(
            color = tint,
            radius = wheelRadius,
            center = androidx.compose.ui.geometry.Offset(size.toPx() * 0.80f, size.toPx() * 0.82f)
        )
    }
}
