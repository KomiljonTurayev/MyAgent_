package com.example.myagent.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myagent.R
import com.example.myagent.network.dto.MockData
import kotlinx.android.synthetic.main.item_suppliers_list.view.*

class SuppliersListAdapter : RecyclerView.Adapter<SuppliersListAdapter.ItemView>() {
    val list = MockData.getSuppliersList()

    var onItemClick: ((MockData.SupplierListOfData) -> Unit)? = null

    inner class ItemView(view: View) : RecyclerView.ViewHolder(view) {
        val name = view.supplier_name
        val companyName = view.supplier_company

        fun bind(d: MockData.SupplierListOfData) {
            name.text = d.name
            companyName.text = d.companyName
        }

        init {
//            itemView.setOnClickListener { listener?.invoke(adapterPosition) }
            itemView.setOnClickListener { onItemClick?.invoke(list[adapterPosition]) }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemView {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_suppliers_list, parent, false)
        return ItemView(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ItemView, position: Int) {
        return holder.bind(list[position])
    }
}