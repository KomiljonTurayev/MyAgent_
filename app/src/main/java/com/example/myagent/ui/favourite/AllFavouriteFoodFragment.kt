package com.example.myagent.ui.favourite

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
import com.example.myagent.adapters.FavouriteRecyclerAdapter
import com.example.myagent.ui.category.SelectedProductInfoFragment

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AllFavouriteFoodFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AllFavouriteFoodFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var nextFragmnet= SelectedProductInfoFragment()
    private lateinit var adapter: FavouriteRecyclerAdapter

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
        val view: View=inflater.inflate(R.layout.fragment_all_favourite_food, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerview=view.findViewById<RecyclerView>(R.id.recycler_view_favourite_all)
        recyclerview.layoutManager=LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
        adapter=FavouriteRecyclerAdapter()
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