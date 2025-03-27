package com.example.example

import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class SeriesAdWrapper(

    @SerializedName("seriesId") var seriesId: Int? = null,
    @SerializedName("seriesName") var seriesName: String? = null,
    @SerializedName("matches") var matches: ArrayList<Matches> = arrayListOf()

) : Serializable

data class adDetail(

    @SerializedName("name") var name: String? = null,
    @SerializedName("layout") var layout: String? = null,
    @SerializedName("position") var position: Int? = null,

    ) : Serializable
