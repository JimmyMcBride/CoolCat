package com.example.coolcat.repo.remote

import com.example.coolcat.constants.ENV
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
//import retrofit2.http.Query

interface CoolCatService {
    @Headers("api_key: ${ENV.apiKey}")
    @GET("breeds")
    suspend fun getAllBreeds(): Response<List<CatInfo>>

//    @Headers("api_key: ${ENV.apiKey}")
//    @GET("breeds")
//    suspend fun getOneBreed(@Query("id") id: String): Response<List<CatInfo>>
}

