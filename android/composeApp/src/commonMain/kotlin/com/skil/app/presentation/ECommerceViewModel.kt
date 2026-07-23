package com.skil.app.presentation

import com.skil.app.domain.CartItem
import com.skil.app.domain.Product
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ECommerceViewModel {
    private val initialProducts = listOf(
        Product("prod-1", "SKIL Memphis Oversized Hoodie", "APPAREL", 89.0, "5.0", "HOODIE", "HOT DROP"),
        Product("prod-2", "120Hz Velocity Retro Kicks", "FOOTWEAR", 149.0, "5.0", "KICKS", "LIMITED"),
        Product("prod-3", "Cyber Neon Crossbody Bag", "ACCESSORIES", 45.0, "4.8", "BAG", "NEW"),
        Product("prod-4", "Brutalist Mechanical Keyboard", "TECH", 129.0, "5.0", "KEYS", "BEST SELLER"),
        Product("prod-5", "SKIL Signature Graphic Tee", "APPAREL", 39.0, "4.7", "TEE", "POPULAR"),
        Product("prod-6", "Lime Brutal Wireless Earbuds", "TECH", 79.0, "4.9", "EARBUDS", "NEW")
    )

    private val _uiState = MutableStateFlow(
        ECommerceUiState(products = initialProducts)
    )
    val uiState: StateFlow<ECommerceUiState> = _uiState.asStateFlow()

    fun addToCart(product: Product) {
        _uiState.update { currentState ->
            val existing = currentState.cartItems.find { it.product.id == product.id }
            val updatedCart = if (existing != null) {
                currentState.cartItems.map {
                    if (it.product.id == product.id) it.copy(quantity = it.quantity + 1) else it
                }
            } else {
                currentState.cartItems + CartItem(product, 1)
            }

            currentState.copy(
                cartItems = updatedCart,
                isToastVisible = true,
                toastMessage = "Added '${product.name}' to cart!"
            )
        }
    }

    fun updateQuantity(productId: String, delta: Int) {
        _uiState.update { currentState ->
            val updatedCart = currentState.cartItems.mapNotNull { item ->
                if (item.product.id == productId) {
                    val newQty = item.quantity + delta
                    if (newQty > 0) item.copy(quantity = newQty) else null
                } else item
            }
            currentState.copy(cartItems = updatedCart)
        }
    }

    fun setCategory(category: String) {
        _uiState.update { it.copy(selectedCategory = category) }
    }

    fun setSearchQuery(query: String) {
        _uiState.update { it.copy(searchQuery = query) }
    }

    fun toggleCartDrawer() {
        _uiState.update { it.copy(isCartDrawerOpen = !it.isCartDrawerOpen) }
    }

    fun dismissToast() {
        _uiState.update { it.copy(isToastVisible = false) }
    }

    fun checkout() {
        _uiState.update { currentState ->
            val total = currentState.totalCartAmount
            currentState.copy(
                cartItems = emptyList(),
                isCartDrawerOpen = false,
                isToastVisible = true,
                toastMessage = "Order Placed Successfully ($$total)! Thanks for shopping SKIL!"
            )
        }
    }
}
