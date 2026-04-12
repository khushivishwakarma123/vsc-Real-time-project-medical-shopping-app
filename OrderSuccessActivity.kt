package com.example.clothesshop

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.clothesshop.databinding.ActivityOrderSuccessBinding

class OrderSuccessActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOrderSuccessBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityOrderSuccessBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.homeBtn.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}