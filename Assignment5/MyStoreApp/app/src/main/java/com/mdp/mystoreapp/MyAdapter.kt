package com.mdp.mystoreapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mdp.mystoreapp.model.Product
import kotlinx.android.synthetic.main.product_item.view.*

class MyAdapter(val context: Context, val productList: ArrayList<Product>): RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.product_item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val product = productList[position]
        holder.itemView.txtTitle.text = product.title
        holder.itemView.txtPrice.text = "Price: $${product.price}"
        holder.itemView.txtColor.text = "Color: ${product.color}"
        holder.itemView.itemImg.setImageResource(product.image)
        holder.itemView.setOnClickListener{
            val intent = Intent(context, ProductDetailActivity::class.java)
            intent.putExtra("product", product)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}