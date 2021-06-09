package com.example.myagent.ui.category

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myagent.R
import kotlinx.android.synthetic.main.item_view_pager2_category.*

class ViewPager2CategoryFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_view_pager2_category, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            imageViewPager2Top.setImageResource(it.getInt("color"))
        }
    }

    companion object {
        fun newInstance(color: Int): ViewPager2CategoryFragment {
            val fragment = ViewPager2CategoryFragment()
            fragment.arguments = Bundle().apply {
                putInt("color", color)
            }

            return fragment
        }
    }
}