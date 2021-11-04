package com.example.coolcat.repo

import com.example.coolcat.repo.remote.CatInfo
import com.example.coolcat.repo.remote.RetrofitInstance
import retrofit2.Response

object CoolCatRepo {
    suspend fun getCatBreedsInfo(): Response<List<CatInfo>> {
        return RetrofitInstance.coolCatService.getAllBreedsInfo()
    }
}