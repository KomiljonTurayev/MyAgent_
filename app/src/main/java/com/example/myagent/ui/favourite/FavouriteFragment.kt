package com.example.myagent.ui.favourite

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.myagent.MainActivity
import com.example.myagent.R
import com.example.myagent.adapters.FavouriteAdapter
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.fragment_current_order.view.*
import kotlinx.android.synthetic.main.fragment_fovourite.view.*
import kotlinx.android.synthetic.main.fragment_fovourite.view.tabLayoutFavouriteProducts


class FavouriteFragment : Fragment() {
    private lateinit var viewpager: ViewPager2
    private lateinit var adapterFavourite: FavouriteAdapter

    lateinit var  activity:MainActivity


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View=inflater.inflate(R.layout.fragment_fovourite, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapterFavourite= FavouriteAdapter(this)
        viewpager=view.viewPagerAllProducts
        viewpager.adapter=adapterFavourite
        view.back_arrow_favourite_new_change.setOnClickListener {
            view.findNavController().popBackStack()
        }
        activity=requireActivity() as MainActivity

        activity.imageBasket.setOnClickListener {
            Log.d("ttt", "imageBasket")

            view.findNavController().navigate(R.id.action_favouriteFragment_to_nav_basket)
        }

        activity.imageStar.setOnClickListener {
            Log.d("ttt", "imageStar")
//            navController.popBackStack()
//            view.findNavController().navigate(R.id.action_nav_all_product_to_favouriteFragment)
        }


        val tabLayout=view.tabLayoutFavouriteProducts
        TabLayoutMediator(tabLayout,viewpager){
            tab, position ->
            when(position){
                0->{
                    tab.text="Все"
                }
                1->{
                    tab.text="Продовольственные"
                }
                2->{
                    tab.text="Непродовольственные"
                }
            }
        }.attach()

    }

//    override fun onPause() {
////        view?.findNavController()?.popBackStack()
//        super.onPause()
//
//        Log.d("ttt","onPause star")
//    }

}