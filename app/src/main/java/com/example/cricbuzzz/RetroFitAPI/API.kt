package com.example.cricbuzzz.RetroFitAPI

import com.example.example.CricBuzzMain
import com.example.example.CricBuzzScore
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface API {

    @Headers(
        "x-rapidapi-key: a80317ab49msh23f35a6a33f42c5p15d390jsn41cf3807a3bc",
        "x-rapidapi-host: cricbuzz-cricket.p.rapidapi.com"
    )
    @GET("matches/v1/recent")
    fun GetCricApii(): Call<CricBuzzMain>

    @Headers(
        "x-rapidapi-key: a80317ab49msh23f35a6a33f42c5p15d390jsn41cf3807a3bc",
        "x-rapidapi-host: cricbuzz-cricket.p.rapidapi.com"
    )
    @GET("matches/v1/live")
    fun getliveapi(): Call<CricBuzzMain>

    @Headers(
        "x-rapidapi-key: a80317ab49msh23f35a6a33f42c5p15d390jsn41cf3807a3bc",
        "x-rapidapi-host: cricbuzz-cricket.p.rapidapi.com"
    )
    @GET("mcenter/v1/{matchId}/scard")
    fun getMatchScore(@Path("matchId") matchId: Int): Call<CricBuzzScore>


}