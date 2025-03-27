package com.example.example

import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class MatchScore(

    @SerializedName("team1Score") var team1Score: Team1Score? = Team1Score(),
    @SerializedName("team2Score") var team2Score: Team2Score? = Team2Score()

) : Serializable