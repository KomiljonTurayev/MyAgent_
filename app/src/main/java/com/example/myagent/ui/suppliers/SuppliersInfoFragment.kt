package com.example.myagent.ui.suppliers

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
import kotlinx.android.synthetic.main.fragment_suppliers_info.view.*


class SuppliersInfoFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View=inflater.inflate(R.layout.fragment_suppliers_info, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView=view.findViewById<RecyclerView>(R.id.recycler_view_suppliers_info)
        recyclerView.layoutManager=LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false)
        recyclerView.adapter=AllProductsAdapter()

        view.back_arrow_support.setOnClickListener {
            view.findNavController().popBackStack()
        }
    }



}