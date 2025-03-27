package com.example.example

import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class Extras(

    @SerializedName("legByes") var legByes: Int? = null,
    @SerializedName("wides") var wides: Int? = null,
    @SerializedName("total") var total: Int? = null

) : Serializable