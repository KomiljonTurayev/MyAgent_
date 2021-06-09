package com.example.myagent.ui.category

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import com.example.myagent.R
import com.example.myagent.network.dto.MockData
import kotlinx.android.synthetic.main.fragment_selected_product_info.view.*
import kotlinx.android.synthetic.main.fragment_selected_product_info.view.body_of_product
import kotlinx.android.synthetic.main.fragment_selected_product_info.view.company_name
import kotlinx.android.synthetic.main.fragment_selected_product_info.view.count_of_items
import kotlinx.android.synthetic.main.fragment_selected_product_info.view.imageOfProduct
import kotlinx.android.synthetic.main.fragment_selected_product_info.view.image_plus
import kotlinx.android.synthetic.main.fragment_selected_product_info.view.minus_one
import kotlinx.android.synthetic.main.fragment_selected_product_info.view.minus_ten
import kotlinx.android.synthetic.main.fragment_selected_product_info.view.plus_ten
import kotlinx.android.synthetic.main.fragment_selected_product_info.view.price_of_product
import kotlinx.android.synthetic.main.fragment_selected_product_info.view.title_of_product
import kotlinx.android.synthetic.main.products_item.view.*

class SelectedProductInfoFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View=inflater.inflate(R.layout.fragment_selected_product_info, container, false)
        var img=requireArguments().getInt("img")
        view.imageOfProduct.setImageResource(img)
        view.title_of_product.text=requireArguments().getString("title")
        view.body_of_product.text=requireArguments().getString("textBody")
        view.company_name.text=requireArguments().getString("pompany_name")
        view.price_of_product.text=requireArguments().getString("price")
        var count=requireArguments().getInt("cont")
        view.count_of_items.text="$count  шт \n" + "В корзину"

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var i=requireArguments().getInt("cont")
        val list=MockData.getAllProducts()
        val itemCount=view.count_of_items
        val position=requireArguments().getInt("position")
        view.back_arrow_foood.setOnClickListener {
            view.findNavController().popBackStack()
        }
        view.minus_one.setOnClickListener {
            if (i>1){
                i--
                itemCount.text="$i шт \nВ корзину"
                list[position].quantity=i
            }
        }
        view.minus_ten.setOnClickListener {
            if(i>=10){
                i-=10
                itemCount.text="$i шт \nВ корзину"
                list[position].quantity=i
            }
        }
        view.plus_ten.setOnClickListener {
            i+=10
            itemCount.text="$i шт \nВ корзину"
            list[position].quantity=i
        }
        view.image_plus.setOnClickListener {
            i++
            itemCount.text="$i шт \nВ корзину"

            list[position].quantity=i
            //Toast.makeText(requireContext(),list[position].quantity,Toast.LENGTH_LONG).show()
        Log.d("ttt","${list[position].quantity}")

        }
        view.back_arrow_foood.setOnClickListener {
            view.findNavController().popBackStack()
        }
    }


}