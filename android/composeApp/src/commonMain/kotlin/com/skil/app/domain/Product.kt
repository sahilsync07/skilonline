package com.skil.app.domain

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable

@Stable
@Immutable
data class Product(
    val id: String,
    val name: String,
    val category: String,
    val price: Double,
    val rating: String,
    val iconEmoji: String,
    val badge: String
)

@Stable
@Immutable
data class CartItem(
    val product: Product,
    val quantity: Int
)
