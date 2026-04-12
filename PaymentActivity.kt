package com.example.clothesshop

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.clothesshop.databinding.ActivityPaymentBinding

class PaymentActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPaymentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPaymentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val total = intent.getStringExtra("TOTAL")
        binding.totalText.text = "Pay: ₹$total"

        // 🔥 PAY BUTTON
        binding.payBtn.setOnClickListener {

            val selectedId = binding.paymentGroup.checkedRadioButtonId

            if (selectedId == -1) {
                Toast.makeText(this, "Select payment method", Toast.LENGTH_SHORT).show()
            } else {

                Toast.makeText(this, "Payment Successful 💳", Toast.LENGTH_SHORT).show()

                // 🧹 clear cart
                CartManager.clearCart()

                // 🎉 go to success screen
                startActivity(Intent(this, OrderSuccessActivity::class.java))
                finish()
            }
        }
    }
}

