package com.example.cricbuzzz

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cricbuzzz.RetroFitAPI.RetroFirInstance
import com.example.cricbuzzz.databinding.ActivityScoreDataBinding
import com.example.example.Batsman
import com.example.example.Bowler
import com.example.example.CricBuzzScore
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ScoreData : AppCompatActivity() {

    private lateinit var binding: ActivityScoreDataBinding

    private lateinit var battingAdapter1: BatsmanAdapter
    private lateinit var bowlingAdapter1: BowlerAdapter
    private lateinit var battingAdapter2: BatsmanAdapter
    private lateinit var bowlingAdapter2: BowlerAdapter

    private val battingList1 = ArrayList<Batsman>()
    private val bowlingList1 = ArrayList<Bowler>()
    private val battingList2 = ArrayList<Batsman>()
    private val bowlingList2 = ArrayList<Bowler>()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize View Binding
        binding = ActivityScoreDataBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set RecyclerView Layout Managers
        binding.teamABatsmanRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.teamBBowlerRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.teamBBatsmanRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.teamABowlerRecyclerView.layoutManager = LinearLayoutManager(this)

        // Initialize Adapters
        battingAdapter1 = BatsmanAdapter(battingList1, this)
        bowlingAdapter1 = BowlerAdapter(bowlingList1, this)
        battingAdapter2 = BatsmanAdapter(battingList2, this)
        bowlingAdapter2 = BowlerAdapter(bowlingList2, this)

        // Set Adapters
        binding.teamABatsmanRecyclerView.adapter = battingAdapter1
        binding.teamBBowlerRecyclerView.adapter = bowlingAdapter1
        binding.teamBBatsmanRecyclerView.adapter = battingAdapter2
        binding.teamABowlerRecyclerView.adapter = bowlingAdapter2

        // Get Match ID from Intent
        val matchId = intent.getIntExtra("matchId", 0)
        if (matchId != 0) {
            callScoreApi(matchId)
        } else {
            Toast.makeText(this, "Invalid match ID", Toast.LENGTH_SHORT).show()
        }
    }

    private fun callScoreApi(matchId: Int) {
        RetroFirInstance().callscore().getMatchScore(matchId)
            .enqueue(object : Callback<CricBuzzScore> {
                @SuppressLint("NotifyDataSetChanged")
                override fun onResponse(
                    call: Call<CricBuzzScore>, response: Response<CricBuzzScore>
                ) {
                    if (response.isSuccessful) {
                        val matchData = response.body()
                        Log.d("API_RESPONSE", "Match Details: ${Gson().toJson(matchData)}")

                        matchData?.let { data ->
                            binding.matchStatus.text = data.status ?: "Status Unavailable"


                            if (data.scorecard.isNotEmpty()) {
                                val firstInnings = data.scorecard[0]


                                binding.teamABattingHeader.text =
                                    "${firstInnings.batTeamName} Batting"
                                binding.teamABowlingHeader.text =
                                    "${firstInnings.batTeamName} Bowling"

                                binding.teamScore1.text =
                                    "${firstInnings.batTeamName} ${firstInnings.score}/${firstInnings.wickets}"


                                // Update Batting & Bowling Lists
                                battingList1.clear()
                                bowlingList1.clear()
                                firstInnings.batsman.let {
                                    val filteredBatsmen =
                                        it.filter { batsman -> batsman.balls != null && batsman.runs != null }
                                    battingList1.addAll(filteredBatsmen)
                                }
                                firstInnings.bowler.let { bowlingList1.addAll(it) }

                                battingAdapter1.notifyDataSetChanged()
                                bowlingAdapter1.notifyDataSetChanged()

                                binding.teamABatsmanRecyclerView.visibility = View.VISIBLE
                                binding.teamABowlerRecyclerView.visibility = View.VISIBLE

                                if (data.scorecard.size > 1) {
                                    val secondInnings = data.scorecard[1]

                                    binding.teamScore2.text =
                                        "${secondInnings.batTeamName} ${secondInnings.score}/${secondInnings.wickets}"

                                    binding.teamBBattingHeader.text =
                                        "${secondInnings.batTeamName} Batting"
                                    binding.teamBBowlingHeader.text =
                                        "${secondInnings.batTeamName} Bowling"

                                    battingList2.clear()
                                    bowlingList2.clear()
                                    secondInnings.batsman.let {
                                        val filteredBatsmen =
                                            it.filter { batsman -> batsman.balls != null && batsman.runs != null }
                                        battingList2.addAll(filteredBatsmen)
                                    }
                                    secondInnings.bowler.let { bowlingList2.addAll(it) }

                                    battingAdapter2.notifyDataSetChanged()
                                    bowlingAdapter2.notifyDataSetChanged()

                                    binding.teamBBatsmanRecyclerView.visibility = View.VISIBLE
                                    binding.teamBBowlerRecyclerView.visibility = View.VISIBLE
                                    binding.teamBBattingHeader.visibility = View.VISIBLE
                                    binding.teamBBowlingHeader.visibility = View.VISIBLE
                                } else {
                                    binding.teamBBatsmanRecyclerView.visibility = View.GONE
                                    binding.teamBBowlerRecyclerView.visibility = View.GONE
                                    binding.teamBBattingHeader.visibility = View.GONE
                                    binding.teamBBowlingHeader.visibility = View.GONE
                                }
                            }

                        }
                    } else {
                        Log.e("API_ERROR", "Error: ${response.errorBody()?.string()}")
                    }
                }

                override fun onFailure(call: Call<CricBuzzScore>, t: Throwable) {
                    Log.e("API_FAILURE", "onFailure: ${t.localizedMessage}")
                }
            })
    }
}
