package com.example.myagent.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.myagent.ui.favourite.AllFavouriteFoodFragment
import com.example.myagent.ui.favourite.FavouriteFoodFragment
import com.example.myagent.ui.favourite.FavouriteNonFoodFragment

class FavouriteAdapter(fa: Fragment): FragmentStateAdapter(fa) {

    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0->{
                AllFavouriteFoodFragment()
            }
            1->{
                FavouriteFoodFragment()
            }
            2->{
                FavouriteNonFoodFragment()
            }
            else->{
                AllFavouriteFoodFragment()
            }
        }
    }
}