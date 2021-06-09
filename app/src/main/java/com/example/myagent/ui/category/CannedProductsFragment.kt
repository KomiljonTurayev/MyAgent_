package com.example.myagent.ui.category

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myagent.R
import com.example.myagent.adapters.CannedFoodAdapter
import kotlinx.android.synthetic.main.fragment_canned_products.view.*


class CannedProductsFragment : Fragment() {
    private var nextFragmnet=SelectedProductInfoFragment()
    private lateinit var adapter:CannedFoodAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View=inflater.inflate(R.layout.fragment_canned_products, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val spinner:Spinner=view.findViewById(R.id.spinner_1)
        ArrayAdapter.createFromResource(
            requireContext(),
R.array.category,  android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinner.adapter = adapter }

        val recyclerView=view.findViewById<RecyclerView>(R.id.recycler_view_canned_food)
        recyclerView.layoutManager=LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
        adapter= CannedFoodAdapter()
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
        view.back_arrow_cannedFood.setOnClickListener {
            view.findNavController().popBackStack()
        }



    }


}