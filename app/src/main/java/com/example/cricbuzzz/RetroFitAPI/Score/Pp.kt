package com.example.example

import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class Pp(

    @SerializedName("powerPlay") var powerPlay: ArrayList<PowerPlay> = arrayListOf()

) : Serializable