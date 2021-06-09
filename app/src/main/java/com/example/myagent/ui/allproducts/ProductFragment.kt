package com.example.myagent.ui.allproducts

import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.SharedElementCallback
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.myagent.MainActivity
import com.example.myagent.R
import com.example.myagent.adapters.AdapterAllProductsTabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.fragment_all_product.view.*


class AllProductFragment : Fragment() {

    lateinit var  activity:MainActivity

    private lateinit var viewPager: ViewPager2
    private lateinit var adapterTabAllProductsTabLayout: AdapterAllProductsTabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

 }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_all_product, container, false)

        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapterTabAllProductsTabLayout = AdapterAllProductsTabLayout(this)
        viewPager = view.viewPagerAllProducts
        viewPager.adapter = adapterTabAllProductsTabLayout


        activity=requireActivity() as MainActivity

        activity.imageBasket.setOnClickListener {
            Log.d("ttt", "imageBasket")

            view.findNavController().navigate(R.id.action_nav_all_product_to_nav_basket)
        }

        activity.imageStar.setOnClickListener {
            Log.d("ttt", "imageStar")
//            navController.popBackStack()
          view.findNavController().navigate(R.id.action_nav_all_product_to_favouriteFragment)
        }


        val tabLayout = view.tabLayoutAllProducts
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            when (position) {
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


        val toast = Toast.makeText(
            requireContext(),
            "Press again to exit..",
            Toast.LENGTH_SHORT
        )

        toast.show()

        val handler = Handler()
        handler.postDelayed(Runnable { toast.cancel() }, 500)
    }



}