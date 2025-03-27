package com.example.cricbuzzz

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(activity: MainActivity) : FragmentStateAdapter(activity) {


    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {

        return when (position) {
            0 -> LiveFragment()
            1 -> RecentFragment()
            else -> LiveFragment()
        }

    }


}
