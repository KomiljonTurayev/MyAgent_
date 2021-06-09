package com.example.myagent.adapters

import android.util.Log
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.myagent.ui.category.ViewPager2CategoryFragment

class ScreenSlidePagerAdapter(activity: Fragment) : FragmentStateAdapter(activity) {

    val lists = ArrayList<Fragment>()

    fun update(list: ArrayList<Int>) {
        list.forEach {
            lists.add(ViewPager2CategoryFragment.newInstance(it))

            Log.i("pagerr", "adding")
        }

        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return lists.size
    }

    override fun createFragment(position: Int): Fragment {
        return lists[position]
    }
}