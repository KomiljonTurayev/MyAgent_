package com.example.myagent.ui.questions

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myagent.MainActivity
import com.example.myagent.R
import com.example.myagent.adapters.YoutubeAdapter
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.fragment_how_does_it_works.view.*

class HowDoesItWorksFragment : Fragment() {
    lateinit var  activity: MainActivity
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_how_does_it_works, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerview = view.findViewById<RecyclerView>(R.id.recycler_view_video_view)
        recyclerview.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        recyclerview.adapter = YoutubeAdapter()
        view.back_arrow_how_does_it.setOnClickListener {
            view.findNavController().navigate(R.id.action_howDoesItWorksFragment_to_nav_all_product)
        }
        activity=requireActivity() as MainActivity

        activity.imageBasket.setOnClickListener {
            Log.d("ttt", "imageBasket")

            view.findNavController().navigate(R.id.action_howDoesItWorksFragment_to_nav_basket)
        }

        activity.imageStar.setOnClickListener {
            Log.d("ttt", "imageStar")
//            navController.popBackStack()
            view.findNavController().navigate(R.id.action_howDoesItWorksFragment_to_favouriteFragment)
        }
    }
}