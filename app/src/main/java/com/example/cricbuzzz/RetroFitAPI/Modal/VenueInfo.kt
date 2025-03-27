package com.example.example

import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class VenueInfo(

    @SerializedName("id") var id: Int? = null,
    @SerializedName("ground") var ground: String? = null,
    @SerializedName("city") var city: String? = null,
    @SerializedName("timezone") var timezone: String? = null,
    @SerializedName("latitude") var latitude: String? = null,
    @SerializedName("longitude") var longitude: String? = null

) : Serializable