package com.example.example

import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class Partnership(

    @SerializedName("partnership") var partnership: ArrayList<Partnership> = arrayListOf()

) : Serializable