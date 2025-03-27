package com.example.example

import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class SeriesMatches(

    @SerializedName("seriesAdWrapper") var seriesAdWrapper: SeriesAdWrapper? = SeriesAdWrapper(),
    @SerializedName("adDetail") var adDetail: adDetail = adDetail()


) : Serializable