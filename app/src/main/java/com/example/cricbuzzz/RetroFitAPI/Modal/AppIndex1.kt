package com.example.example

import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class AppIndex1(

    @SerializedName("seoTitle") var seoTitle: String? = null,
    @SerializedName("webURL") var webURL: String? = null

) : Serializable