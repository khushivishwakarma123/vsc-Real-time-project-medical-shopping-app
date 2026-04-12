package com.example.clothesshop

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.clothesshop.databinding.ItemProductBinding

class ProductAdapter(
    private val list: List<Product>
) : RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    class ViewHolder(val binding: ItemProductBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemProductBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val product = list[position]

        holder.binding.productName.text = product.name
        holder.binding.productPrice.text = product.price

        Glide.with(holder.itemView.context)
            .load(product.image)
            .into(holder.binding.productImage)

        // 🛒 ADD TO CART
        holder.binding.addToCartBtn.setOnClickListener {
            CartManager.addToCart(product)

            Toast.makeText(
                holder.itemView.context,
                product.name + " added to cart",
                Toast.LENGTH_SHORT
            ).show()
        }

        // ⚡ BUY NOW (🔥 IMPORTANT)
        holder.binding.buyNowBtn.setOnClickListener {

            val context = holder.itemView.context

            val intent = Intent(context, CheckoutActivity::class.java)
            intent.putExtra("TOTAL", product.price.replace("₹", ""))

            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = list.size
}