package com.skil.app.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
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
        Column(modifier = Modifier.fillMaxSize()) {
            // 1. Top Announcement Bar (Web-Matched)
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Black)
                    .padding(vertical = 6.dp, horizontal = 12.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "SUMMER DROP '26 IS LIVE • USE CODE \"SKIL26\"",
                    color = MemphisColors.LimeYellow,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Black
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp, vertical = 12.dp)
            ) {
                // 2. Dual Navbar Header (Brand + Cart + Partners)
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .shadow(elevation = 4.dp, shape = RoundedCornerShape(12.dp), spotColor = Color.Black)
                        .background(Color.White, shape = RoundedCornerShape(12.dp))
                        .border(width = 3.dp, color = MemphisColors.BorderBlack, shape = RoundedCornerShape(12.dp))
                        .padding(12.dp)
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
                                fontSize = 18.sp,
                                color = Color.Black
                            )
                            Text(
                                text = "AJANTA • XPANIA PARTNERS",
                                fontSize = 9.sp,
                                fontWeight = FontWeight.Black,
                                color = MemphisColors.HotPink
                            )
                        }

                        // Memphis Cart Trigger Button
                        Box(
                            modifier = Modifier
                                .background(MemphisColors.RetroCyan, shape = RoundedCornerShape(8.dp))
                                .border(width = 2.dp, color = Color.Black, shape = RoundedCornerShape(8.dp))
                                .clickable { viewModel.toggleCartDrawer() }
                                .padding(horizontal = 12.dp, vertical = 6.dp)
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Text(
                                    text = "CART ",
                                    fontWeight = FontWeight.Black,
                                    fontSize = 11.sp,
                                    color = Color.Black
                                )
                                Box(
                                    modifier = Modifier
                                        .background(Color.Black, shape = CircleShape)
                                        .padding(horizontal = 6.dp, vertical = 2.dp)
                                ) {
                                    Text(
                                        text = "${uiState.totalCartCount}",
                                        fontWeight = FontWeight.Black,
                                        fontSize = 11.sp,
                                        color = Color.White
                                    )
                                }
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.height(10.dp))

                // 3. Search Bar
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.White, shape = RoundedCornerShape(10.dp))
                        .border(width = 2.dp, color = Color.Black, shape = RoundedCornerShape(10.dp))
                        .padding(horizontal = 12.dp, vertical = 8.dp)
                ) {
                    BasicTextField(
                        value = uiState.searchQuery,
                        onValueChange = { viewModel.setSearchQuery(it) },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth(),
                        decorationBox = { innerTextField ->
                            if (uiState.searchQuery.isEmpty()) {
                                Text(
                                    text = "Search products, kicks, tech...",
                                    color = MemphisColors.TextMuted,
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                            innerTextField()
                        }
                    )
                }

                Spacer(modifier = Modifier.height(10.dp))

                // 4. Category Filter Pills
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    items(categories) { category ->
                        val isSelected = uiState.selectedCategory == category
                        val bgColor = if (isSelected) MemphisColors.LimeYellow else Color.White

                        Box(
                            modifier = Modifier
                                .shadow(elevation = 2.dp, shape = RoundedCornerShape(16.dp), spotColor = Color.Black)
                                .background(bgColor, shape = RoundedCornerShape(16.dp))
                                .border(width = 2.dp, color = Color.Black, shape = RoundedCornerShape(16.dp))
                                .clickable { viewModel.setCategory(category) }
                                .padding(horizontal = 14.dp, vertical = 6.dp)
                        ) {
                            Text(
                                text = category,
                                fontWeight = FontWeight.Black,
                                fontSize = 11.sp,
                                color = Color.Black
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(12.dp))

                // 5. Hero Banner Showcase
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .shadow(elevation = 4.dp, shape = RoundedCornerShape(12.dp), spotColor = Color.Black)
                        .background(MemphisColors.LimeYellow, shape = RoundedCornerShape(12.dp))
                        .border(width = 3.dp, color = Color.Black, shape = RoundedCornerShape(12.dp))
                        .padding(14.dp)
                ) {
                    Column {
                        Box(
                            modifier = Modifier
                                .background(MemphisColors.HotPink, shape = RoundedCornerShape(4.dp))
                                .border(width = 1.dp, color = Color.Black, shape = RoundedCornerShape(4.dp))
                                .padding(horizontal = 6.dp, vertical = 2.dp)
                        ) {
                            Text(
                                text = "EXCLUSIVE DROP",
                                color = Color.White,
                                fontWeight = FontWeight.Black,
                                fontSize = 9.sp
                            )
                        }

                        Spacer(modifier = Modifier.height(6.dp))

                        Text(
                            text = "SUPER FLUID STREETWEAR & TECH GEAR",
                            fontWeight = FontWeight.Black,
                            fontSize = 14.sp,
                            color = Color.Black
                        )
                    }
                }

                Spacer(modifier = Modifier.height(12.dp))

                // 6. Featured Products Section & Grid
                Text(
                    text = "FEATURED DROPS",
                    fontWeight = FontWeight.Black,
                    fontSize = 13.sp,
                    color = Color.Black
                )

                Spacer(modifier = Modifier.height(8.dp))

                val filteredProducts = uiState.products.filter { product ->
                    (uiState.selectedCategory == "ALL" || product.category == uiState.selectedCategory) &&
                            (uiState.searchQuery.isEmpty() || product.name.contains(uiState.searchQuery, ignoreCase = true))
                }

                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp),
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
        }

        // 7. Cart Drawer Slide-Over Sheet
        if (uiState.isCartDrawerOpen) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = 0.5f))
                    .clickable { viewModel.toggleCartDrawer() }
            ) {
                Box(
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .fillMaxWidth()
                        .fillMaxHeight(0.6f)
                        .background(Color.White, shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp))
                        .border(width = 3.dp, color = Color.Black, shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp))
                        .clickable(enabled = false) {}
                        .padding(16.dp)
                ) {
                    Column(modifier = Modifier.fillMaxSize()) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "YOUR SHOPPING CART",
                                fontWeight = FontWeight.Black,
                                fontSize = 16.sp,
                                color = Color.Black
                            )

                            Box(
                                modifier = Modifier
                                    .size(28.dp)
                                    .background(MemphisColors.HotPink, shape = CircleShape)
                                    .border(width = 2.dp, color = Color.Black, shape = CircleShape)
                                    .clickable { viewModel.toggleCartDrawer() },
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = "X",
                                    fontWeight = FontWeight.Black,
                                    color = Color.White,
                                    fontSize = 12.sp
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(12.dp))

                        if (uiState.cartItems.isEmpty()) {
                            Box(
                                modifier = Modifier.weight(1f).fillMaxWidth(),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = "Your cart is empty!",
                                    fontWeight = FontWeight.Bold,
                                    color = MemphisColors.TextMuted,
                                    fontSize = 14.sp
                                )
                            }
                        } else {
                            LazyColumn(
                                modifier = Modifier.weight(1f).fillMaxWidth(),
                                verticalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                items(uiState.cartItems) { item ->
                                    Box(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .background(MemphisColors.CanvasBackground, shape = RoundedCornerShape(8.dp))
                                            .border(width = 2.dp, color = Color.Black, shape = RoundedCornerShape(8.dp))
                                            .padding(10.dp)
                                    ) {
                                        Row(
                                            modifier = Modifier.fillMaxWidth(),
                                            horizontalArrangement = Arrangement.SpaceBetween,
                                            verticalAlignment = Alignment.CenterVertically
                                        ) {
                                            Column(modifier = Modifier.weight(1f)) {
                                                Text(
                                                    text = item.product.name,
                                                    fontWeight = FontWeight.Black,
                                                    fontSize = 12.sp,
                                                    color = Color.Black
                                                )
                                                Text(
                                                    text = "$${item.product.price} each",
                                                    fontSize = 11.sp,
                                                    fontWeight = FontWeight.Bold,
                                                    color = MemphisColors.TextMuted
                                                )
                                            }

                                            Row(verticalAlignment = Alignment.CenterVertically) {
                                                Box(
                                                    modifier = Modifier
                                                        .size(24.dp)
                                                        .background(MemphisColors.LimeYellow, shape = RoundedCornerShape(4.dp))
                                                        .border(width = 1.dp, color = Color.Black, shape = RoundedCornerShape(4.dp))
                                                        .clickable { viewModel.updateQuantity(item.product.id, -1) },
                                                    contentAlignment = Alignment.Center
                                                ) {
                                                    Text("-", fontWeight = FontWeight.Black, color = Color.Black)
                                                }

                                                Text(
                                                    text = "${item.quantity}",
                                                    fontWeight = FontWeight.Black,
                                                    fontSize = 13.sp,
                                                    modifier = Modifier.padding(horizontal = 8.dp)
                                                )

                                                Box(
                                                    modifier = Modifier
                                                        .size(24.dp)
                                                        .background(MemphisColors.LimeYellow, shape = RoundedCornerShape(4.dp))
                                                        .border(width = 1.dp, color = Color.Black, shape = RoundedCornerShape(4.dp))
                                                        .clickable { viewModel.updateQuantity(item.product.id, 1) },
                                                    contentAlignment = Alignment.Center
                                                ) {
                                                    Text("+", fontWeight = FontWeight.Black, color = Color.Black)
                                                }
                                            }
                                        }
                                    }
                                }
                            }

                            Spacer(modifier = Modifier.height(8.dp))

                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(
                                    text = "SUBTOTAL:",
                                    fontWeight = FontWeight.Black,
                                    fontSize = 14.sp
                                )
                                Text(
                                    text = "$${uiState.totalCartAmount}",
                                    fontWeight = FontWeight.Black,
                                    fontSize = 14.sp,
                                    color = MemphisColors.HotPink
                                )
                            }

                            Spacer(modifier = Modifier.height(10.dp))

                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .background(MemphisColors.LimeYellow, shape = RoundedCornerShape(10.dp))
                                    .border(width = 2.dp, color = Color.Black, shape = RoundedCornerShape(10.dp))
                                    .clickable { viewModel.checkout() }
                                    .padding(12.dp),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = "Proceed To Checkout →",
                                    fontWeight = FontWeight.Black,
                                    fontSize = 14.sp,
                                    color = Color.Black
                                )
                            }
                        }
                    }
                }
            }
        }

        // Rule 05 Memphis Toast Overlay
        MemphisToast(
            message = uiState.toastMessage,
            isVisible = uiState.isToastVisible,
            onDismiss = { viewModel.dismissToast() },
            modifier = Modifier.align(Alignment.TopCenter)
        )
    }
}

