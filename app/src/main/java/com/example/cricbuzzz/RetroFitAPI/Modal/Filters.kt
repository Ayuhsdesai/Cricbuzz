package com.example.example

import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class Filters(

    @SerializedName("matchType") var matchType: ArrayList<String> = arrayListOf()

) : Serializable