package com.example.cricbuzzz

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cricbuzzz.adapter.InfoAdapter
import com.example.cricbuzzz.databinding.ActivityMatchesInfoBinding
import com.example.example.SeriesMatches
import com.example.example.TypeMatches

class Matches_Info : AppCompatActivity() {

    private lateinit var binding: ActivityMatchesInfoBinding
    private var newlist = ArrayList<SeriesMatches>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMatchesInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Retrieve data safely
        val matchType = intent.getSerializableExtra("matchType") as? TypeMatches

        if (matchType != null) {
            for (item in matchType.seriesMatches) {
                // Safe null checks
                item.seriesAdWrapper?.seriesName?.let {
                    newlist.add(item)
                }
            }
        }

        // Debugging: Check filtered list
        Log.e("Filtered List", "Size: ${newlist.size}, Data: $newlist")

        // Set up RecyclerView
        binding.info.layoutManager = LinearLayoutManager(this)
        binding.info.adapter = InfoAdapter(this, newlist)
    }
}
