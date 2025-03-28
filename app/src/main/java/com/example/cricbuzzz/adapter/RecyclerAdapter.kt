package com.example.cricbuzzz.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cricbuzzz.Matches_Info
import com.example.cricbuzzz.R
import com.example.example.TypeMatches

class RecyclerAdapter(
    private val matchlist: ArrayList<TypeMatches>, val mainActivity: Context
) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val matchType: TextView = view.findViewById(R.id.matchtype)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(mainActivity).inflate(R.layout.matchtype, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return matchlist.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val match = matchlist[position]
        holder.matchType.text = match.matchType
        holder.itemView.setOnClickListener {
            val intent = Intent(mainActivity, Matches_Info::class.java)
            intent.putExtra("matchType", matchlist[position])

            mainActivity.startActivity(intent)

        }
    }
}
