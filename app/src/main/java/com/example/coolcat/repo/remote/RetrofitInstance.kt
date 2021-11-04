package com.example.coolcat.repo.remote

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitInstance {

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://api.thecatapi.com/v1/")
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    val coolCatService: CoolCatService = retrofit.create(CoolCatService::class.java)
}