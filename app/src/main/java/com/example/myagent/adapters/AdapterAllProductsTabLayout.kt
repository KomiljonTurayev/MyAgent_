package com.example.myagent.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.myagent.ui.allproducts.AllCategoryFragment
import com.example.myagent.ui.allproducts.FoodFragment
import com.example.myagent.ui.allproducts.NonFoodFragment

class AdapterAllProductsTabLayout(fa: Fragment) : FragmentStateAdapter(fa) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> {
                AllCategoryFragment()
            }
            1 -> {
                FoodFragment()
            }
            2->{
                NonFoodFragment()
            }
            else -> AllCategoryFragment()
        }
    }
}