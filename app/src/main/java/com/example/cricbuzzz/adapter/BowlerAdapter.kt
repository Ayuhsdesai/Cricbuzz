package com.example.cricbuzzz.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cricbuzzz.R
import com.example.cricbuzzz.ScoreData
import com.example.example.Bowler

class BowlerAdapter(private val bowlerList: List<Bowler>, private val scoredata: ScoreData) :
    RecyclerView.Adapter<BowlerAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val bowlerName: TextView = view.findViewById(R.id.bowlerName)
        val bowlerOvers: TextView = view.findViewById(R.id.bowlerOvers)
        val bowlerRuns: TextView = view.findViewById(R.id.bowlerRuns)
        val bowlerWickets: TextView = view.findViewById(R.id.bowlerWickets)
        val bowlerEconomy: TextView = view.findViewById(R.id.bowlerEconomy)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(scoredata).inflate(R.layout.bowler_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val bowler = bowlerList[position]

        holder.bowlerName.text = bowler.name ?: "N/A"
        holder.bowlerOvers.text = "${bowler.overs ?: "0.0"}"
        holder.bowlerRuns.text = "${bowler.runs ?: "0"}"
        holder.bowlerWickets.text = "${bowler.wickets ?: "0"}"
        holder.bowlerEconomy.text = "${bowler.economy ?: "0.0"}"
    }

    override fun getItemCount(): Int = bowlerList.size
}
