package com.example.clothesshop

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.clothesshop.databinding.ActivityCheckoutBinding

class CheckoutActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCheckoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCheckoutBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val total = intent.getStringExtra("TOTAL") ?: "0"
        binding.totalText.text = "Total Amount: ₹$total"


        binding.placeOrderBtn.setOnClickListener {

            val address = binding.address.text.toString().trim()


            if (address.isEmpty()) {
                Toast.makeText(this, "Enter delivery address", Toast.LENGTH_SHORT).show()
            } else {

                val intent = Intent(this, PaymentActivity::class.java)
                intent.putExtra("TOTAL", total)
                startActivity(intent)
            }
        }
    }
}