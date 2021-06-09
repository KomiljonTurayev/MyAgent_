package com.example.myagent.ui.basket

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myagent.MainActivity
import com.example.myagent.R
import com.example.myagent.adapters.BasketAdapter
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.fragment_basket.*
import kotlinx.android.synthetic.main.fragment_basket.view.*

class BasketFragment : Fragment() {
    lateinit var  activity: MainActivity


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_basket, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerBasket)

        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val mAdapter = BasketAdapter()

        recyclerView.adapter = mAdapter

        activity=requireActivity() as MainActivity

        activity.imageBasket.setOnClickListener {
            Log.d("ttt", "imageBasket")

//            view.findNavController().popBackStack()
        }

        activity.imageStar.setOnClickListener {
            Log.d("ttt", "imageStar")
//            navController.popBackStack()
            view.findNavController().navigate(R.id.action_nav_basket_to_favouriteFragment)
        }

        btnOrder.setOnClickListener {
            view.findNavController().navigate(R.id.nav_history_order)
        }
        view.imageBackHomeBasket.setOnClickListener {
            view.findNavController().navigate(R.id.action_nav_basket_to_nav_all_product)
        }
    }

//    override fun onStop() {
//        Log.d("ttt","onStop basket")
//        super.onStop()
//    }

}