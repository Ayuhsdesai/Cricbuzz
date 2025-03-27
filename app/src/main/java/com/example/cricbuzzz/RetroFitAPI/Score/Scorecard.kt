package com.example.example

import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class Scorecard(

    @SerializedName("inningsId") var inningsId: Int? = null,
    @SerializedName("batsman") var batsman: ArrayList<Batsman> = arrayListOf(),
    @SerializedName("bowler") var bowler: ArrayList<Bowler> = arrayListOf(),
    @SerializedName("fow") var fow: Fow? = Fow(),
    @SerializedName("extras") var extras: Extras? = Extras(),
    @SerializedName("pp") var pp: Pp? = Pp(),
    @SerializedName("score") var score: Int? = null,
    @SerializedName("wickets") var wickets: Int? = null,
    @SerializedName("overs") var overs: Float? = null,
    @SerializedName("runRate") var runRate: Float? = null,
    @SerializedName("batTeamName") var batTeamName: String? = null,
    @SerializedName("batTeamSName") var batTeamSName: String? = null,
    @SerializedName("ballNbr") var ballNbr: Int? = null,
    @SerializedName("rpb") var rpb: Double? = null,
    @SerializedName("partnership") var partnership: Partnership? = Partnership()

) : Serializable