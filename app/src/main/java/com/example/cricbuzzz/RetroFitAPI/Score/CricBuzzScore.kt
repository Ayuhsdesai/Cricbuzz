package com.example.example

import com.google.gson.annotations.SerializedName


data class CricBuzzScore(

    @SerializedName("scorecard") var scorecard: ArrayList<Scorecard> = arrayListOf(),
    @SerializedName("isMatchComplete") var isMatchComplete: Boolean? = null,
    @SerializedName("appIndex") var appIndex: AppIndex? = AppIndex(),
    @SerializedName("status") var status: String? = null,
    @SerializedName("responseLastUpdated") var responseLastUpdated: String? = null

)