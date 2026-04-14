package com.example.clothesshop

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.clothesshop.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: ProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        // 🔥 Product List
        val productList = listOf(

            Product("Paracetamol Tablets", "₹50",
                "https://images.pexels.com/photos/593451/pexels-photo-593451.jpeg"),

            Product("Crocin Advance", "₹35",
                "https://images.pexels.com/photos/3683101/pexels-photo-3683101.jpeg"),

            Product("Dolo 650", "₹40",
                "https://images.pexels.com/photos/3683101/pexels-photo-3683101.jpeg"),

            Product("Cough Syrup", "₹120",
                "https://images.pexels.com/photos/7615467/pexels-photo-7615467.jpeg"),

            Product("Vitamin C Tablets", "₹180",
                "https://images.pexels.com/photos/593451/pexels-photo-593451.jpeg"),

            Product("ORS Sachet", "₹20",
                "https://images.pexels.com/photos/593451/pexels-photo-593451.jpeg"),

            Product("Band Aid Strips", "₹60",
                "https://images.pexels.com/photos/263402/pexels-photo-263402.jpeg"),

            Product("Antiseptic Liquid (Dettol)", "₹150",
                "https://images.pexels.com/photos/5450143/pexels-photo-5450143.jpeg"),

            Product("Hand Sanitizer", "₹99",
                "https://images.pexels.com/photos/5450143/pexels-photo-5450143.jpeg"),

            Product("Face Mask (Pack)", "₹120",
                "https://images.pexels.com/photos/3952234/pexels-photo-3952234.jpeg"),

            Product("Digital Thermometer", "₹299",
                "https://images.pexels.com/photos/7089401/pexels-photo-7089401.jpeg"),

            Product("Blood Pressure Monitor", "₹1499",
                "https://images.pexels.com/photos/7089629/pexels-photo-7089629.jpeg"),

            Product("Glucometer", "₹999",
                "https://images.pexels.com/photos/6823568/pexels-photo-6823568.jpeg"),

            Product("Pulse Oximeter", "₹899",
                "https://images.pexels.com/photos/7089626/pexels-photo-7089626.jpeg"),

            Product("Medical Gloves", "₹299",
                "https://images.pexels.com/photos/5450142/pexels-photo-5450142.jpeg"),

            Product("Syringe Pack", "₹200",
                "https://images.pexels.com/photos/3938022/pexels-photo-3938022.jpeg"),

            Product("Hot Water Bag", "₹199",
                "https://images.pexels.com/photos/6627997/pexels-photo-6627997.jpeg"),

            Product("Heating Pad", "₹699",
                "https://images.pexels.com/photos/6627998/pexels-photo-6627998.jpeg"),

            Product("Eye Drops", "₹150",
                "https://images.pexels.com/photos/593451/pexels-photo-593451.jpeg"),

            Product("First Aid Kit", "₹599",
                "https://images.pexels.com/photos/263402/pexels-photo-263402.jpeg")
        )

        // 🔥 Adapter (IMPORTANT CHANGE)
        adapter = ProductAdapter(productList.toMutableList())

        // 🔥 RecyclerView
        binding.recyclerView.layoutManager = GridLayoutManager(this, 2)
        binding.recyclerView.adapter = adapter

        // 🔥 Padding
        binding.recyclerView.setPadding(8, 8, 8, 8)
        binding.recyclerView.clipToPadding = false

        // 🔍 SEARCH LOGIC
        binding.searchView.setOnQueryTextListener(object : android.widget.SearchView.OnQueryTextListener {

            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                adapter.filter(newText ?: "")
                return true
            }
        })

        // 🛒 OPEN CART
        binding.cartBtn.setOnClickListener {
            startActivity(Intent(this, CartActivity::class.java))
        }
    }
}