package com.example.coolcat.repo.remote

import com.squareup.moshi.JsonClass

@JsonClass (generateAdapter = true) data class CatInfo (
    val id: String,
    val name: String,
    val image: CatImage?
)

@JsonClass (generateAdapter = true) data class CatImage (
    val id: String?,
    val url: String?,
    val width: Int?,
    val height: Int?
)