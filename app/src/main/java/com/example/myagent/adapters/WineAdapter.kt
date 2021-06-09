package com.example.myagent.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.myagent.R
import com.example.myagent.network.dto.MockData

class WineAdapter : RecyclerView.Adapter<WineAdapter.ViewHolder>() {
    var list = MockData.getWineDataList()

    var onItemClick: ((MockData.WineData) -> Unit)? = null

  inner  class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var imageWine = itemView.findViewById<ImageView>(R.id.imageWine)
        var textWine = itemView.findViewById<TextView>(R.id.textWineName)

        fun bind(item: MockData.WineData) {
            itemView.apply {
                val d = item
                imageWine.setImageResource(d.image)
                textWine.text = d.name
            }
        }

        init {
            itemView.setOnClickListener {
                onItemClick?.invoke(list[adapterPosition])
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater.from(parent.context).inflate(
            R.layout.item_wine, parent, false
        )
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(list[position])

    override fun getItemCount() = list.size
}