package com.example.cricbuzzz

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cricbuzzz.RetroFitAPI.RetroFirInstance
import com.example.cricbuzzz.adapter.InfoAdapter
import com.example.example.CricBuzzMain
import com.example.example.TypeMatches
import com.google.android.material.tabs.TabLayout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class RecentFragment : Fragment() {

    private var matchList = ArrayList<TypeMatches>()
    private lateinit var seriesAdapter: InfoAdapter
    private lateinit var recyclerView: androidx.recyclerview.widget.RecyclerView
    private lateinit var tabLayout: TabLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_recent, container, false)

        recyclerView = view.findViewById(R.id.recyclerView)
        tabLayout = view.findViewById(R.id.tabLayout)

        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        callapi()

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                tab?.let { filterMatches(it.text.toString()) }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {}
            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })

        return view
    }

    private fun callapi() {
        RetroFirInstance().callapi().GetCricApii().enqueue(object : Callback<CricBuzzMain> {
            override fun onResponse(call: Call<CricBuzzMain>, response: Response<CricBuzzMain>) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        matchList = it.typeMatches
                        filterMatches("International") // Default filter
                    }
                }
            }

            override fun onFailure(call: Call<CricBuzzMain>, t: Throwable) {
                // Handle failure case
            }
        })
    }

    private fun filterMatches(category: String) {
        val filteredTypeMatch = matchList.find { it.matchType.equals(category, ignoreCase = true) }
        val filteredSeriesMatches = filteredTypeMatch?.seriesMatches ?: arrayListOf()
//        filteredSeriesMatches.forEach {
//            Log.d("==-==", "filterMatches: ${it.seriesAdWrapper?.seriesName}")
//        }

        filteredSeriesMatches.removeAll { it.seriesAdWrapper?.seriesName == null }

        seriesAdapter = InfoAdapter(requireContext(), filteredSeriesMatches)
        recyclerView.adapter = seriesAdapter
    }
}