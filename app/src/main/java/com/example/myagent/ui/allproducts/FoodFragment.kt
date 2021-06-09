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

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FoodFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FoodFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var adapter: AllProductsAdapter
    private var nextFragmnet= SelectedProductInfoFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View=inflater.inflate(R.layout.fragment_food, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recylerview=view.findViewById<RecyclerView>(R.id.recycler_view_food)
        recylerview.layoutManager=LinearLayoutManager(context,LinearLayoutManager.VERTICAL, false)
        adapter=AllProductsAdapter()
        recylerview.adapter=adapter
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

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FoodFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FoodFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}