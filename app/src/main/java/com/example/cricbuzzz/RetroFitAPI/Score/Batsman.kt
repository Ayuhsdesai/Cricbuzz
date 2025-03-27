package com.example.example

import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class Batsman(

    @SerializedName("id") var id: Int? = null,
    @SerializedName("balls") var balls: Int? = null,
    @SerializedName("runs") var runs: Int? = null,
    @SerializedName("sixes") var six: Int? = null,
    @SerializedName("fours") var fours: Int? = null,
    @SerializedName("strkRate") var strkRate: String? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("isKeeper") var isKeeper: Boolean? = null,
    @SerializedName("outDec") var outDec: String? = null

) : Serializable