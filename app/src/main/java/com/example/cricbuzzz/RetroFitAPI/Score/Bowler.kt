package com.example.example

import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class Bowler(

    @SerializedName("id") var id: Int? = null,
    @SerializedName("overs") var overs: String? = null,
    @SerializedName("wickets") var wickets: Int? = null,
    @SerializedName("runs") var runs: Int? = null,
    @SerializedName("economy") var economy: Float? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("balls") var balls: Int? = null

) : Serializable