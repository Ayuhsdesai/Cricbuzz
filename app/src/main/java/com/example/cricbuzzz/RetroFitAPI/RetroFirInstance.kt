package com.example.cricbuzzz.RetroFitAPI

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetroFirInstance {
    fun callapi(): API {
        val retrofit = Retrofit.Builder().baseUrl("https://cricbuzz-cricket.p.rapidapi.com/")
            .addConverterFactory(GsonConverterFactory.create()).build()

        val service: API = retrofit.create(API::class.java)
        return service
    }

    fun callscore(): API {
        val retrofit = Retrofit.Builder().baseUrl("https://cricbuzz-cricket.p.rapidapi.com/")
            .addConverterFactory(GsonConverterFactory.create()).build()

        val service: API = retrofit.create(API::class.java)
        return service
    }

    fun calllive(): API {
        val retrofit = Retrofit.Builder().baseUrl("https://cricbuzz-cricket.p.rapidapi.com/")
            .addConverterFactory(GsonConverterFactory.create()).build()

        val service: API = retrofit.create(API::class.java)
        return service
    }
}