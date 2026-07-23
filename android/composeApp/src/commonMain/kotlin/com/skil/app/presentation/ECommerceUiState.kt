package com.skil.app.presentation

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import com.skil.app.domain.CartItem
import com.skil.app.domain.Product

@Stable
@Immutable
data class ECommerceUiState(
    val products: List<Product> = emptyList(),
    val cartItems: List<CartItem> = emptyList(),
    val selectedCategory: String = "ALL",
    val searchQuery: String = "",
    val isToastVisible: Boolean = false,
    val toastMessage: String = "",
    val isCartDrawerOpen: Boolean = false
) {
    val totalCartCount: Int get() = cartItems.sumOf { it.quantity }
    val totalCartAmount: Double get() = cartItems.sumOf { it.product.price * it.quantity }
}
