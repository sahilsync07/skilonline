package com.skil.app.ui.components

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
            .shadow(elevation = 4.dp, shape = RoundedCornerShape(12.dp), spotColor = Color.Black)
            .background(Color.White, shape = RoundedCornerShape(12.dp))
            .border(width = 2.5.dp, color = MemphisColors.BorderBlack, shape = RoundedCornerShape(12.dp))
            .padding(10.dp)
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
                        text = product.badge.uppercase(),
                        fontWeight = FontWeight.Black,
                        fontSize = 9.sp,
                        color = Color.Black
                    )
                }
                Text(
                    text = product.category.uppercase(),
                    fontSize = 9.sp,
                    fontWeight = FontWeight.Bold,
                    color = MemphisColors.TextMuted
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Stylized Memphis Product Image Showcase Box (Rule 07 compliant)
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .background(MemphisColors.CanvasBackground, shape = RoundedCornerShape(8.dp))
                    .border(width = 2.dp, color = Color.Black, shape = RoundedCornerShape(8.dp)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = product.itemLabel.uppercase(),
                    fontWeight = FontWeight.Black,
                    fontSize = 16.sp,
                    color = Color.Black,
                    letterSpacing = 1.sp
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Product Name
            Text(
                text = product.name,
                fontWeight = FontWeight.Black,
                fontSize = 12.sp,
                color = Color.Black,
                maxLines = 2,
                lineHeight = 15.sp
            )

            Spacer(modifier = Modifier.height(4.dp))

            // Rating
            Text(
                text = "RATING: ${product.rating}",
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold,
                color = MemphisColors.RetroOrange
            )

            Spacer(modifier = Modifier.height(10.dp))

            // Price & Add to Cart Row (Web-Matched)
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Price Pill
                Box(
                    modifier = Modifier
                        .background(Color.White, shape = RoundedCornerShape(6.dp))
                        .border(width = 1.5.dp, color = Color.Black, shape = RoundedCornerShape(6.dp))
                        .padding(horizontal = 8.dp, vertical = 4.dp)
                ) {
                    Text(
                        text = "$${product.price.toInt()}",
                        fontWeight = FontWeight.Black,
                        fontSize = 12.sp,
                        color = Color.Black
                    )
                }

                // + ADD Button
                Box(
                    modifier = Modifier
                        .shadow(elevation = 2.dp, shape = RoundedCornerShape(6.dp), spotColor = Color.Black)
                        .background(MemphisColors.LimeYellow, shape = RoundedCornerShape(6.dp))
                        .border(width = 2.dp, color = Color.Black, shape = RoundedCornerShape(6.dp))
                        .clickable { onAddToCart(product) }
                        .padding(horizontal = 10.dp, vertical = 5.dp)
                ) {
                    Text(
                        text = "+ ADD",
                        fontWeight = FontWeight.Black,
                        fontSize = 11.sp,
                        color = Color.Black
                    )
                }
            }
        }
    }
}
