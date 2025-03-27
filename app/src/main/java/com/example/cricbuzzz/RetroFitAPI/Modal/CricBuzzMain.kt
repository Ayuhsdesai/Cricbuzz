package com.example.example

import com.google.gson.annotations.SerializedName


data class CricBuzzMain(

    @SerializedName("typeMatches") var typeMatches: ArrayList<TypeMatches> = arrayListOf(),
    @SerializedName("filters") var filters: Filters? = Filters(),
    @SerializedName("appIndex") var appIndex: AppIndex1 = AppIndex1(),
    @SerializedName("responseLastUpdated") var responseLastUpdated: String? = null

)