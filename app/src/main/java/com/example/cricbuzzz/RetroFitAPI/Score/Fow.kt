package com.example.example

import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class Fow(

    @SerializedName("fow") var fow: ArrayList<Fow> = arrayListOf()

) : Serializable