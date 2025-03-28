package com.example.cricbuzzz.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.cricbuzzz.LiveFragment
import com.example.cricbuzzz.MainActivity
import com.example.cricbuzzz.RecentFragment

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
