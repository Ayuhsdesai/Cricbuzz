package com.example.example

import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class Matches(

    @SerializedName("matchInfo") var matchInfo: MatchInfo? = MatchInfo(),
    @SerializedName("matchScore") var matchScore: MatchScore? = MatchScore()

) : Serializable