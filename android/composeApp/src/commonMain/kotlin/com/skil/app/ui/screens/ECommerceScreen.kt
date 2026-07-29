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
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.MarqueeSpacing
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
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
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.skil.app.presentation.ECommerceViewModel
import com.skil.app.theme.AppColors
import com.skil.app.ui.components.CartIcon
import com.skil.app.ui.components.AppToast
import com.skil.app.ui.components.ProductCard
import com.skil.app.ui.components.SearchIcon

import org.jetbrains.compose.resources.painterResource
import skilonline.composeapp.generated.resources.Res
import skilonline.composeapp.generated.resources.ajanta_logo
import skilonline.composeapp.generated.resources.skil_logo
import skilonline.composeapp.generated.resources.impakto_logo

@Composable
fun ECommerceScreen(
    viewModel: ECommerceViewModel,
    modifier: Modifier = Modifier
) {
    val uiState by viewModel.uiState.collectAsState()
    val categories = listOf("ALL DROPS", "FOOTWEAR")

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(AppColors.SurfaceBackground),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            // 1. Top Announcement Bar (Full Width)
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        brush = androidx.compose.ui.graphics.Brush.linearGradient(
                            colors = listOf(AppColors.AccentGold, Color(0xFFD4A762)),
                            start = androidx.compose.ui.geometry.Offset(0f, 0f),
                            end = androidx.compose.ui.geometry.Offset(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY)
                        )
                    )
                    .padding(vertical = 6.dp, horizontal = 16.dp),
                contentAlignment = Alignment.Center
            ) {
                @OptIn(androidx.compose.foundation.ExperimentalFoundationApi::class)
                Text(
                    text = "AJANTA COMING TO ANDHRA PRADESH SOON   •   AJANTA COMING TO ANDHRA PRADESH SOON   •   AJANTA COMING TO ANDHRA PRADESH SOON",
                    color = Color.White,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.SemiBold,
                    letterSpacing = 3.sp,
                    maxLines = 1,
                    modifier = Modifier
                )
            }

            // 2. Dual Navbar 1: Top Brand & Partner Logo Header (Full Width Flat, No Dock)
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .drawBehind {
                        drawLine(
                            color = AppColors.BorderLight,
                            start = androidx.compose.ui.geometry.Offset(0f, size.height),
                            end = androidx.compose.ui.geometry.Offset(size.width, size.height),
                            strokeWidth = 1.dp.toPx()
                        )
                    }
                    .padding(horizontal = 32.dp, vertical = 12.dp)
            ) {
                @OptIn(androidx.compose.foundation.layout.ExperimentalLayoutApi::class)
                androidx.compose.foundation.layout.FlowRow(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalArrangement = Arrangement.spacedBy(12.dp, Alignment.CenterVertically)
                ) {
                    // Left Main Brand Logo
                    androidx.compose.foundation.Image(
                        painter = painterResource(Res.drawable.skil_logo),
                        contentDescription = "SKIL Logo",
                        modifier = Modifier.height(72.dp),
                        contentScale = androidx.compose.ui.layout.ContentScale.Fit
                    )

                    // Right Partner Logos Container Badge
                    Box(
                        modifier = Modifier
                            .background(AppColors.SurfaceBackground, shape = RoundedCornerShape(14.dp))
                            .border(width = 1.dp, color = AppColors.BorderLight, shape = RoundedCornerShape(14.dp))
                            .padding(horizontal = 22.dp, vertical = 10.dp)
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            androidx.compose.foundation.Image(
                                painter = painterResource(Res.drawable.ajanta_logo),
                                contentDescription = "Ajanta Logo",
                                modifier = Modifier.height(52.dp),
                                contentScale = androidx.compose.ui.layout.ContentScale.Fit
                            )
                            Spacer(modifier = Modifier.width(20.dp))
                            Box(
                                modifier = Modifier
                                    .width(1.5.dp)
                                    .height(34.dp)
                                    .background(AppColors.BorderLight)
                            )
                            Spacer(modifier = Modifier.width(20.dp))
                            androidx.compose.foundation.Image(
                                painter = painterResource(Res.drawable.impakto_logo),
                                contentDescription = "Impakto Logo",
                                modifier = Modifier.height(52.dp),
                                contentScale = androidx.compose.ui.layout.ContentScale.Fit
                            )
                        }
                    }
                }
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                contentAlignment = Alignment.TopCenter
            ) {
                androidx.compose.foundation.layout.BoxWithConstraints(
                    modifier = Modifier
                        .fillMaxHeight()
                        .fillMaxWidth()
                ) {
                    val isWide = maxWidth > 600.dp
                    val columns = when {
                        maxWidth > 1600.dp -> 5
                        maxWidth > 1200.dp -> 4
                        maxWidth > 800.dp -> 3
                        else -> 2
                    }
                    val horizontalPad = when {
                        maxWidth > 1200.dp -> 48.dp
                        maxWidth > 800.dp -> 32.dp
                        else -> 16.dp
                    }

                    LazyVerticalGrid(
                        columns = GridCells.Fixed(columns),
                        horizontalArrangement = Arrangement.spacedBy(24.dp),
                        verticalArrangement = Arrangement.spacedBy(36.dp),
                        contentPadding = androidx.compose.foundation.layout.PaddingValues(horizontal = horizontalPad, vertical = 32.dp),
                        modifier = Modifier.fillMaxSize()
                    ) {
                        item(span = { androidx.compose.foundation.lazy.grid.GridItemSpan(maxLineSpan) }) {
                            Column(modifier = Modifier.fillMaxWidth()) {

                // 3. Navbar 2: Controls Row
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(14.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Search Bar Box
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .height(48.dp)
                            .background(Color.White, shape = RoundedCornerShape(24.dp))
                            .border(width = 1.dp, color = AppColors.BorderLight, shape = RoundedCornerShape(24.dp))
                            .padding(horizontal = 16.dp),
                        contentAlignment = Alignment.CenterStart
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            SearchIcon(size = 18.dp, tint = AppColors.TextMuted)
                            Spacer(modifier = Modifier.width(12.dp))
                            BasicTextField(
                                value = uiState.searchQuery,
                                onValueChange = { viewModel.setSearchQuery(it) },
                                singleLine = true,
                                modifier = Modifier.fillMaxWidth(),
                                decorationBox = { innerTextField ->
                                    if (uiState.searchQuery.isEmpty()) {
                                        Text(
                                            text = "Search...",
                                            color = AppColors.TextMuted,
                                            fontSize = 13.sp,
                                            fontWeight = FontWeight.Normal
                                        )
                                    }
                                    innerTextField()
                                }
                            )
                        }
                    }

                    // Ergonomic Luxury Pill Cart Button
                    Box(
                        modifier = Modifier
                            .height(48.dp)
                            .shadow(elevation = 6.dp, shape = RoundedCornerShape(999.dp), spotColor = Color(0x0C131518))
                            .background(Color.White, shape = RoundedCornerShape(999.dp))
                            .border(width = 1.dp, color = AppColors.BorderLight, shape = RoundedCornerShape(999.dp))
                            .clickable { viewModel.toggleCartDrawer() }
                            .padding(horizontal = 20.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            CartIcon(size = 20.dp, tint = AppColors.TextPrimary)
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = "CART",
                                fontWeight = FontWeight.Bold,
                                fontSize = 12.sp,
                                color = AppColors.TextPrimary,
                                letterSpacing = 1.sp
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Box(
                                modifier = Modifier
                                    .background(AppColors.AccentGold, shape = CircleShape)
                                    .padding(horizontal = 8.dp, vertical = 2.dp),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = "${uiState.totalCartCount}",
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 11.sp,
                                    color = Color.White
                                )
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                // 4. Category Filter Pills Row
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    items(categories) { category ->
                        val normalizedCategory = if (category == "ALL DROPS") "ALL" else category
                        val isSelected = (uiState.selectedCategory == "ALL" && category == "ALL DROPS") ||
                                (uiState.selectedCategory == category)
                                
                        val bgColor = if (isSelected) AppColors.TextPrimary else Color.White
                        val textColor = if (isSelected) Color.White else AppColors.TextSecondary
                        val borderColor = if (isSelected) AppColors.TextPrimary else AppColors.BorderLight
                        val elevation = if (isSelected) 8.dp else 4.dp

                        Box(
                            modifier = Modifier
                                .shadow(elevation = elevation, shape = RoundedCornerShape(999.dp), spotColor = Color(0x0C131518))
                                .background(bgColor, shape = RoundedCornerShape(999.dp))
                                .border(width = 1.dp, color = borderColor, shape = RoundedCornerShape(999.dp))
                                .clickable { viewModel.setCategory(normalizedCategory) }
                                .padding(horizontal = 20.dp, vertical = 10.dp)
                        ) {
                            Text(
                                text = category,
                                fontWeight = FontWeight.Bold,
                                fontSize = 12.sp,
                                color = textColor,
                                letterSpacing = 1.sp
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                // 5. Hero Showcase Section (Responsive Elegant Light)
                androidx.compose.foundation.layout.BoxWithConstraints(
                    modifier = Modifier
                        .fillMaxWidth()
                        .shadow(elevation = 8.dp, shape = RoundedCornerShape(24.dp), spotColor = Color(0x08131518))
                        .background(AppColors.SurfaceBackground, shape = RoundedCornerShape(24.dp))
                        .drawBehind {
                            drawRect(
                                brush = androidx.compose.ui.graphics.Brush.radialGradient(
                                    colors = listOf(Color(0x14C19652), Color.Transparent),
                                    center = androidx.compose.ui.geometry.Offset(0f, 0f),
                                    radius = size.width * 0.4f
                                )
                            )
                            drawRect(
                                brush = androidx.compose.ui.graphics.Brush.radialGradient(
                                    colors = listOf(Color(0x0A1F1F1F), Color.Transparent),
                                    center = androidx.compose.ui.geometry.Offset(size.width, size.height),
                                    radius = size.width * 0.35f
                                )
                            )
                        }
                        .border(width = 1.dp, color = AppColors.BorderLight, shape = RoundedCornerShape(24.dp))
                ) {
                    val isWide = maxWidth > 600.dp
                    
                    Row(
                        modifier = Modifier.fillMaxWidth().padding(if (isWide) 48.dp else 24.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column(modifier = if (isWide) Modifier.weight(0.6f) else Modifier.fillMaxWidth()) {
                            // Tag Pill
                            Box(
                                modifier = Modifier
                                    .background(AppColors.SurfaceBackground, shape = RoundedCornerShape(999.dp))
                                    .border(width = 1.dp, color = AppColors.AccentGold.copy(alpha=0.3f), shape = RoundedCornerShape(999.dp))
                                    .padding(horizontal = 14.dp, vertical = 6.dp)
                            ) {
                                Text(
                                    text = "PREMIUM DESIGN, MODERN DROP",
                                    color = AppColors.AccentGold,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 10.sp,
                                    letterSpacing = 1.sp
                                )
                            }

                            Spacer(modifier = Modifier.height(16.dp))

                            // Title
                            Text(
                                text = "Light, elevated retail\nfor discerning style.",
                                fontWeight = FontWeight.ExtraBold,
                                fontSize = if (isWide) 32.sp else 26.sp,
                                color = AppColors.TextPrimary,
                                lineHeight = if (isWide) 36.sp else 30.sp
                            )

                            Spacer(modifier = Modifier.height(16.dp))

                            // Description Paragraph
                            Text(
                                text = "Experience a refined daily shopping destination inspired by SKIL’s signature branding, clean lines, and premium gold accents.",
                                fontSize = 14.sp,
                                color = AppColors.TextSecondary,
                                lineHeight = 22.sp
                            )

                            Spacer(modifier = Modifier.height(24.dp))

                            // Shop Collection Button (Elegant Pill)
                            Box(
                                modifier = Modifier
                                    .shadow(elevation = 4.dp, shape = RoundedCornerShape(999.dp), spotColor = Color(0x08131518))
                                    .background(AppColors.TextPrimary, shape = RoundedCornerShape(999.dp))
                                    .clickable { viewModel.showToast("Browsing the new SKIL collection") }
                                    .padding(horizontal = 28.dp, vertical = 14.dp)
                            ) {
                                Text(
                                    text = "Explore Collection",
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 13.sp,
                                    color = Color.White
                                )
                            }
                        }
                        
                        if (isWide) {
                            // Elegant Watermark/Logo on the right side for desktop displays
                            Box(
                                modifier = Modifier.weight(0.4f), 
                                contentAlignment = Alignment.CenterEnd
                            ) {
                                androidx.compose.foundation.Image(
                                    painter = painterResource(Res.drawable.skil_logo),
                                    contentDescription = "Hero Graphic",
                                    modifier = Modifier.fillMaxWidth(0.8f).height(120.dp),
                                    alpha = 0.04f,
                                    contentScale = androidx.compose.ui.layout.ContentScale.Fit
                                )
                            }
                        }
                    }
                }

                                Spacer(modifier = Modifier.height(32.dp))

                                // 6. Featured Products Section Title & Grid
                                Text(
                                    text = "CURATED ESSENTIALS FOR MODERN LIVING.",
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 13.sp,
                                    color = AppColors.TextSecondary,
                                    letterSpacing = 1.sp
                                )

                                Spacer(modifier = Modifier.height(16.dp))
                            }
                        }

                        items(
                            items = uiState.products.filter { product ->
                                (uiState.selectedCategory == "ALL" || product.category == uiState.selectedCategory) &&
                                        (uiState.searchQuery.isEmpty() || product.name.contains(uiState.searchQuery, ignoreCase = true))
                            },
                            key = { item -> item.id }
                        ) { product ->
                            ProductCard(
                                product = product,
                                onAddToCart = { viewModel.addToCart(it) }
                            )
                        }

                        item(span = { androidx.compose.foundation.lazy.grid.GridItemSpan(maxLineSpan) }) {
                            com.skil.app.ui.components.PremiumFooter()
                        }
                    }
                }
            }
        } // Closing brace for the outer full-width Column

        // 7. Cart Drawer Slide-Over Sheet
        if (uiState.isCartDrawerOpen) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = 0.3f))
                    .clickable { viewModel.toggleCartDrawer() }
            ) {
                Box(
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .fillMaxHeight()
                        .fillMaxWidth(0.4f)
                        .background(Color.White)
                        .shadow(elevation = 24.dp)
                        .clickable(enabled = false) {}
                        .padding(32.dp)
                ) {
                    Column(modifier = Modifier.fillMaxSize()) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "YOUR SHOPPING CART",
                                fontWeight = FontWeight.ExtraBold,
                                fontSize = 20.sp,
                                color = AppColors.TextPrimary
                            )

                            Box(
                                modifier = Modifier
                                    .size(36.dp)
                                    .background(AppColors.SurfaceBackground, shape = CircleShape)
                                    .clickable { viewModel.toggleCartDrawer() },
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = "✕",
                                    fontWeight = FontWeight.Normal,
                                    color = AppColors.TextSecondary,
                                    fontSize = 18.sp
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(24.dp))

                        if (uiState.cartItems.isEmpty()) {
                            Box(
                                modifier = Modifier.weight(1f).fillMaxWidth(),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = "Your cart is empty!",
                                    fontWeight = FontWeight.Bold,
                                    color = AppColors.TextMuted,
                                    fontSize = 16.sp
                                )
                            }
                        } else {
                            LazyColumn(
                                modifier = Modifier.weight(1f).fillMaxWidth(),
                                verticalArrangement = Arrangement.spacedBy(16.dp)
                            ) {
                                items(uiState.cartItems) { item ->
                                    Box(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .background(AppColors.SoftBackground, shape = RoundedCornerShape(16.dp))
                                            .border(width = 1.dp, color = AppColors.BorderLight, shape = RoundedCornerShape(16.dp))
                                            .padding(16.dp)
                                    ) {
                                        Row(
                                            modifier = Modifier.fillMaxWidth(),
                                            horizontalArrangement = Arrangement.SpaceBetween,
                                            verticalAlignment = Alignment.CenterVertically
                                        ) {
                                            Column(modifier = Modifier.weight(1f)) {
                                                Text(
                                                    text = item.product.name,
                                                    fontWeight = FontWeight.Bold,
                                                    fontSize = 14.sp,
                                                    color = AppColors.TextPrimary
                                                )
                                                Spacer(modifier = Modifier.height(4.dp))
                                                Text(
                                                    text = "₹${item.product.price.toInt()} each",
                                                    fontSize = 13.sp,
                                                    fontWeight = FontWeight.Bold,
                                                    color = AppColors.TextSecondary
                                                )
                                            }

                                            Row(verticalAlignment = Alignment.CenterVertically) {
                                                Box(
                                                    modifier = Modifier
                                                        .size(32.dp)
                                                        .background(Color.White, shape = RoundedCornerShape(8.dp))
                                                        .border(width = 1.dp, color = AppColors.BorderLight, shape = RoundedCornerShape(8.dp))
                                                        .clickable { viewModel.updateQuantity(item.product.id, -1) },
                                                    contentAlignment = Alignment.Center
                                                ) {
                                                    Text("-", fontWeight = FontWeight.Bold, color = AppColors.TextPrimary)
                                                }

                                                Text(
                                                    text = "${item.quantity}",
                                                    fontWeight = FontWeight.ExtraBold,
                                                    fontSize = 15.sp,
                                                    modifier = Modifier.padding(horizontal = 12.dp)
                                                )

                                                Box(
                                                    modifier = Modifier
                                                        .size(32.dp)
                                                        .background(Color.White, shape = RoundedCornerShape(8.dp))
                                                        .border(width = 1.dp, color = AppColors.BorderLight, shape = RoundedCornerShape(8.dp))
                                                        .clickable { viewModel.updateQuantity(item.product.id, 1) },
                                                    contentAlignment = Alignment.Center
                                                ) {
                                                    Text("+", fontWeight = FontWeight.Bold, color = AppColors.TextPrimary)
                                                }
                                            }
                                        }
                                    }
                                }
                            }

                            Spacer(modifier = Modifier.height(24.dp))

                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(
                                    text = "SUBTOTAL:",
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 16.sp,
                                    color = AppColors.TextSecondary
                                )
                                Text(
                                    text = "₹${uiState.totalCartAmount.toInt()}",
                                    fontWeight = FontWeight.ExtraBold,
                                    fontSize = 24.sp,
                                    color = AppColors.TextPrimary
                                )
                            }

                            Spacer(modifier = Modifier.height(24.dp))

                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .shadow(elevation = 8.dp, shape = RoundedCornerShape(999.dp), spotColor = Color(0x1F111111))
                                    .background(AppColors.TextPrimary, shape = RoundedCornerShape(999.dp))
                                    .clickable { viewModel.checkout() }
                                    .padding(18.dp),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = "Proceed To Checkout →",
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 15.sp,
                                    color = Color.White
                                )
                            }
                        }
                    }
                }
            }
        }

        // App Toast Overlay
        AppToast(
            message = uiState.toastMessage,
            isVisible = uiState.isToastVisible,
            onDismiss = { viewModel.dismissToast() },
            modifier = Modifier.align(Alignment.TopCenter)
        )
    }
}
