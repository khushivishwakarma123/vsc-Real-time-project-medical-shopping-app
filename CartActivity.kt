package com.example.clothesshop

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.clothesshop.databinding.ActivityCartBinding

class CartActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCartBinding
    private lateinit var cartList: MutableList<Product>
    private lateinit var adapter: CartAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 🔥 Get Cart Data
        cartList = CartManager.getCartItems().toMutableList()

        // 🔥 RecyclerView
        binding.cartRecyclerView.layoutManager = LinearLayoutManager(this)

        adapter = CartAdapter(cartList) {
            updateTotal()
        }

        binding.cartRecyclerView.adapter = adapter

        // 🛒 BUY / CHECKOUT BUTTON (UPDATED)
        binding.checkoutBtn.setOnClickListener {

            if (cartList.isEmpty()) {
                Toast.makeText(this, "Cart is empty", Toast.LENGTH_SHORT).show()
            } else {

                // 🔥 Calculate total
                var total = 0
                for (item in cartList) {
                    val price = item.price.replace("₹", "").toInt()
                    total += price
                }

                // 👉 Open Checkout Screen
                val intent = Intent(this, CheckoutActivity::class.java)
                intent.putExtra("TOTAL", total.toString())
                startActivity(intent)
            }
        }

        updateTotal()
    }

    // 🔥 TOTAL FUNCTION
    private fun updateTotal() {
        var total = 0
        for (item in cartList) {
            val price = item.price.replace("₹", "").toInt()
            total += price
        }
        binding.totalPrice.text = "Total: ₹$total"
    }
}