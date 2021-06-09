package com.example.myagent.ui.category

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.myagent.MainActivity
import com.example.myagent.R
import com.example.myagent.adapters.ProductCategoryAdapter
import com.example.myagent.adapters.ScreenSlidePagerAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.fragment_product_category.view.*

class ProductCategoryFragment : Fragment() {

    private lateinit var adapterViewPager2: ScreenSlidePagerAdapter
    private lateinit var viewPager2: ViewPager2
    private lateinit var tabLayout: TabLayout
    lateinit var  activity: MainActivity

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_product_category, container, false)
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerCategory)

        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val mAdapter = ProductCategoryAdapter()

        recyclerView.adapter = mAdapter

        mAdapter.onItemClick = {

            if (it.product == "Bonduelle резаные") {
//                Toast.makeText(requireContext(), "basket_image", Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.cannedProductsFragment)
            } else findNavController().navigate(R.id.nav_wine)


//        btnOrder.setOnClickListener {
//            Toast.makeText(requireContext(), "Order", Toast.LENGTH_SHORT).show()
//            findNavController().navigate(R.id.nav_order)
        }
        view.imageBackHomeProductCategory.setOnClickListener {
            view.findNavController().navigate(R.id.action_nav_product_category_to_nav_all_product)
        }

        viewPager2 = view.findViewById(R.id.viewPager)
        adapterViewPager2 = ScreenSlidePagerAdapter(this)
        tabLayout = view.findViewById(R.id.tabLayoutViewPager2)

        viewPager2.adapter = adapterViewPager2

        val list = ArrayList<Int>()
        list.add(R.drawable.photo_product)
        list.add(R.drawable.photo_product)
        list.add(R.drawable.photo_product)
        list.add(R.drawable.photo_product)

        adapterViewPager2.update(list)

        TabLayoutMediator(tabLayout, viewPager2) { _, _ ->
//            top.text ="OBJECT ${(position + 1)}"
        }.attach()

        val spinner: Spinner = view.findViewById(R.id.planets_spinner)
        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.planets_array,
            R.layout.spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }

        activity=requireActivity() as MainActivity

        activity.imageBasket.setOnClickListener {
            Log.d("ttt", "imageBasket")

            view.findNavController().navigate(R.id.action_nav_product_category_to_nav_basket)
        }

        activity.imageStar.setOnClickListener {
            Log.d("ttt", "imageStar")
//            navController.popBackStack()
            view.findNavController().navigate(R.id.action_nav_product_category_to_favouriteFragment)
        }
    }
}

