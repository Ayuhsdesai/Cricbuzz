package com.example.cricbuzzz.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cricbuzzz.Match_Score
import com.example.cricbuzzz.R
import com.example.cricbuzzz.ScoreData
import com.example.example.Matches

class ScoreAdapter(val score: ArrayList<Matches>, val matchScore: Match_Score) :
    RecyclerView.Adapter<ScoreAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val match: TextView = view.findViewById(R.id.match_title)
        val team1: TextView = view.findViewById(R.id.team1)
        val team2: TextView = view.findViewById(R.id.team2)
        val score1: TextView = view.findViewById(R.id.score1)
        val score2: TextView = view.findViewById(R.id.score2)
        val status: TextView = view.findViewById(R.id.status)
        val wickets1: TextView = view.findViewById(R.id.wickets1)
        val wickets2: TextView = view.findViewById(R.id.wickets2)
        val overs1: TextView = view.findViewById(R.id.overs1)
        val overs2: TextView = view.findViewById(R.id.overs2)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(matchScore).inflate(R.layout.score, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = score.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {


        val match = score[position]
        holder.match.text = match.matchInfo!!.matchDesc
        holder.team1.text = match.matchInfo!!.team1?.teamName
        holder.team2.text = match.matchInfo!!.team2?.teamName
        holder.score1.text = " ${match.matchScore!!.team1Score?.inngs1?.runs.toString()}/"
        holder.score2.text = " ${match.matchScore!!.team2Score?.inngs1?.runs.toString()}/"
        holder.status.text = match.matchInfo!!.status
        holder.wickets1.text = match.matchScore!!.team1Score?.inngs1?.wickets.toString()
        holder.wickets2.text = match.matchScore!!.team2Score?.inngs1?.wickets.toString()
        holder.overs1.text = "(${match.matchScore!!.team1Score?.inngs1?.overs.toString()})"
        holder.overs2.text = "(${match.matchScore!!.team2Score?.inngs1?.overs.toString()})"
        holder.itemView.setOnClickListener {
            val intent = Intent(matchScore, ScoreData::class.java)
            intent.putExtra("matchId", match.matchInfo!!.matchId)
            matchScore.startActivity(intent)
        }
    }
}
