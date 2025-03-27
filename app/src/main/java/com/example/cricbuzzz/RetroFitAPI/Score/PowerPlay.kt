package com.example.example

import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class PowerPlay(

    @SerializedName("id") var id: Int? = null,
    @SerializedName("ovrFrom") var ovrFrom: Double? = null,
    @SerializedName("ovrTo") var ovrTo: Int? = null,
    @SerializedName("ppType") var ppType: String? = null,
    @SerializedName("run") var run: Int? = null

) : Serializable