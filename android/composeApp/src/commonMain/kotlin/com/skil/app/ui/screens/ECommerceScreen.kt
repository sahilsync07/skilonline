package com.skil.app.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.skil.app.presentation.ECommerceViewModel
import com.skil.app.theme.MemphisColors
import com.skil.app.ui.components.MemphisToast
import com.skil.app.ui.components.ProductCard

@Composable
fun ECommerceScreen(
    viewModel: ECommerceViewModel,
    modifier: Modifier = Modifier
) {
    val uiState by viewModel.uiState.collectAsState()

    val categories = listOf("ALL", "APPAREL", "FOOTWEAR", "TECH", "ACCESSORIES")

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(MemphisColors.CanvasBackground)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            // Header Bar
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .shadow(elevation = 5.dp, shape = RoundedCornerShape(12.dp), spotColor = Color.Black)
                    .background(Color.White, shape = RoundedCornerShape(12.dp))
                    .border(width = 3.dp, color = MemphisColors.BorderBlack, shape = RoundedCornerShape(12.dp))
                    .padding(16.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text(
                            text = "SKIL LIFESTYLE",
                            fontWeight = FontWeight.Black,
                            fontSize = 20.sp,
                            color = Color.Black
                        )
                        Text(
                            text = "Super Fluid Memphis E-Commerce",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            color = MemphisColors.TextMuted
                        )
                    }

                    // Cart FAB Trigger
                    Box(
                        modifier = Modifier
                            .background(MemphisColors.RetroCyan, shape = RoundedCornerShape(8.dp))
                            .border(width = 2.dp, color = Color.Black, shape = RoundedCornerShape(8.dp))
                            .clickable { viewModel.toggleCartDrawer() }
                            .padding(horizontal = 14.dp, vertical = 8.dp)
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(text = "🛒 ", fontSize = 14.sp)
                            Text(
                                text = "${uiState.totalCartCount}",
                                fontWeight = FontWeight.Black,
                                fontSize = 13.sp,
                                color = Color.Black
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(14.dp))

            // Category Filter Pills
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                items(categories) { category ->
                    val isSelected = uiState.selectedCategory == category
                    val bgColor = if (isSelected) MemphisColors.LimeYellow else Color.White

                    Box(
                        modifier = Modifier
                            .shadow(elevation = 3.dp, shape = RoundedCornerShape(20.dp), spotColor = Color.Black)
                            .background(bgColor, shape = RoundedCornerShape(20.dp))
                            .border(width = 2.dp, color = Color.Black, shape = RoundedCornerShape(20.dp))
                            .clickable { viewModel.setCategory(category) }
                            .padding(horizontal = 16.dp, vertical = 8.dp)
                    ) {
                        Text(
                            text = category,
                            fontWeight = FontWeight.Black,
                            fontSize = 12.sp,
                            color = Color.Black
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(14.dp))

            // Product Grid (120Hz Deferred Scroll via graphicsLayer)
            val filteredProducts = uiState.products.filter {
                uiState.selectedCategory == "ALL" || it.category == uiState.selectedCategory
            }

            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier
                    .fillMaxSize()
                    .graphicsLayer { alpha = 1.0f }
            ) {
                items(
                    items = filteredProducts,
                    key = { item -> item.id }
                ) { product ->
                    ProductCard(
                        product = product,
                        onAddToCart = { viewModel.addToCart(it) }
                    )
                }
            }
        }

        // Rule 05 Toast Overlay
        MemphisToast(
            message = uiState.toastMessage,
            isVisible = uiState.isToastVisible,
            onDismiss = { viewModel.dismissToast() },
            modifier = Modifier.align(Alignment.TopCenter)
        )
    }
}
