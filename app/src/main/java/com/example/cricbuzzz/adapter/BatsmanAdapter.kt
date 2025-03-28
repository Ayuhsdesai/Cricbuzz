package com.example.cricbuzzz.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cricbuzzz.R
import com.example.cricbuzzz.ScoreData
import com.example.example.Batsman

class BatsmanAdapter(private val batsmen: List<Batsman>, private val scoredata: ScoreData) :
    RecyclerView.Adapter<BatsmanAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val batsmanName: TextView = view.findViewById(R.id.batsmanName)
        val batsmanRuns: TextView = view.findViewById(R.id.batsmanRuns)
        val batsmanBalls: TextView = view.findViewById(R.id.batsmanBalls)
        val batsmanStrikeRate: TextView = view.findViewById(R.id.batsmanStrikeRate)
        val batsmanFours: TextView = view.findViewById(R.id.batsmanFours)
        val batsmanSixes: TextView = view.findViewById(R.id.batsmanSixes)
        val outStatus: TextView = view.findViewById(R.id.outStatus)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(scoredata).inflate(R.layout.batsman_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val batsman = batsmen[position]
        holder.batsmanName.text = batsman.name ?: "N/A"
        holder.batsmanRuns.text = "${batsman.runs ?: 0}"
        holder.batsmanBalls.text = "${batsman.balls ?: 0}"
        holder.batsmanStrikeRate.text = "${batsman.strkRate ?: "0.0"}"
        holder.batsmanFours.text = "${batsman.fours ?: 0}"
        holder.batsmanSixes.text = "${batsman.six ?: 0}"
        holder.outStatus.text = batsman.outDec
    }

    override fun getItemCount(): Int = batsmen.size
}