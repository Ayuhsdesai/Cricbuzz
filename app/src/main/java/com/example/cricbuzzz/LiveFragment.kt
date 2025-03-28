package com.example.cricbuzzz

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.cricbuzzz.RetroFitAPI.RetroFirInstance
import com.example.cricbuzzz.adapter.InfoAdapter
import com.example.example.CricBuzzMain
import com.example.example.SeriesMatches
import com.example.example.TypeMatches
import com.google.android.material.tabs.TabLayout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LiveFragment : Fragment() {

    private var matchList = ArrayList<TypeMatches>()
    private lateinit var seriesAdapter: InfoAdapter
    private lateinit var recyclerView: androidx.recyclerview.widget.RecyclerView
    private lateinit var tabLayout: TabLayout
    private lateinit var noMatchText: TextView
    private lateinit var swipeRefreshLayout: SwipeRefreshLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_live, container, false)

        recyclerView = view.findViewById(R.id.recyclerView)
        tabLayout = view.findViewById(R.id.tabLayout)
        noMatchText = view.findViewById(R.id.noMatchText)
        swipeRefreshLayout = view.findViewById(R.id.swipeRefreshLayout)

        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        callApi()

        swipeRefreshLayout.setOnRefreshListener {
            callApi()
        }

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                tab?.let { filterMatches(it.text.toString()) }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {}
            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })

        return view
    }

    private fun callApi() {
        swipeRefreshLayout.isRefreshing = true

        RetroFirInstance().calllive().getliveapi().enqueue(object : Callback<CricBuzzMain> {
            override fun onResponse(call: Call<CricBuzzMain>, response: Response<CricBuzzMain>) {
                swipeRefreshLayout.isRefreshing = false

                if (response.isSuccessful) {
                    response.body()?.let {
                        matchList = it.typeMatches
                        filterMatches("International")
                    }
                } else {
                    showError("Failed to load data")
                }
            }

            override fun onFailure(call: Call<CricBuzzMain>, t: Throwable) {
                swipeRefreshLayout.isRefreshing = false
                showError("Failed to load data")
            }
        })
    }

    private fun filterMatches(category: String) {
        val filteredTypeMatch = matchList.find { it.matchType.equals(category, ignoreCase = true) }
        val filteredSeriesMatches: ArrayList<SeriesMatches> =
            filteredTypeMatch?.seriesMatches ?: arrayListOf()

        filteredSeriesMatches.removeAll { it.seriesAdWrapper?.seriesName == null }

        if (filteredSeriesMatches.isEmpty()) {
            showError("No matches available")
        } else {
            noMatchText.visibility = View.GONE
            recyclerView.visibility = View.VISIBLE
            seriesAdapter = InfoAdapter(requireContext(), filteredSeriesMatches)
            recyclerView.adapter = seriesAdapter
        }
    }

    private fun showError(message: String) {
        noMatchText.visibility = View.VISIBLE
        noMatchText.text = message
        recyclerView.visibility = View.GONE
    }
}