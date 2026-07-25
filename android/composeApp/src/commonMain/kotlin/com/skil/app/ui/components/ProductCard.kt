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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.skil.app.domain.Product
import com.skil.app.theme.AppColors

@Composable
fun ProductCard(
    product: Product,
    onAddToCart: (Product) -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .shadow(elevation = 14.dp, shape = RoundedCornerShape(28.dp), spotColor = Color(0x14131518))
            .background(Color.White, shape = RoundedCornerShape(28.dp))
            .border(width = 1.dp, color = AppColors.BorderLight, shape = RoundedCornerShape(28.dp))
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
                        .background(AppColors.AccentGold.copy(alpha = 0.16f), shape = RoundedCornerShape(999.dp))
                        .padding(horizontal = 10.dp, vertical = 4.dp)
                ) {
                    Text(
                        text = product.badge.uppercase(),
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 9.sp,
                        color = AppColors.TextPrimary,
                        letterSpacing = 0.5.sp
                    )
                }
                Text(
                    text = product.category.uppercase(),
                    fontSize = 9.sp,
                    fontWeight = FontWeight.Bold,
                    color = AppColors.TextSecondary,
                    letterSpacing = 1.sp
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            // Elegant Product Image Showcase Box
            if (product.imageUrl != null) {
                io.kamel.image.KamelImage(
                    resource = io.kamel.image.asyncPainterResource(data = product.imageUrl),
                    contentDescription = product.name,
                    contentScale = androidx.compose.ui.layout.ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(140.dp)
                        .background(AppColors.SoftBackground, shape = RoundedCornerShape(16.dp))
                        .clip(RoundedCornerShape(16.dp))
                        .border(width = 1.dp, color = AppColors.BorderLight, shape = RoundedCornerShape(16.dp))
                )
            } else {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(140.dp)
                        .background(AppColors.SoftBackground, shape = RoundedCornerShape(16.dp))
                        .border(width = 1.dp, color = AppColors.BorderLight, shape = RoundedCornerShape(16.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = product.itemLabel.uppercase(),
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 18.sp,
                        color = AppColors.TextPrimary,
                        letterSpacing = 1.5.sp
                    )
                }
            }

            Spacer(modifier = Modifier.height(14.dp))

            // Product Name
            Text(
                text = product.name,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 13.sp,
                color = AppColors.TextPrimary,
                maxLines = 2,
                lineHeight = 16.sp
            )

            Spacer(modifier = Modifier.height(4.dp))

            // Rating
            Text(
                text = "RATING: ${product.rating}",
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold,
                color = AppColors.TextSecondary
            )

            Spacer(modifier = Modifier.height(14.dp))

            // Price & Add to Cart Row
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Price Label
                Text(
                    text = "$${product.price.toInt()}",
                    fontWeight = FontWeight.Black,
                    fontSize = 16.sp,
                    color = AppColors.TextPrimary
                )

                // Elegant Pill ADD Button
                Box(
                    modifier = Modifier
                        .shadow(elevation = 6.dp, shape = RoundedCornerShape(999.dp), spotColor = Color(0x1F111111))
                        .background(Color(0xFF111111), shape = RoundedCornerShape(999.dp))
                        .clickable { onAddToCart(product) }
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                ) {
                    Text(
                        text = "+ ADD",
                        fontWeight = FontWeight.Bold,
                        fontSize = 11.sp,
                        color = Color.White,
                        letterSpacing = 0.5.sp
                    )
                }
            }
        }
    }
}
