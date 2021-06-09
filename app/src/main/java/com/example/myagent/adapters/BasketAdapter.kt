package com.example.myagent.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.myagent.R
import com.example.myagent.network.dto.MockData
import kotlinx.android.synthetic.main.item_basket.view.*

class BasketAdapter : RecyclerView.Adapter<BasketAdapter.ViewHolder>() {
    val list = MockData.getBastketList()

    fun remove(position: Int) {
        list.removeAt(position)
        notifyItemRemoved(position)
    }

    private var listener: ((Int) -> Unit)? = null

    fun setOnItemClickListener(f: (Int) -> Unit) {
        listener = f
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var basket_image = itemView.imageBasket
        var textTitle = itemView.textTitle
        var textAbout = itemView.textAbout
        var textShopName = itemView.textShopName
        var textCost = itemView.textCost
        val back = itemView.imageBack

        init {
            itemView.setOnClickListener {
                listener?.invoke(adapterPosition)
            }

            back.setOnClickListener {
                Toast.makeText(itemView.context, "${adapterPosition}", Toast.LENGTH_SHORT).show()
                Log.d("ttt", "back")
                remove(adapterPosition)
            }

            var i = 1
//25
            itemView.llMinusTen.setOnClickListener {
                if (i >= 10 && i % 10 == 0) {
                    i -= 10
                    itemView.textQuantity.text = "$i шт."
                }
                if (i >= 10 && i % 10 != 0) {
                    val k = i % 10
                    i -= k
                    itemView.textQuantity.text = "$i шт."
                }
                if (i > 0 && i < 10) {
                    i = 0
                    itemView.textQuantity.text = "$i шт."
                }
            }
            itemView.llPlusTen.setOnClickListener {
             if (i >= 10 && i % 10 == 0) {
                    i += 10
                    itemView.textQuantity.text = "$i шт."
                }
                if (i >= 10 && i % 10 != 0) {
                    i += 10
                    val k = i % 10
                    i -= k
                    itemView.textQuantity.text = "$i шт."
                }
                if (i >= 0 && i < 10) {
                    i = 10
                    itemView.textQuantity.text = "$i шт."
                }
            }
            itemView.llMinus.setOnClickListener {
                if (i > 0) {
                    i--
                    Log.i("tttt", "$i")
                    itemView.textQuantity.text = "$i шт."
                }
            }
            itemView.llPlus.setOnClickListener {
                i++
                itemView.textQuantity.text = "$i шт."
                Log.i("tttt", "$i")
            }

            itemView.imageBack.setOnClickListener {
                remove(adapterPosition)
            }
        }

        fun bind(item: MockData.BasketData) {
            val d = item
            basket_image.setImageResource(d.imageProduct)
            textTitle.text = d.productTitle
            textAbout.text = d.productAbout
            textShopName.text = d.shopName
            textCost.text = d.productCost

        }


    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater.from(parent.context).inflate(
            R.layout.item_basket, parent, false
        )
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(list[position])

    override fun getItemCount() = list.size

//    private fun deleteItem(position: Int) {
//        list.remove(position)
//        notifyItemRemoved(position)
//        notifyItemRangeChanged(position, list.size)
////        holder.itemView.visibility = View.GONE
//    }


    companion object {
    }
}