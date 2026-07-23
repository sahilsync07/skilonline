package com.skil.app.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.skil.app.domain.Product
import com.skil.app.theme.MemphisColors

@Composable
fun ProductCard(
    product: Product,
    onAddToCart: (Product) -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .shadow(elevation = 5.dp, shape = RoundedCornerShape(14.dp), spotColor = Color.Black)
            .background(Color.White, shape = RoundedCornerShape(14.dp))
            .border(width = 3.dp, color = MemphisColors.BorderBlack, shape = RoundedCornerShape(14.dp))
            .padding(14.dp)
    ) {
        Column {
            // Category & Badge Header
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .background(MemphisColors.LimeYellow, shape = RoundedCornerShape(4.dp))
                        .border(width = 1.5.dp, color = Color.Black, shape = RoundedCornerShape(4.dp))
                        .padding(horizontal = 6.dp, vertical = 2.dp)
                ) {
                    Text(
                        text = product.badge,
                        fontWeight = FontWeight.Black,
                        fontSize = 10.sp,
                        color = Color.Black
                    )
                }
                Text(
                    text = product.category,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Bold,
                    color = MemphisColors.TextMuted
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            // Typography Badge Box (Rule 07 compliant, zero emojis)
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
                    .background(MemphisColors.CanvasBackground, shape = RoundedCornerShape(8.dp))
                    .border(width = 2.dp, color = Color.Black, shape = RoundedCornerShape(8.dp)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = product.itemLabel.uppercase(),
                    fontWeight = FontWeight.Black,
                    fontSize = 18.sp,
                    color = Color.Black,
                    letterSpacing = 1.sp
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = product.name,
                fontWeight = FontWeight.Black,
                fontSize = 14.sp,
                color = Color.Black
            )

            Text(
                text = "RATING: ${product.rating}",
                fontSize = 11.sp,
                color = MemphisColors.RetroOrange,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(10.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .background(Color(0xFFF7FFB8), shape = RoundedCornerShape(6.dp))
                        .border(width = 1.5.dp, color = Color.Black, shape = RoundedCornerShape(6.dp))
                        .padding(horizontal = 8.dp, vertical = 4.dp)
                ) {
                    Text(
                        text = "$${product.price.toInt()}",
                        fontWeight = FontWeight.Black,
                        fontSize = 15.sp,
                        color = Color.Black
                    )
                }

                MemphisButton(
                    text = "+ Add",
                    onClick = { onAddToCart(product) },
                    backgroundColor = MemphisColors.LimeYellow
                )
            }
        }
    }
}
