package com.example.clothesshop

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.clothesshop.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 🔥 Product List
        val productList = listOf(

            Product("Digital Thermometer", "₹299",
                "https://images.pexels.com/photos/7089401/pexels-photo-7089401.jpeg"),

            Product("Blood Pressure Monitor", "₹1499",
                "https://images.pexels.com/photos/7089629/pexels-photo-7089629.jpeg"),

            Product("Stethoscope", "₹799",
                "https://images.pexels.com/photos/40568/medical-appointment-doctor-healthcare-40568.jpeg"),

            Product("Face Mask (Pack of 50)", "₹399",
                "https://images.pexels.com/photos/3952234/pexels-photo-3952234.jpeg"),

            Product("Hand Sanitizer", "₹199",
                "https://images.pexels.com/photos/5450143/pexels-photo-5450143.jpeg"),

            Product("Glucometer", "₹999",
                "https://images.pexels.com/photos/6823568/pexels-photo-6823568.jpeg"),

            Product("First Aid Kit", "₹599",
                "https://images.pexels.com/photos/263402/pexels-photo-263402.jpeg"),

            Product("Pulse Oximeter", "₹899",
                "https://images.pexels.com/photos/7089626/pexels-photo-7089626.jpeg"),

            Product("Syringe Pack", "₹249",
                "https://images.pexels.com/photos/3938022/pexels-photo-3938022.jpeg"),

            Product("Medical Gloves (Box)", "₹499",
                "https://images.pexels.com/photos/5450142/pexels-photo-5450142.jpeg"),

            Product("Wheelchair", "₹4999",
                "https://images.pexels.com/photos/7551677/pexels-photo-7551677.jpeg"),

            Product("Walking Stick", "₹399",
                "https://images.pexels.com/photos/7551676/pexels-photo-7551676.jpeg"),

            Product("Hot Water Bag", "₹199",
                "https://images.pexels.com/photos/6627997/pexels-photo-6627997.jpeg"),

            Product("Nebulizer", "₹1999",
                "https://images.pexels.com/photos/7089400/pexels-photo-7089400.jpeg"),

            Product("Infrared Thermometer", "₹1299",
                "https://images.pexels.com/photos/7089402/pexels-photo-7089402.jpeg"),

            Product("Oxygen Cylinder (Portable)", "₹6999",
                "https://images.pexels.com/photos/7089628/pexels-photo-7089628.jpeg"),

            Product("Heating Pad", "₹699",
                "https://images.pexels.com/photos/6627998/pexels-photo-6627998.jpeg"),

            Product("Weighing Scale", "₹899",
                "https://images.pexels.com/photos/4498362/pexels-photo-4498362.jpeg"),

            Product("Medical Bed", "₹12999",
                "https://images.pexels.com/photos/263402/pexels-photo-263402.jpeg"),

            Product("Eye Drops", "₹149",
                "https://images.pexels.com/photos/593451/pexels-photo-593451.jpeg")
        )

        // 🔥 GRID VIEW (Flipkart Style)
        binding.recyclerView.layoutManager = GridLayoutManager(this, 2)
        binding.recyclerView.adapter = ProductAdapter(productList)

        // 🔥 Spacing (optional but good UI)
        binding.recyclerView.setPadding(8, 8, 8, 8)
        binding.recyclerView.clipToPadding = false

        // 🛒 OPEN CART
        binding.cartBtn.setOnClickListener {
            startActivity(Intent(this, CartActivity::class.java))
        }
    }
}