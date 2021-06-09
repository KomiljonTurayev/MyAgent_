package com.example.myagent.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myagent.R
import com.example.myagent.network.dto.MockData
import kotlinx.android.synthetic.main.item_supplier.view.*

//class HowDoesItWorkAdapter : RecyclerView.Adapter<HowDoesItWorkAdapter.ViewHolder>() {
////    val list = MockData.getSuppliersDataList()
//
//    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//
//        val textName = itemView.textName
//        val shop = itemView.textShop
//
//        fun bind(item: MockData.SuppliersData) {
//            item.apply {
//                val d = item
//                textName.text = d.name
//                shop.text = d.shopName
//            }
//        }
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
//        LayoutInflater.from(parent.context).inflate(
//            R.layout.item_supplier, parent, false
//        )
//    )
//
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(list[position])
//
//    override fun getItemCount() = list.size
//}