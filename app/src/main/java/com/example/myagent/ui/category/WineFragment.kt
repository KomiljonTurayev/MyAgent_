package com.example.myagent.ui.category

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myagent.R
import com.example.myagent.adapters.WineAdapter
import kotlinx.android.synthetic.main.fragment_wine.view.*

class WineFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_wine, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.imageBackHome_vine.setOnClickListener {
            view.findNavController().popBackStack()
        }

        val recyclerWine = view.findViewById<RecyclerView>(R.id.recyclerWine)

        recyclerWine.layoutManager =
            GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false)

        val mAdapter = WineAdapter()

        mAdapter.onItemClick = {

            findNavController().navigate(R.id.cannedProductsFragment)
        }

        recyclerWine.adapter = mAdapter

        val spinner: Spinner = view.findViewById(R.id.planets_spinner)
        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.drink_filtr,
            R.layout.spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }


    }
}