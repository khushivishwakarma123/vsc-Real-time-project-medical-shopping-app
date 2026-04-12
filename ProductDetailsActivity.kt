package com.example.clothesshop

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.clothesshop.databinding.ActivityProductDetailsBinding

class ProductDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProductDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityProductDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 🔥 Get Data from Intent
        val name = intent.getStringExtra("name")
        val price = intent.getStringExtra("price")
        val image = intent.getStringExtra("image")

        // 🔥 Set Data
        binding.productName.text = name
        binding.productPrice.text = price

        Glide.with(this)
            .load(image)
            .into(binding.productImage)

        // 🛒 Add to Cart
        binding.addToCartBtn.setOnClickListener {
            CartManager.addToCart(Product(name!!, price!!, image!!))
            Toast.makeText(this, "Added to Cart", Toast.LENGTH_SHORT).show()
        }

        // 💳 Buy Now
        binding.buyNowBtn.setOnClickListener {
            Toast.makeText(this, "Proceed to Payment 💳", Toast.LENGTH_SHORT).show()
        }
    }
}