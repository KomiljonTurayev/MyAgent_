package com.example.myagent.ui.allproducts

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myagent.R
import com.example.myagent.adapters.AllProductsAdapter
import com.example.myagent.ui.category.SelectedProductInfoFragment

class NonFoodFragment : Fragment() {

    private lateinit var adapter: AllProductsAdapter
    private var nextFragmnet= SelectedProductInfoFragment()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View=inflater.inflate(R.layout.fragment_non_food, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView=view.findViewById<RecyclerView>(R.id.recycler_view_non_food)
        recyclerView.layoutManager=LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
        adapter= AllProductsAdapter()
        recyclerView.adapter=adapter
        val bundle=Bundle()
        adapter.onItemClick={
            bundle.putInt("img",it.img)
            bundle.putString("title",it.title)
            bundle.putString("textBody",it.textBody)
            bundle.putString("pompany_name", it.companyName)
            bundle.putString("price",it.price)
            bundle.putInt("cont",it.quantity)
            bundle.putInt("position",it.position)
            nextFragmnet.arguments=bundle
            view.findNavController().navigate(R.id.selectedProductInfoFragment,bundle)
        }
    }

}