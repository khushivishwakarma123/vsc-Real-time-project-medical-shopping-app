package com.example.clothesshop

object CartManager {

    private val cartList = mutableListOf<Product>()

    // ➕ ADD ITEM
    fun addToCart(product: Product) {
        cartList.add(product)
    }

    // 📦 GET ITEMS
    fun getCartItems(): List<Product> {
        return cartList
    }

    // ❌ REMOVE ITEM
    fun removeFromCart(product: Product) {
        cartList.remove(product)
    }

    // 🧹 CLEAR CART (🔥 THIS FIXES YOUR ERROR)
    fun clearCart() {
        cartList.clear()
    }
}