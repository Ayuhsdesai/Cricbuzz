package com.example.example

import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class Team1Score(

    @SerializedName("inngs1") var inngs1: Inngs1? = Inngs1()

) : Serializable