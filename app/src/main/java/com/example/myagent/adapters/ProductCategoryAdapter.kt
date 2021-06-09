package com.example.myagent.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myagent.R
import com.example.myagent.network.dto.MockData

class ProductCategoryAdapter : RecyclerView.Adapter<ProductCategoryAdapter.ViewHolder>() {
    val list = MockData.getProductCategoryDataList()
    var onItemClick:((MockData.ProductCategoryData)->Unit)?=null

   inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var imageProduct = itemView.findViewById<ImageView>(R.id.imageProduct)
        val textProduct = itemView.findViewById<TextView>(R.id.textProduct)

        fun bind(item: MockData.ProductCategoryData) {
            var d = item
            imageProduct.setImageResource(d.image)
            textProduct.text = d.product
        }

        init {
            itemView.setOnClickListener {
                onItemClick?.invoke(list[adapterPosition])
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater.from(parent.context).inflate(
            R.layout.item_product_category, parent, false
        )
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(list[position])

    override fun getItemCount() = list.size
}