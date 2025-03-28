package com.example.cricbuzzz.RetroFitAPI

import com.example.example.CricBuzzMain
import com.example.example.CricBuzzScore
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface API {

    @Headers(
        "x-rapidapi-key: 8904b7b3edmsh0978b2168ec86e0p152fe6jsnb29b43dbf03d",
        "x-rapidapi-host: cricbuzz-cricket.p.rapidapi.com"
    )
    @GET("matches/v1/recent")
    fun GetCricApii(): Call<CricBuzzMain>

    @Headers(
        "x-rapidapi-key: 8904b7b3edmsh0978b2168ec86e0p152fe6jsnb29b43dbf03d",
        "x-rapidapi-host: cricbuzz-cricket.p.rapidapi.com"
    )
    @GET("matches/v1/live")
    fun getliveapi(): Call<CricBuzzMain>

    @Headers(
        "x-rapidapi-key: 8904b7b3edmsh0978b2168ec86e0p152fe6jsnb29b43dbf03d",
        "x-rapidapi-host: cricbuzz-cricket.p.rapidapi.com"
    )
    @GET("mcenter/v1/{matchId}/scard")
    fun getMatchScore(@Path("matchId") matchId: Int): Call<CricBuzzScore>


}