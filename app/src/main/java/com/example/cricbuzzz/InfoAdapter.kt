package com.example.cricbuzzz

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.example.SeriesMatches

class InfoAdapter(
    val matchesScore: Context, val seriesMatches: List<SeriesMatches>
) : RecyclerView.Adapter<InfoAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val series: TextView = view.findViewById(R.id.seriesName)
        val match: TextView = view.findViewById(R.id.match)
        val teamname: TextView = view.findViewById(R.id.teamname)
        val teamname2: TextView = view.findViewById(R.id.teamname2)
        val Status: TextView = view.findViewById(R.id.status)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.info, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = seriesMatches.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val seriesMatch = seriesMatches[position]

//        if (seriesMatch.seriesAdWrapper?.seriesName == null) {
//            holder.itemView.visibility = View.GONE
//            return
//        }
//        holder.itemView.visibility = View.VISIBLE
//        Log.d("==-==", "onBindViewHolder: ${seriesMatch.seriesAdWrapper?.seriesName}")

        val matchList = seriesMatch.seriesAdWrapper?.matches
        if (matchList.isNullOrEmpty()) {
            return
        }
        val match = matchList[0]

        holder.series.text = seriesMatch.seriesAdWrapper!!.seriesName
        holder.match.text = match.matchInfo?.matchDesc
        holder.Status.text = match.matchInfo?.status
        holder.teamname.text = match.matchInfo?.team1?.teamName
        holder.teamname2.text = match.matchInfo?.team2?.teamName
        holder.itemView.setOnClickListener {
            val intent = Intent(matchesScore, Match_Score::class.java)
            intent.putExtra("seriesMatches", seriesMatches[position])
            matchesScore.startActivity(intent)
        }
    }
}

