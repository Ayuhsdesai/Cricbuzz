package com.example.example

import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class MatchInfo(

    @SerializedName("matchId") var matchId: Int? = null,
    @SerializedName("seriesId") var seriesId: Int? = null,
    @SerializedName("seriesName") var seriesName: String? = null,
    @SerializedName("matchDesc") var matchDesc: String? = null,
    @SerializedName("matchFormat") var matchFormat: String? = null,
    @SerializedName("startDate") var startDate: String? = null,
    @SerializedName("endDate") var endDate: String? = null,
    @SerializedName("state") var state: String? = null,
    @SerializedName("status") var status: String? = null,
    @SerializedName("team1") var team1: Team1? = Team1(),
    @SerializedName("team2") var team2: Team2? = Team2(),
    @SerializedName("venueInfo") var venueInfo: VenueInfo? = VenueInfo(),
    @SerializedName("currBatTeamId") var currBatTeamId: Int? = null,
    @SerializedName("seriesStartDt") var seriesStartDt: String? = null,
    @SerializedName("seriesEndDt") var seriesEndDt: String? = null,
    @SerializedName("isTimeAnnounced") var isTimeAnnounced: Boolean? = null,
    @SerializedName("stateTitle") var stateTitle: String? = null,
    @SerializedName("isFantasyEnabled") var isFantasyEnabled: Boolean? = null

) : Serializable