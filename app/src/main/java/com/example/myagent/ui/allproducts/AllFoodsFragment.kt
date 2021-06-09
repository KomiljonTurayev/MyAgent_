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

class AllCategoryFragment : Fragment() {
    private var nextFragmnet= SelectedProductInfoFragment()
    private lateinit var adapter: AllProductsAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View=inflater.inflate(R.layout.fragment_all_category, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerview=view.findViewById<RecyclerView>(R.id.recycler_view_allProducts)
        recyclerview.layoutManager=LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
        adapter= AllProductsAdapter()
        recyclerview.adapter=adapter
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