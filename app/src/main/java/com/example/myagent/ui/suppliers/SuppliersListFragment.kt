package com.example.myagent.ui.suppliers

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
import com.example.myagent.adapters.SuppliersListAdapter
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.fragment_suppliers_list.view.*

class SuppliersListFragment : Fragment() {
    lateinit var  activity: MainActivity
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.fragment_suppliers_list, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.back_arrow_favourite.setOnClickListener {
            view.findNavController().navigate(R.id.action_suppliersListFragment_to_nav_all_product)
        }
        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view_suppliers)
        recyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        val mAdapter = SuppliersListAdapter()

        mAdapter.onItemClick = {
//            findNavController().navigate(R.id.suppliersInfoFragment)
            view.findNavController().navigate(R.id.suppliersInfoFragment)

        }
        recyclerView.adapter = mAdapter
        activity=requireActivity() as MainActivity

        activity.imageBasket.setOnClickListener {
            Log.d("ttt", "imageBasket")

            view.findNavController().navigate(R.id.action_suppliersListFragment_to_nav_basket)
        }

        activity.imageStar.setOnClickListener {
            Log.d("ttt", "imageStar")
//            navController.popBackStack()
            view.findNavController().navigate(R.id.action_suppliersListFragment_to_favouriteFragment)
        }
    }
}