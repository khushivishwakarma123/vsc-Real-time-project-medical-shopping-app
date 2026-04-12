package com.example.clothesshop

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.clothesshop.databinding.ItemProductBinding

class CartAdapter(
    private val list: MutableList<Product>,
    private val onItemRemoved: () -> Unit   // 🔥 callback to update total
) : RecyclerView.Adapter<CartAdapter.ViewHolder>() {

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

        // ❌ Change button text
        holder.binding.addToCartBtn.text = "Remove"


        holder.binding.addToCartBtn.setOnClickListener {

            CartManager.removeFromCart(product)
            list.removeAt(position)

            notifyItemRemoved(position)
            notifyItemRangeChanged(position, list.size)

            Toast.makeText(
                holder.itemView.context,
                "${product.name} removed",
                Toast.LENGTH_SHORT
            ).show()

            onItemRemoved()
        }
    }

    override fun getItemCount(): Int = list.size
}