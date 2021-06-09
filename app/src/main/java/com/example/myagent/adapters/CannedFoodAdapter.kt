package com.example.myagent.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myagent.R
import com.example.myagent.network.dto.MockData
import kotlinx.android.synthetic.main.products_item.view.*

class CannedFoodAdapter:RecyclerView.Adapter<CannedFoodAdapter.ItemView>() {
    val list=MockData.getAllProducts()
    private lateinit var getData:MockData.AllProducts
    var onItemClick:((MockData.AllProducts)->Unit)?=null
    inner class ItemView(view: View): RecyclerView.ViewHolder(view){
        val img=view.imageOfProduct
        val title=view.title_of_product
        val textBody=view.body_of_product
        val companyName=view.company_name
        val prive=view.price_of_product
        val newRed=view.text_new_item
        val itemCount=view.count_of_items
        val linear=view.linear_layout_to_hide
        var i=1

        fun bind(d: MockData.AllProducts){
            img.setImageResource(d.img)
            title.text=d.title
            textBody.text=d.textBody
            companyName.text=d.companyName
            prive.text=d.price
            newRed.text=d.isNew
            itemCount.text="${d.quantity} шт \nВ корзину"
            linear.visibility=View.GONE

        }
        init {

            view.linear_layout_clicable.setOnClickListener {
                onItemClick?.invoke(list[adapterPosition])
                list[adapterPosition].position=adapterPosition
            }

            view.minus_one.setOnClickListener {
                var i=list[adapterPosition].quantity
                if (i>1){
                    i--
                    itemCount.text="$i шт \nВ корзину"
                    list[adapterPosition].quantity=i
                }
            }
            view.minus_ten.setOnClickListener {
                var i=list[adapterPosition].quantity
                if(i>=10){
                    i-=10
                    itemCount.text="$i шт \nВ корзину"
                    list[adapterPosition].quantity=i
                }
            }
            view.plus_ten.setOnClickListener {
                var i=list[adapterPosition].quantity
                i+=10
                itemCount.text="$i шт \nВ корзину"
                list[adapterPosition].quantity=i
            }
            view.image_plus.setOnClickListener {
                var i=list[adapterPosition].quantity
                i++
                itemCount.text="$i шт \nВ корзину"
                list[adapterPosition].quantity=i
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemView {
        val view:View= LayoutInflater.from(parent.context).inflate(R.layout.products_item,parent,false)
        return ItemView(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ItemView, position: Int) {
        return holder.bind(list[position])
    }
}