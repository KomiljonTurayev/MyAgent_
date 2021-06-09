package com.example.myagent.adapters

import android.graphics.Color
import android.graphics.Typeface
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myagent.R
import com.example.myagent.network.dto.MockData
import kotlinx.android.synthetic.main.item_history_order.view.*

class OrderHistoryAdapter : RecyclerView.Adapter<OrderHistoryAdapter.ViewHolder>() {
    val list = MockData.getOrderHistoryDataList()

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

//        val orderHistotyContent = itemView.findViewById<LinearLayout>(R.id.orderContent)

        val mainLayout = itemView.content

        fun bind(item: MockData.OrderHistoryData) {


            for (i in item.item) {
                val textViewShopName = TextView(itemView.context)
                val count = TextView(itemView.context)
                val cost = TextView(itemView.context)

                val imageView = ImageView(itemView.context)

                val childLinearLayout = LinearLayout(itemView.context)
                childLinearLayout.layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                childLinearLayout.orientation = LinearLayout.HORIZONTAL

                val innerChild = LinearLayout(itemView.context)
                innerChild.layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                innerChild.orientation = LinearLayout.VERTICAL

                val childInnerChild = LinearLayout(itemView.context)
                childInnerChild.layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                childInnerChild.orientation = LinearLayout.HORIZONTAL

                count.textSize = 15f
                textViewShopName.textSize = 15f

                textViewShopName.text = i.aboutProduct
                count.text = i.count
                cost.text = i.cost
                imageView.setImageResource(i.productImage)

                textViewShopName.setTypeface(null, Typeface.BOLD)
//                count.setTextColor(Color.parseColor("#222C6B"))
                textViewShopName.setTextColor(Color.parseColor("#231F20"))
                count.setTextColor(Color.parseColor("#231F20"))
                cost.setTextColor(Color.parseColor("#231F20"))

                count.gravity = Gravity.CENTER_VERTICAL
                cost.gravity = Gravity.CENTER_VERTICAL
                textViewShopName.gravity = Gravity.CENTER_VERTICAL

//                imageView.setBackgroundResource(R.drawable.rounded_login)
                val layoutparamsfortextview = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                val layoutParmsImageView = LinearLayout.LayoutParams(120, 120)

                val layoutParmsTextView = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )

                imageView.setPadding(10, 10, 10, 10)

                childLinearLayout.setPadding(10, 10, 10, 10)

                layoutParmsImageView.gravity = Gravity.CENTER_VERTICAL
                layoutParmsTextView.gravity = Gravity.CENTER_VERTICAL

                layoutparamsfortextview.setMargins(20, 20, 20, 20)
//                layoutparamsfortextview.setMargins(16, 16, 16, 16)
                //    textview.layoutParams = layoutparamsfortextview

                textViewShopName.setPadding(16, 8, 16, 0)
                count.setPadding(16, 16, 16, 0)
                cost.setPadding(16, 16, 16, 0)

                textViewShopName.layoutParams = layoutParmsTextView
                count.layoutParams = layoutParmsTextView

                imageView.layoutParams = layoutParmsImageView
//                innerChild.layoutParams=layoutParmsImageView
                // itemsListLayout.addView(textview)
                // itemsListLayout.addView(imageView)
                childLinearLayout.addView(imageView)
                childLinearLayout.addView(innerChild)

                childInnerChild.addView(count)
                childInnerChild.addView(cost)
                innerChild.addView(textViewShopName)
                innerChild.addView(childInnerChild)
                mainLayout.addView(childLinearLayout)

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater.from(parent.context).inflate(
            R.layout.item_history_order, parent, false
        )
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(list[position])

    override fun getItemCount() = list.size
}