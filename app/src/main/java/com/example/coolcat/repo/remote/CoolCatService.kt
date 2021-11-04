package com.example.coolcat.repo.remote

import com.example.coolcat.constants.ENV
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface CoolCatService {
    @Headers("api_key: ${ENV.apiKey}")
    @GET("breeds")
    suspend fun getAllBreedsInfo(): Response<List<CatInfo>>
}

