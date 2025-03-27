package com.example.example

import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class Team2(

    @SerializedName("teamId") var teamId: Int? = null,
    @SerializedName("teamName") var teamName: String? = null,
    @SerializedName("teamSName") var teamSName: String? = null,
    @SerializedName("imageId") var imageId: Int? = null

) : Serializable