package com.example.cricbuzzz

import ScoreAdapter
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.cricbuzzz.databinding.ActivityMatchScoreBinding
import com.example.example.SeriesMatches

class Match_Score : AppCompatActivity() {

    lateinit var binding: ActivityMatchScoreBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMatchScoreBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val score: SeriesMatches = intent.getSerializableExtra("seriesMatches") as SeriesMatches

        binding.scoreview.adapter = ScoreAdapter(score.seriesAdWrapper!!.matches, this)
    }
}